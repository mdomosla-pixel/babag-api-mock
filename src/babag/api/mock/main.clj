(ns babag.api.mock.main
  (:require [mount.core :as mount]
            [babag.api.config :as config]
            [babag.api.www :refer [api-server]]
            [babag.api.mock.query :refer [query-server]])
  (:gen-class))


(defn -main []
  (mount/start
    (mount/only #{#'babag.api.www/api-server
                  #'babag.api.mock.query/query-server
                  #'babag.api.www/jar-manifest})))

