(ns babag.api.ctrl
  (:require [babag.api.mock.in-memory-smses :as sms]))

(defn new-sms [& args]
  (apply sms/new-sms args))

(defn sms-status [& args]
  (apply sms/sms-status args))

