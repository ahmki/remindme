(ns remindme.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :as ring-defaults]))

(defonce server (atom nil))

(defn handler [req]
  (prn req)
  {:status 200
   :body "OK2"})

(defn start-jetty! [& _]
  (reset!
    server
    (jetty/run-jetty (ring-defaults/wrap-defaults
                       #'handler
                       ring-defaults/site-defaults)
                     {:join? false
                      :port 3428})))

(defn stop-jetty! []
  (.stop @server)
  (reset! server nil))

(defn -main [& args]
  (start-jetty!))

(stop-jetty!)