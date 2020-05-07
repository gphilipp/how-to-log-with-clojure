# With Logback (via SLF4J)

Logback was written by the same author than Log4j and SLF4j. The latest stable version at time of writing is 1.2.3 but 
it quite old (Mar 2017). If we go with Logback, we need to include SLF4J so that `clojure.tools.logging` can pick it up 
and then SLF4J will in turn pick logback as its implementation.

From Logback README:  
> Logback's architecture is sufficiently generic so as to apply under different circumstances. At present time, logback 
>is divided into three modules, logback-core, logback-classic and logback-access. The logback-core module lays the 
>groundwork for the other two modules. The logback-classic module can be assimilated to a significantly improved version 
>of log4j. Moreover, logback-classic natively implements the SLF4J API so that you can readily switch back and forth between logback and other logging frameworks such as log4j or java.util.logging (JUL).se

Since logback-classic natively implements SLF4J, if we want to use LogBack in a Clojure application we just have to do the following:

```shell script
$ clj -Sdeps '{:deps {org.clojure/tools.logging {:mvn/version "1.0.0"} ch.qos.logback/logback-classic {:mvn/version "1.2.3"}}}' -e "(require '[clojure.tools.logging :as log]) (log/info \"hello world\")"
13:38:59.477 [main] INFO user - hello world
```

To get structured logging we need to use a specific encoder: `LoggingEventCompositeJsonEncoder`. It's part of the 
`net.logstash.logback/logstash-logback-encoder` library, and we configure this via a `logback.xml` file.
