
### Dependencies
```
cambium/cambium.logback.json 0.4.3
  com.fasterxml.jackson.core/jackson-databind 2.9.6
    com.fasterxml.jackson.core/jackson-annotations 2.9.0
  cambium/cambium.logback.core 0.4.3
    org.codehaus.janino/janino 3.0.12
      org.codehaus.janino/commons-compiler 3.0.12
    ch.qos.logback/logback-classic 1.2.3
  ch.qos.logback.contrib/logback-jackson 0.1.5
  com.fasterxml.jackson.core/jackson-core 2.9.6
  ch.qos.logback.contrib/logback-json-classic 0.1.5
    ch.qos.logback.contrib/logback-json-core 0.1.5
org.clojure/clojure 1.10.1
  org.clojure/core.specs.alpha 0.2.44
  org.clojure/spec.alpha 0.2.176
org.clojure/tools.logging 1.1.0
net.logstash.logback/logstash-logback-encoder 4.11
  ch.qos.logback/logback-core 1.2.3
cambium/cambium.codec-cheshire 0.9.3
  cheshire/cheshire 5.8.1
    com.fasterxml.jackson.dataformat/jackson-dataformat-cbor 2.9.6
    tigris/tigris 0.1.1
    com.fasterxml.jackson.dataformat/jackson-dataformat-smile 2.9.6
cambium/cambium.core 0.9.3
  org.slf4j/slf4j-api 1.7.26
```

### Resulting message with LoggingEventCompositeJsonEncoder 

```json
{
  "timestamp": "2020-05-06T17:31:14.538+01:00",
  "level": "INFO",
  "logger_name": "with-cambium",
  "message": "Arguments received",
  "elapsed": "27",
  "sub": "{\"some\":{\"really\":{\"nested\":{\"data\":\"cb19f313-4523-4db9-a870-f3b3faafb5ac\",\"id\":3245}}},\"prop\":\"some prop\"}",
  "clojure.core/eval-file": "\"/Users/gilles/dev/howtolog/with-cambium/src/with_cambium.clj\"",
  "ns": "\"with-cambium\"",
  "line": "13",
  "column": "1",
  "user-service": "\"https://...\"",
  "status": "503",
  "thread_name": "nRepl-session-407dea85-c7cc-4329-8e39-81739f4f037f",
  "level_value": 20000
}
```

### Resulting log message with LayoutWrappingEncoder and cambium.logback.json.FlatJsonLayout

```json
{
  "timestamp": "2020-05-06T16:47:45.506Z",
  "level": "INFO",
  "thread": "nRepl-session-448f339c-6f6e-4175-bdee-529595ca5e5c",
  "elapsed": 27,
  "sub": {
    "some": {
      "really": {
        "nested": {
          "data": "adb1f806-e302-4dea-843d-ad1060ef0685",
          "id": 3245
        }
      }
    },
    "prop": "some prop"
  },
  "clojure.core/eval-file": "/Users/gilles/dev/howtolog/with-cambium/src/with_cambium.clj",
  "ns": "with-cambium",
  "line": 13,
  "column": 1,
  "user-service": "https://...",
  "status": 503,
  "logger": "with-cambium",
  "message": "Arguments received",
  "context": "default"
}
```