(ns with-clj-loga
  (:require [clj-loga.core :as loga :refer [setup-loga set-log-tag log-wrapper]]
            [taoensso.timbre :as timbre])
  (:import (java.util UUID)))

(setup-loga)
(setup-loga :level :debug)
;; Logging using Loga
;; supported levels:
;;   - log trace debug info warn error fatal
(loga/info "an info log message")
(loga/error "an error log message")
(loga/debug "a debug log message")
;; log worry-free
(timbre/info "Log event with params"
  {:password "secret" :bar "baz" :sub {:password "secret" :foo "bar"}})

;; tag logs
(set-log-tag "smart-tag"
  (timbre/info "Log it tagged."))

;; handle exceptions
(timbre/error (Exception. "Something went wrong"))

(loga/warn {:foo :yeah})
(loga/error {:id "1234" :reason "some problem"})


;; Related forms can be wrapped with log messages.
;; - macro log-wrapper accepts a map with following keys:
;; - optional keys:
;;   - :tag - to tag log events
;;   - :pre-log-msg  - custom log message before body execution
;;   - :post-log-msg - custom log message after body execution
;;   - :operation - descriptive name for the wrapped forms
;; custom basic application:
(log-wrapper {:pre-log-msg "started processing kafka message"
              :post-log-msg "finished processing kafka message"
              :tag (UUID/randomUUID)
              :message-id (UUID/randomUUID)}
  (do
    (prn "all the work happening now")
    "return value"))