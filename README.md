# LeanFT Cucumber Template
This project is designed to be a template which can be used to write Automation scripts using LeanFT with the help of Cucumber. 

Some of the features provided in this template are:-
1. LeanFT SDK and Report initialization are handled
2. Logging with Log4J
3. Utils to Read from Properties File.
4. Data Driven Examples with Scenario Outline
5. HTML Report generation

# Prerequisites

Note: This is aimed for LeanFT V14.03

Following batch commands need to be executed in order for Maven to read the LeanFT dependencies:-

mvn install:install-file -Dfile="C:\Program Files (x86)\HPE\LeanFT\SDK\Java\com.hp.lft.sdk-standalone.jar" -DgroupId="com.hp.lft" -DartifactId="sdk" -Dversion=14.3.0 -Dpackaging=JAR -DgeneratePom=true

mvn install:install-file -Dfile="C:\Program Files (x86)\HPE\LeanFT\SDK\Java\com.hp.lft.sdk-javadoc.jar" -DgroupId="com.hp.lft" -DartifactId="sdk" -Dversion=14.3.0 -Dpackaging=JAR -Dclassifier=javadoc -DgeneratePom=true

mvn install:install-file -Dfile="C:\Program Files (x86)\HPE\LeanFT\SDK\Java\com.hp.lft.report.jar" -DgroupId="com.hp.lft" -DartifactId="report" -Dversion=14.3.0 -Dpackaging=JAR -DgeneratePom=true

mvn install:install-file -Dfile="C:\Program Files (x86)\HPE\LeanFT\SDK\Java\com.hp.lft.unittesting.jar" -DgroupId="com.hp.lft" -DartifactId="unittesting" -Dversion=14.3.0 -Dpackaging=JAR -DgeneratePom=true

mvn install:install-file -Dfile="C:\Program Files (x86)\HPE\LeanFT\SDK\Java\com.hp.lft.verifications.jar" -DgroupId="com.hp.lft" -DartifactId="verifications" -Dversion=14.3.0 -Dpackaging=JAR -DgeneratePom=true

These commands put the LeanFT JARS in the local maven repository


# Maven_Jars

We have 2 possible scenarios 1) Corporate environment no access to Maven 2)access to Maven. If we have access to maven no need to keep system scope. we can go ahead with maven central repo.

1)We have no access to Maven central repo:

a) Download all the Jar/dependency from Maven central
b) Move those to target system.
c) Run above mentioned similar commands based on respective dependecy and version.

For sample Cucumber project below dependecies need to be added

info.cukes.gherkin
info.cukes.cucumber-junit
info.cukes.cucumber-java
info.cukes.cucumber-core
info.cukes.cucumber-jvm-deps
Junit