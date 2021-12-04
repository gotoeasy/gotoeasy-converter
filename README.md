[![Maven Central](https://maven-badges.herokuapp.com/maven-central/top.gotoeasy/gotoeasy-converter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/top.gotoeasy/gotoeasy-converter)
[![Javadocs](https://www.javadoc.io/badge/top.gotoeasy/gotoeasy-converter.svg)](https://www.javadoc.io/doc/top.gotoeasy/gotoeasy-converter)
[![License](https://img.shields.io/badge/License-apache2.0-brightgreen.svg)](https://github.com/gotoeasy/gotoeasy-converter/blob/master/LICENSE)

# `gotoeasy-converter`
没错，只是个Java类型转换器，拿来即用

Maven坐标
```xml
<dependency>
    <groupId>top.gotoeasy</groupId>
    <artifactId>gotoeasy-converter</artifactId>
    <version>x.y.z</version>
</dependency>
```

## 使用姿势
```java
public static void main(String... args) {
    System.err.println(Converter.fromTo("True", Boolean.class));
    System.err.println(Converter.fromTo(0, Boolean.class));
    System.err.println(Converter.fromTo(new BigDecimal("12345.678"), int.class));
}
```
