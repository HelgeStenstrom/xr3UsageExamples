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

```xml
<dependency>
    <groupId>com.github.goxr3plus</groupId>
    <artifactId>jaudiotagger</artifactId>
    <version>V2.2.6</version>
</dependency>
```


		
final pom
```xml
<dependency>
    <groupId>net.jthink</groupId>
    <artifactId>jaudiotagger</artifactId>
    <version>2.2.5</version>
</dependency>
```

        
but it's in a repository that needs help to be found:
```xml
<repositories>
    <repository>
        <id>jaudiotagger-repository</id>
        <url>https://dl.bintray.com/ijabz/maven</url>
    </repository>
</repositories>
```


    
module-info:

```java
module xr3UsageExamples {
    requires jaudiotagger;
}
```

IntelliJ helped me with the module name in the module-info file.
Before I switched from the original pom to the final pom, I didn't get 
that help. So there is some difference between the two external sources.

### java-google-speech-api
Original pom

```xml
<dependency>
    <groupId>com.github.goxr3plus</groupId>
    <artifactId>java-google-speech-api</artifactId>
    <version>V2.1</version>
</dependency>
```

By only adding the above dependency to my pom.xml, I get a red error 
marker on com.github.goxr3plus:java-google-speech-api:V2.1. 
It isn't so in XR3Player, and I doubt that Java 11 is the reason 
(it's a Maven problem, I think)

For a while I had this alternative definition in my pom.xml:

```xml
<dependency>
    <groupId>com.darkprograms.speech</groupId>
    <artifactId>java-speech-api</artifactId>
    <version>1.13.0-SNAPSHOT</version>
</dependency>
```

Regrettably I have destroyed my local Maven repository when I tried to 
fix the java-google-speech-api dependencies. I thought there might be a conflict between the 
alternative source, and what was in my m2 repository. So I removed the directory containing
goxr3plus/java-google-speech-api. It got worse. Now not even XR3Player worked, even though
it's a separate IntelliJ and Maven project and a separate Git repo. 

Guided by https://stackoverflow.com/questions/15358851/how-to-remove-jar-file-from-local-maven-repository-which-was-added-with-install
I deleted the whole ~/.m2/repository. It didn't help. 
Then I found how to execute a Maven goal from within IntelliJ, and executed dependency:purge-local-repository
It helped somewhat. The computer started to load jar files.

Unfortunately, it still haven't loaded java-google-speech-api so that I can use it in this project.

All my dependencies listed in the Maven tool window have red error markers,
but I haven't found any indication of why they are.

I still can't import com.darkprograms.

Over in the XR3Player project, I have errors when I execute that Maven goal.
These errors appear:

    [ERROR] com.github.imcdonagh:image4j:jar:0.7.2
    [ERROR] com.teamdev.jxbrowser:jxbrowser-win64:jar:6.23
    [ERROR] com.teamdev.jxbrowser:jxbrowser:jar:6.23
    [ERROR] com.github.goxr3plus:java-google-speech-api:jar:V2.1
    [ERROR] com.github.goxr3plus:jaudiotagger:jar:V2.2.6
    [ERROR] com.github.goxr3plus:java-stream-player:jar:V8.0.0
    [ERROR] com.github.Trilarion:java-vorbis-support:jar:v1.0.0
    [ERROR] com.github.goxr3plus:FX-BorderlessScene:jar:V3.1.0
    [ERROR] com.github.goxr3plus:XR3Capture:jar:V101
    [ERROR] com.github.goxr3plus:javasysmon2:jar:8.0.0

Mainly the com.github.goxr3plus sources, apparently.

This COULD be a Java11 problem. So I changed the project to Java 10 by chang 11 ==> 10 in
a number of places in the pom file, and also changed the IntelliJ project setting. Then I re-ran 
the Maven goal. No success.

# Help needed
What is the right way to insert code blocks in this file? IntelliJ behaves
strangely. It inserts backticks, so I don't get the three of them that I want, 
but perhaps four.
