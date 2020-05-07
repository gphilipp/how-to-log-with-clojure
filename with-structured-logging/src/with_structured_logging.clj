(ns with-structured-logging
  (:require [puppetlabs.structured-logging.core :refer [maplog]])
  (:import (java.util UUID)))

(maplog :warn
  {:user-service "https://...",
   :status 503,
   :elapsed 27
   :sub {:some {:really {:nested {:data (UUID/randomUUID)
                                  :id 3245}}}
         :prop "some prop"}}
  #(format "Failed to query user-service %s. Response: status %d"
     (:user-service %) (:status %)))

;{
;  "timestamp": "2020-05-06T16:15:05.514+01:00",
;  "level": "WARN",
;  "logger_name": "with-structured-logging",
;  "message": "Failed to query user-service https://.... Response: status 503",
;  "thread_name": "nRepl-session-38e4de5d-233b-4f93-83e1-763a7b743fce",
;  "level_value": 30000,
;  "user-service": "https://...",
;  "status": 503,
;  "elapsed": 27,
;  "sub": {
;    "some": {
;      "really": {
;        "nested": {
;          "data": "682540c8-4f05-4e03-8ab5-514ba7483a8a",
;          "id": 3245
;        }
;      }
;    },
;    "prop": "some prop"
;  }
;
;
;
;
;
;
;
;
;
;