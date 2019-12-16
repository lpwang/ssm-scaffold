# ssm-scaffold

## 描述

ssm-scaffold(ssm脚手架项目)，项目使用springMVC+spring+Mybatis构建。使用maven进行项目依赖管理。使用war包形式部署到tomcat，或者其他servlet容器。相比springboot的自动配置和内嵌servlet容器。这套框架较为原始和纯净。同时也是学习ssm整合的一套框架。

## 项目结构

```
├── pom.xml  // maven文件
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── xxx
│   │   │           └── yyy
│   │   │               ├── ctrl  // 控制器
│   │   │               │   └── StudentCtrl.java
│   │   │               ├── dao  // 持久层
│   │   │               │   └── StudentDao.java
│   │   │               ├── entry // 实体
│   │   │               │   ├── bo // 持久层实体
│   │   │               │   │   └── StudentBO.java
│   │   │               │   └── vo  // 请求实体
│   │   │               ├── ext  // spring ioc 扩展
│   │   │               │   ├── BeanDefinitionRegistryPostProcessorExt.java
│   │   │               │   └── BeanPostProcessorExt.java
│   │   │               │       ├── ResponseEntry.java
│   │   │               │       └── StudentVO.java
│   │   │               └── service // 业务层
│   │   │                   ├── intf
│   │   │                   │   └── IStudent.java
│   │   │                   └── StudentService.java
│   │   ├── resources // 配置文件
│   │   │   ├── ApplicationContext.xml
│   │   │   ├── log4j2.xml
│   │   │   └── SpringMVCServlet.xml
│   │   └── webapp
│   │       └── WEB-INF
│   │           └── web.xml
│   └── test
│       └── java
└── ssm-scaffold.iml

```

## 整合方式

- springmvc与spring整合选择了父子容器的方式。
- springmvc的HttpMessageConverters使用了，String和JSON。
- spring事务使用注解方式。
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

在tomcat家目录的/bin/下创建setenv.sh文件，catalina.sh将会读取到这个配置文件。在setenv.sh文件中配置tomcat的jvm参数。当然也可以在这个配置文件设置其他参数。具体可以参考catalina.sh的定义。如果是大型应用（内存分配超过4g），推进使用G1垃圾回收器。如果不是大型应用，还是使用cms，以下是我的cms的配置。

```shell
JAVA_OPTS="-Xms1024m -Xmx1024m -Xss256K -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSConcurrentMTEnabled -XX:ParallelCMSThreads=5 -XX:ConcGCThreads=2 -XX:CMSInitiatingOccupancyFraction=68"
```

## Spring扩展

### IOC容器创建时的扩展

BeanDefinitaion扩展编写在：```BeanDefinitionRegistryPostProcessorExt.java```

BeanPostProcessor扩展编写在：```BeanPostProcessorExt.java```

InitializingBean扩展编写在：```StudentService.java```