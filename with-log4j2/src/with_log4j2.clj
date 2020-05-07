(ns with-log4j2
  (:require [clojure.tools.logging :as log])
  (:import (org.apache.logging.log4j ThreadContext)))

(log/warn "Cool")
(log/info "An info message")
(log/error "An error message")
(log/error {"id" 1234 "reason" "some problem"})

(ThreadContext/put "loan_app_id" "1234")

(def logger (org.apache.logging.log4j.LogManager/getLogger "example"))
(.info logger {"id" 1234 "reason" "some problem"})

