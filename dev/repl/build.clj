(ns build
  (:require [clj-and-cljs-app.main :as app.main]
            shadow.build.warnings
            [shadow.cljs.devtools.api :as shadow.api]
            [shadow.cljs.devtools.server :as shadow.server]))

(defn run
  {:shadow/requires-server true}
  []
  ;; web
  (app.main/start)
  ;; cljs
  (shadow.server/start!)
  (shadow.api/watch :app)
  ;; cleanup on ctrl+c
  (.addShutdownHook (Runtime/getRuntime)
                      (Thread. #(shadow.api/stop-worker :app))))
