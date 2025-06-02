(ns babag.api.mock.query
  (:require [compojure.api.sweet :refer :all]
            [cheshire.core :as json]
            [ring.util.http-response :refer [ok not-found]]
            [ring.adapter.jetty :refer [run-jetty]]
            [mount.core :refer [defstate]]
            [babag.api.mock.in-memory-smses :refer [sms-db]]
            [babag.api.config :as config]))

(defroutes query-routes
  (context "/query-sms" []
    (GET "/all" [] (json/generate-string @sms-db))
    (GET "/:id" [id]
      (if-let [sms (get @sms-db (keyword id))]
        (ok (json/generate-string sms))
        (not-found (json/generate-string {:id id}))))))

(defstate query-server
  :start (run-jetty query-routes {:port  (:port config/query)
                                  :host  (:bind-address config/query)
                                  :join? false})
  :stop (.stop query-server))

