(ns muon-clojure.common
  (:use muon-clojure.utils)
  (:require [clojure.tools.logging :as log]
            [muon-clojure.rx :as rx])
  (:import (io.muoncore Muon MuonStreamGenerator)
           (io.muoncore.future MuonFuture ImmediateReturnFuture)
           (io.muoncore.transport.resource MuonResourceEvent)
           (io.muoncore.extension.amqp AmqpTransportExtension)
           (io.muoncore.extension.amqp.discovery AmqpDiscovery)
           (org.reactivestreams Publisher)
           (java.util Map)))

(defmulti decode-map #(.getContentType %))

(defmethod decode-map "application/json" [m]
  (keywordize (into {} (.getDecodedContent m))))

(defn stream-source [ms endpoint-name gen-fn]
  (.streamSource (:m ms) (str "/" endpoint-name) Map
                 (reify MuonStreamGenerator
                   (^Publisher generatePublisher [this ^Map params]
                     (log/info "streamSource" (pr-str params))
                     (rx/publisher gen-fn params)))))

(defn on-command [ms endpoint-name res-fn]
  (.onCommand (:m ms)
              (str "/" endpoint-name)
              Map
              (reify io.muoncore.MuonService$MuonCommand
                (^MuonFuture onCommand [_ ^MuonResourceEvent resource]
                  (log/info "onCommand" (pr-str (decode-map resource)))
                  (ImmediateReturnFuture. (dekeywordize
                                            (res-fn (decode-map resource))))))))

(defn on-query [ms endpoint-name res-fn]
  (.onQuery (:m ms)
            (str "/" endpoint-name)
            Map
            (reify io.muoncore.MuonService$MuonQuery
                (^MuonFuture onQuery [_ ^MuonResourceEvent resource]
                  (log/info "before onQuery" (.getDecodedContent resource))
                  (log/info "onQuery" (pr-str (decode-map resource)))
                  (let [dk (dekeywordize
                             (res-fn (decode-map resource)))]
                    (log/info "ImmediateReturnFuture." (pr-str dk))
                    (ImmediateReturnFuture. dk))))))

