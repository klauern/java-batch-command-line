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

References
----------
Since this relies on knowledge of alot of these frameworks, I would say these libraries
provided me the msot documentation, which is part of the reason I picked them:

  - [Logback](http://logback.qos.ch/)
    - [Logback Manual](http://logback.qos.ch/manual/index.html)
	- [Configuring Logback (and the `logback.xml` file)](http://logback.qos.ch/manual/configuration.html)
  - [Maven](http://maven.apache.org)
	- [Maven Filtering](http://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html)
  - [JCommander](http://jcommander.org)
  - [Google Guice](http://code.google.com/p/google-guice/wiki/GettingStarted)
  - [Google Guava](http://code.google.com/p/guava-libraries/)
	- [Java API](http://docs.guava-libraries.googlecode.com/git-history/v11.0.1/javadoc/index.html)
	- [Guava Explained (what's in it)](http://code.google.com/p/guava-libraries/wiki/GuavaExplained)

Contact
-------
Questions, concerns, etc., can be directed to me `klauer` `@` `gmail` `.` `com`