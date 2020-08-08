(ns clj-and-cljs-app.app)

(defn ^:dev/after-load ^:export refresh []
  (println "Reloading app"))

(refresh)
