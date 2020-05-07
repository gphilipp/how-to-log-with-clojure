(ns with-cambium
  (:require [cambium.core :as cambium]
            [cambium.logback.json.flat-layout :as flat]
            [cambium.codec :as codec])
  (:import (java.util UUID)))

(flat/set-decoder! codec/destringify-val)

(cambium/info "Application started")

(cambium/info {:id "some business id" :rate 9.4} "Arguments received")

(cambium/info
  {:user-service "https://...",
   :status 503,
   :elapsed 27
   :sub {:some {:really {:nested {:data (UUID/randomUUID)
                                  :id 3245}}}
         :prop "some prop"}}
  "Arguments received")




;{
;  "timestamp": "2020-05-06T15:16:05.553Z",
;  "level": "INFO",
;  "thread": "nRepl-session-3973844c-c3e0-43be-af7b-834174ed4380",
;  "elapsed": 27,
;  "sub": {
;    "some": {
;      "really": {
;        "nested": {
;          "data": "5be3fce0-8f84-47ef-bb07-b1daa9c811c0",
;          "id": 3245
;        }
;      }
;    },
;    "prop": "some prop"
;  },
;  "clojure.core/eval-file": "/Users/gilles/dev/howtolog/with-cambium/src/with_cambium.clj",
;  "ns": "with-cambium",
;  "line": 13,
;  "column": 1,
;  "user-service": "https://...",
;  "status": 503,
;  "logger": "with-cambium",
;  "message": "Arguments received",
;  "context": "default"
;}