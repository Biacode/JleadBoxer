# JleadBoxer
[![Build Status](https://travis-ci.org/Biacode/JleadBoxer.svg?branch=master)](https://travis-ci.org/Biacode/JleadBoxer)

# Install

### Maven
```xml
<repositories>
  <repository>
    <id>snapshots-repo</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    <releases><enabled>false</enabled></releases>
    <snapshots><enabled>true</enabled></snapshots>
  </repository>
</repositories>

<dependency>
  <groupId>org.biacode.jleadboxer</groupId>
  <artifactId>jleadboxer</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Gradle

```groovy
maven {
  url "https://oss.sonatype.org/content/repositories/snapshots"
}

compile "org.biacode.jleadboxer:jleadboxer:0.0.1-SNAPSHOT"
```