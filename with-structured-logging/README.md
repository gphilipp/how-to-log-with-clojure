### Dependencies
```
org.clojure/clojure 1.10.1
  org.clojure/core.specs.alpha 0.2.44
  org.clojure/spec.alpha 0.2.176
org.clojure/tools.logging 1.1.0
puppetlabs/structured-logging 0.2.0
  net.logstash.logback/logstash-logback-encoder 4.6
    com.fasterxml.jackson.core/jackson-databind 2.5.4
      com.fasterxml.jackson.core/jackson-annotations 2.5.0
  cheshire/cheshire 5.6.3
    com.fasterxml.jackson.dataformat/jackson-dataformat-cbor 2.7.5
    com.fasterxml.jackson.core/jackson-core 2.7.5
    tigris/tigris 0.1.1
    com.fasterxml.jackson.dataformat/jackson-dataformat-smile 2.7.5
  org.slf4j/slf4j-api 1.7.21
ch.qos.logback/logback-classic 1.1.8
  ch.qos.logback/logback-core 1.1.8
```

### Resulting message produced
```json
{
  "timestamp": "2020-05-06T16:15:05.514+01:00",
  "level": "WARN",
  "logger_name": "with-structured-logging",
  "message": "Failed to query user-service https://.... Response: status 503",
  "thread_name": "nRepl-session-38e4de5d-233b-4f93-83e1-763a7b743fce",
  "level_value": 30000,
  "user-service": "https://...",
  "status": 503,
  "elapsed": 27,
  "sub": {
    "some": {
      "really": {
        "nested": {
          "data": "682540c8-4f05-4e03-8ab5-514ba7483a8a",
          "id": 3245
        }
      }
    },
    "prop": "some prop"
  }
```
