(ns babag.api.dynamodb)

(defn register-id [id]
  true)

(defn put-status [& _] true)

(defn get-status [id]
  :delivered-to-provider)
