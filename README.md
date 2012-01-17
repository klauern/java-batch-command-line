This is a template that I have used a couple times to make simple Java applications.

libraries used
--------------

  * Logback (successor to log4j)
  * Maven (ugh)
  * JCommander (Command-line Option parsing)
  * Google Guice (dependency injection)
  * Google Guava (all the goodies)
  * Maven AppAssembler (to generate a self-contained java app with
    `.bat` and `sh` scripts)


This includes a couple example classes surrounding how to use JCommander and
Google Guice for dependency injection.  Logback includes a default logback.xml
file that's annotated with my most commonly-used defaults.


Testing?
--------
I'm sure there are a litany of testing frameworks out there (which language 
doesn't have at least 5 - 10 different tools for this?) but I haven't really 
settled on anything other than what I consider the vanilla choice: JUnit.
