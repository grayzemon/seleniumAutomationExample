###### **Overview**

**Requirements**

Java Develeopment Kit (JDK) v1.8 or higher.  Note the JRE 1.8 maybe used instead if running a precompiled jar file, 
however an alternative unzip utility will be required to replace using jar to unzip the /src folder (see below) 
Apache Maven (or and IDE such as Intelij or Eclipse) 
_Initial compilation_

`mvn generate-sources compile -DskipTests`

**Compiling and running from a jar file**

`mvn generate-sources compile -DskipTests package`

 Extract files from the jar file: `jar -xf ServiceTestAutomation-1.0-SNAPSHOT-jar-with-dependencies.jar src`
 
 Run the jar file:  `java -jar ServiceTestAutomation-1.0-SNAPSHOT-jar-with-dependencies.jar @StppWebAPI`


**Test artifact locations**

`target/cucumber-reports/report.html`     Cucumber report location

`target/screenshots`    Screenshot files


