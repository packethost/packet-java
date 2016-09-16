# Packet API Java Client

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

Lightweight Java client library for accessing Packet REST APIs with project based (JVM hosted languages) on Java, Groovy, Scala, Clojure, etc.

# Getting Started

Packet API Java Client is available in [Maven Central Repo](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22net.packet%22%20AND%20a%3A%22java-client%22).

**Maven dependency**
```xml
<dependency>
    <groupId>net.packet</groupId>
    <artifactId>java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```
**Gradle/Grails dependency**
```shell
compile 'net.packet:java-client:1.0.0'
```
**Groovy Grape**
```groovy
@Grapes(
@Grab(group='net.packet', module='java-client', version='1.0.0')
)
```
**Scala SBT**
```shell
libraryDependencies += "net.packet" % "java-client" % "1.0.0"
```

**Note:** For Android projects, kindly include the `httpclient-android` library explicitly in your project dependencies.

# Getting Help

* API Javadoc: [Packet API Java Client](https://packethost.github.io/packet-java/)
* Example usage: have a look at [PacketIntegrationTest](src/test/java/net/packet/impl/PacketIntegrationTest.java)

# How to create Packet API Java Client?

Simply you will have to call constructors!

```java
// Passing authToken and version
Packet apiClient = new PacketClient("authToken", "1");

// Passing authToken, version and HTTP Client. Create a http client with custom settings
CloseableHttpClient httpClient = HttpClients.createDefault();
Packet apiClient = new PacketClient("authToken", "1", httpClient);
```

Then, call appropriate methods as per your need!

# Reporting Issues

Packet API Java Client uses [GitHub’s integrated issue tracking system](https://github.com/packethost/packet-java/issues) to record bugs and feature requests. If you need to paste code, or include a stack trace use Markdown <code>```</code> escapes before and after your text.


# Client Library Changelog

Refer [CHANGELOG.md](CHANGELOG.md)

# Contributing

1. Fork it
2. Create your feature branch - `git checkout -b my-new-feature`
3. Implement your changes and apply [Google Java Code Formatter](https://raw.githubusercontent.com/darcyliu/google-styleguide/master/eclipse-java-google-style.xml)
4. Add integration test cases for your implementation
5. Commit your changes - `git commit -am 'Added feature'`
6. Push to the branch - `git push origin my-new-feature`
7. Create new Pull Request
