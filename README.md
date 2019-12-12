# ssm-scaffold

## 描述

ssm-scaffold(ssm脚手架项目)，项目使用springMVC+spring+Mybatis构建。使用maven进行项目依赖管理。使用war包形式部署到tomcat，或者其他servlet容器。相比springboot的自动配置和内嵌servlet容器。这套框架较为原始和纯净。同时也是学习ssm整合的一套框架。

## 整合方式

- springmvc与spring整合选择了父子容器的方式。
- springmvc的HttpMessageConverters使用了，String和JSON。

- mybatis使用了MapperScannerConfiguration的mapper扫描的方式。
- mybatis的sql使用java config的配置方式。
- 数据库使用的是mysql。
- 数据库连接池没用使用mybatis内置的数据连接池，使用的是Hikari数据库连接池。
- servlet使用tomcat。

## TOMCAT配置

### Connector配置

```xml
<Service name="Catalina">
...
<Executor name="tomcatThreadPool" namePrefix="catalina-exec-"
        maxThreads="150" minSpareThreads="4"/>

    <Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
	       executor="tomcatThreadPool"
               connectionTimeout="20000"
               redirectPort="8443" />
...
</Service>
```

#### 网络模型

- nio

#### 线程模型(默认)

- Acceptor，处理accept()线程一个。

- Poller，处理read()线程两个。

- Worker，处理业务线程如上面配置的```Executor```。

### JVM

TODO

## Spring扩展

TODO

