(ns nrepl-server
  (:require nrepl.server))

(defonce *nrepl-server (atom nil))

(defn nrepl-handler []
  (require 'cider.nrepl)
  (ns-resolve 'cider.nrepl 'cider-nrepl-handler))

(defn start-nrepl-server! [port & [wrap]]
  (let [server (nrepl.server/start-server :bind    "0.0.0.0"
                                          :port    port
                                          :handler (cond-> (nrepl-handler)
                                                     wrap wrap))]
    (println "Started nREPL server on" port)
    (reset! *nrepl-server server)
    server))

(defn stop-nrepl-server! []
  (nrepl.server/stop-server @*nrepl-server))
