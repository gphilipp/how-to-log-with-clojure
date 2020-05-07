# How to log with Clojure


## Goals
We want to choose the logging solution best suited to achieve the following: 

- Structured Logging
- A single configuration to rule all the libraries
 
###  Structured logging
Rather than looking at raw logging text messages, we prefer log events.  
Log events, popularised by the canonical [syslog](https://en.wikipedia.org/wiki/Syslog) standard, have gain even more
popularity with the rise of micro-services and the need to gather logs in a central place to be able to search and 
 correlate those events. Logging Aggregators such as Logstash or Graylog have been created for this purpose. 
 
The Graylog team has even published their own format, [GELF](https://docs.graylog.org/en/2.5/pages/gelf.html) to 
overcome a few limitations of syslog like the max message size or the lack of compression.

###  A single configuration to rule all the libraries
Unfortunately, the [state of JVM logging is a mess](https://blog.gradle.org/addressing-logging-complexity-capabilities).
There are many APIs and implementations, some libraries like SLF4J even try to act as a facade, and provides bridges to 
re-route the application logs throughout the various frameworks APIs to land in a single place.  
   


### "Clojure has a function for that" 
Clojure has a library to handle logging: https://github.com/clojure/tools.logging

Quoting the docs:

> Logging macros which delegate to a specific logging implementation, selected at runtime when the clojure.tools.logging namespace is first loaded.
> (...) To control which logging implementation is used, set the clojure.tools.logging.factory system property to the fully-qualified name of a no-arg function that returns an instance of clojure.tools.logging.impl/LoggerFactory. There are a number of factory functions provided in the clojure.tools.logging.impl namespace.
> If the system property is unset, an implementation will be automatically chosen based on whichever of the following implementations is successfully loaded first:
>
> - SLF4J
> - Apache Commons Logging
> - Log4J 2
> - Log4J
> - java.util.logging

The above approach is problematic given that applications often inadvertently pull in multiple logging implementations as transitive dependencies. As such, it is strongly advised that you set the system property.
This is what the default logging will look in Clojure, if you don't include any additional library:

```shell script
$ clj -Sdeps '{:deps {org.clojure/tools.logging {:mvn/version "1.0.0"}}}' -e "(require '[clojure.tools.logging :as log]) (log/info \"hello world\")"
Mar 11, 2020 1:11:14 PM clojure.tools.logging$eval431$fn__434 invoke
INFO: hello world
```

We don't want to use Apache Commons Logging, Log4J nor JUL (Java Util Logging) as they all have limitations, so that 
leaves us either with SLF4J or Log4J2. At this point it's important to understand that SLF4J doesn't do the logging 
itself, it's just a API facade which allow you to decouple your application code from a particular logging library 
implementation. Log4j2 and Logback are both SLF4J compliant, as they implement the SLF4J interface.

# Using alternative Clojure libraries

