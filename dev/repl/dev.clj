(ns dev
  (:require [clj-and-cljs-app.main :as app.main]
            [clojure.java.io :as io]
            [nrepl-server :refer [start-nrepl-server!]]
            [refactor-nrepl.middleware :refer [wrap-refactor]]))

(def port 9100)

(defn -main [& _args]
  (spit ".nrepl-port" (str port))
  (start-nrepl-server! port wrap-refactor)
  (.addShutdownHook (Runtime/getRuntime)
                    (Thread. #(io/delete-file ".nrepl-port")))
  (app.main/start))