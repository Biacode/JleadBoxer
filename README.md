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
  <repository>
      <id>jcenter</id>
      <url>http://jcenter.bintray.com </url>
      <snapshots>
          <enabled>true</enabled>
          <updatePolicy>never</updatePolicy>
          <checksumPolicy>warn</checksumPolicy>
      </snapshots>
      <releases>
          <enabled>true</enabled>
          <checksumPolicy>warn</checksumPolicy>
      </releases>
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
