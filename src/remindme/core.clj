(ns remindme.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]))

(def server (atom nil))

(defn handler [req]
  {:status 200
   :body "OK2"})

(defn -main [& args]
  (swap! server
         (fn [_]
           (jetty/run-jetty #'handler {:join? false
                                       :port 3428}))))
