Log4J2 is an apache project and the latest release is 2.13.0 (December 2019). Now, hold tight, Log4J2 can also act as a
facade, and you can plug Logback into it if that's your taste. If your mind hasn't melted yet, carry on reading for some
of the benefits. Quoting the homepage: 

> Apache Log4j 2 is an upgrade to Log4j that provides significant improvements
over its predecessor, Log4j 1.x, and provides many of the improvements available in Logback while fixing some inherent
problems in Logback’s architecture. (...) The Log4j API is a logging facade that may, of course, be used with the Log4j
implementation, but may also be used in front of other logging implementations such as Logback. The Log4j API has
several advantages over SLF4J. Most of them come from the implementation (performance, cloud readiness, etc), but they
also tout a better API:
>1. The Log4j API supports logging Messages instead of just Strings.
>2. The Log4j API supports lambda expressions.
>3. The Log4j API provides many more logging methods than SLF4J.
>4. In addition to the “parameterized logging” format supported by SLF4J, the Log4j API also supports events using the 
 java.text.MessageFormat syntax as well printf-style messages.
>5. The Log4j API provides a LogManager.shutdown() method. The underlying logging implementation must implement the 
 Terminable interface for the method to have effect.
>6. Other constructs such as Markers, log Levels, and ThreadContext (aka MDC) are fully supported.
On the performance side, the project page says that "Log4j 2 contains next-generation Asynchronous Loggers based on 
the LMAX Disruptor library. In multi-threaded scenarios Asynchronous Loggers have 18 times higher throughput and orders
 of magnitude lower latency than Log4j 1.x and Logback".


