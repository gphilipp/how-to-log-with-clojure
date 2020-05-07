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
Unfortunately, the state of JVM logging is a mess. There are many APIs and implementations, some libraries like SLF4J 
even try to act as a facade, and provides bridges to re-route the application logs throughout the various frameworks 
APIs to land in a single place.  
   


