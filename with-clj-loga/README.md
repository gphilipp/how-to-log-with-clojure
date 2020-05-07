
## Shortcomings

- It's not Structured Logging as the custom keys end up within the message, eg there's only `tag`, you cannot use more attributes.
- Timbre is heavyweight

## Dependencies

```
clj-loga/clj-loga 0.7.2
  environ/environ 1.1.0
  com.taoensso/timbre 4.10.0
    com.taoensso/encore 2.91.0
      com.taoensso/truss 1.5.0
      org.clojure/tools.reader 0.10.0
    io.aviso/pretty 0.1.33
  robert/hooke 1.3.0
  cheshire/cheshire 5.7.0
    com.fasterxml.jackson.dataformat/jackson-dataformat-cbor 2.8.6
    com.fasterxml.jackson.core/jackson-core 2.8.6
    tigris/tigris 0.1.1
    com.fasterxml.jackson.dataformat/jackson-dataformat-smile 2.8.6
```
