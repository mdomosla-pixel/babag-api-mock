(ns babag.api.mock.in-memory-smses
  (:require [clj-uuid :as uuid]
            [ring.util.http-response :refer [ok not-found]]
            [digest]
            [clojure.string :as str]))

(def sms-db (atom {}))

(defn new-sms
  [{:keys [user from to content provider] :as request}]
  (let [id (str (digest/sha-1 (str content "_" (uuid/v4))))]
    (swap! sms-db #(assoc % (keyword id) (assoc request :id id)))
    (ok {:id id})))

(defn sms-status [id]
  (if (contains? @sms-db (keyword id))
    (ok {:status :delivered-to-provider})
    (not-found {:id id})))


