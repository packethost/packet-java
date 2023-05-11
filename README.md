# Equinix Metal API Java Client

> **END OF LIFE**
> This repository is [End of Life](https://github.com/equinix-labs/equinix-labs/blob/main/uniform-standards.md#end-of-life-tier) meaning that 
> this software is no longer supported nor maintained by Equinix Metal or its community.
>
> Please use <https://github.com/equinix-labs/metal-java> instead.

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fpackethost%2Fpacket-java.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fpackethost%2Fpacket-java?ref=badge_shield)
[![End Of Life](https://img.shields.io/badge/Stability-EndOfLife-black.svg)](https://github.com/equinix-labs/equinix-labs/blob/main/uniform-standards.md#end-of-life-tier)

Lightweight Java client library for accessing Equinix Metal REST APIs with project based (JVM hosted languages) on Java, Groovy, Scala, Clojure, etc.

# Getting Started

Equinix Metal API Java Client is available in [Maven Central Repo](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22net.packet%22%20AND%20a%3A%22java-client%22).

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

* API Javadoc: [Equinix Metal API Java Client](https://packethost.github.io/packet-java/)
* Example usage: have a look at [PacketIntegrationTest](src/test/java/net/packet/impl/PacketIntegrationTest.java)

# How to create Equinix Metal API Java Client?

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

Equinix Metal API Java Client uses [GitHub’s integrated issue tracking system](https://github.com/packethost/packet-java/issues) to record bugs and feature requests. If you need to paste code, or include a stack trace use Markdown <code>```</code> escapes before and after your text.


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


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fpackethost%2Fpacket-java.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fpackethost%2Fpacket-java?ref=badge_large)
