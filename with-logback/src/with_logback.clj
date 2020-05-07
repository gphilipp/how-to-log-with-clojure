(ns with-logback
  (:require [clojure.tools.logging :as log]))

(log/error (ex-info "oops" {:a 1}) "Some error happened")
(log/error "Some error happened")
