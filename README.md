# xr3UsageExamples

This project/repository is used to try to understand what needs to be done
to convert XR3Player to Java 11. It does so by importing the same external
components as XR3Player does.

There are a few things to work with or focus on
- The pom.xml file
- The module-info.java file
  - There
- What external components to import
  - I had better success with jaudiotagger from the upstream source than
    the repacked variant.
- Directory and package layout. I'm following the layout given by IntelliJ 
  when the project was created as an empty Java 11/Maven project. 
  Where does the module-info.java file fit into this? 
- Location of module-info.java
  - There are at least 
    two places where it can be put (Sources root and Test sources root), and
    it makes a difference. 
    
    
## External dependencies
### jaudiotagger
Original pom

````xml
<dependency>
    <groupId>com.github.goxr3plus</groupId>
    <artifactId>jaudiotagger</artifactId>
    <version>V2.2.6</version>
</dependency>
````


		
final pom
````xml
<dependency>
    <groupId>net.jthink</groupId>
    <artifactId>jaudiotagger</artifactId>
    <version>2.2.5</version>
</dependency>
````

        
but it's in a repository that needs help to be found:
````xml
<repositories>
    <repository>
        <id>jaudiotagger-repository</id>
        <url>https://dl.bintray.com/ijabz/maven</url>
    </repository>
</repositories>
````


    
module-info:

````java
module xr3UsageExamples {
    requires jaudiotagger;
}
````

IntelliJ helped me with the module name in the module-info file.
Before I switched from the original pom to the final pom, I didn't get 
that help. So there is some difference between the two external sources.

