(defproject io.muoncore/muon-clojure "0.1.15"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["muoncore" "http://dl.bintray.com/muoncore/muon-java"]
                 ["reactor" "http://repo.spring.io/libs-release"]]
  :dependencies [[org.clojure/clojure "1.7.0-beta3"]
                 [org.clojure/clojurescript "0.0-3269"]
                 [compojure "1.3.4"]
                 [fipp "0.6.2"]
                 [congomongo "0.4.4"]
                 [org.clojure/tools.logging "0.3.1"]
                 [tailrecursion/cljson "1.0.7"]
                 [org.slf4j/slf4j-log4j12 "1.7.12"]
                 [clj-http "1.1.2"]
                 [cljs-http "0.1.35"]
                 [org.clojure/java.data "0.1.1"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/data.xml "0.0.8"]
                 [serializable-fn "1.1.4"]
                 [http-kit "2.1.18"]
                 [jayq "2.5.4"]
                 [org.omcljs/om "0.8.8"]
                 [clj-time "0.9.0"]
                 [incanter "1.5.6"]
                 [ring "1.3.2"]
                 [ring/ring-json "0.3.1"]
                 [com.basho.riak/riak-client "2.0.1" :exclusions [com.sun/tools]]
                 [org.json/json "20141113"]
                 [midje "1.6.3"]
                 [ring/ring-defaults "0.1.2"]
                 [midje "1.6.3"]
                 [uap-clj "1.0.1"]
                 [io.muoncore/muon-core "0.32"]
                 [io.muoncore/muon-transport-amqp "0.32"]
                 [io.muoncore/muon-discovery-amqp "0.32"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [stylefruits/gniazdo "0.4.0"]])
