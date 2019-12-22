Spring Getting Started Guides
===

### Building a RESTful Web Service

[![](https://img.shields.io/static/v1?label=doc&message=Building%20a%20RESTful%20Web%20Service&color=green)](https://spring.io/guides/gs/rest-service/) 
[![](https://img.shields.io/static/v1?label=code&message=rest-service&color=blue)](rest-service) 

Learn how to create a RESTful web service with Spring.

* [Spring Boot Maven Plugin](rest-service/pom.xml#L43)提供了如下能力：
    * 将classpath下的所有jar都打包成一个大的便于运行的jar；
    * 搜索 `public static void main(String[] args)`，并自动配置为执行入口；
    * 内置有针对Spring的依赖管理，当不指定Spring组件的版本号时，会自动为其分配版本号。
* Controller注解：
    * [`@RequestMapping`](rest-service/src/main/java/hello/GreetingController.java#L16)用于将请求路径映射到具体的Controller方法；
    * [`@RequestParam`](rest-service/src/main/java/hello/GreetingController.java#L17)用于将请求中的参数与方法中的参数进行对应，并可进行设置默认值等操作。不加的话，默认按字符串匹配；
    * [`@RestController`](rest-service/src/main/java/hello/GreetingController.java#L10) 是 @Controller 和 @RequestBody 的组合体。
* [`@SpringBootApplication`](rest-service/src/main/java/hello/Application.java#L7) 是如下几个注解的组合：
    * `@Configuration`，表明该 class 是用于定义 application context 的；
    * `@EnableAutoConfiguration`，使得 SpringBoot 能够基于 classpath 设置来加载 bean，
      以及相关的设置。比如，如果 spring-mvc 在 classpath 中，那么会自动配置为 web 项目，
      并自动设置 DispatcherServlet。
    * `@ComponentScan`，让 SpringBoot 在其所在的包及以下子包中查找 configuration、
      component、service 和 controller。

### Scheduling Tasks

[![](https://img.shields.io/static/v1?label=doc&message=Scheduling%20Tasks&color=green)](https://spring.io/guides/gs/scheduling-tasks/) 
[![](https://img.shields.io/static/v1?label=code&message=(still%20in)rest-service&color=blue)](rest-service) 

This guide walks you through the steps for scheduling tasks with Spring.

* [`@Scheduled`](rest-service/src/main/java/hello/ScheduledTask.java#L17)用于指定需要定时执行的方法。
* [`@EnableScheduling`](rest-service/src/main/java/hello/Application.java#L8)创建后台的任务执行器，方能定时执行任务。

### Consuming a RESTful Web Service

[![](https://img.shields.io/static/v1?label=doc&message=Consuming%20a%20RESTful%20Web%20Service&color=green)](https://spring.io/guides/gs/consuming-rest/) 
[![](https://img.shields.io/static/v1?label=code&message=consuming-rest&color=blue)](consuming-rest) 

This guide walks you through the process of creating an application that consumes a RESTful web service.

* [`RestTemplate`](consuming-rest/src/main/java/com/getset/demo/ConsumingRestApplication.java#L28)基于JSON的处理库将请求返回的结果转化为对象。
* `CommandLineRunner`的具体实现逻辑会在容器启动完成时执行。
* 本实例中使用了`lombok`来生成getter、setter、logger、`toString()`等。

### Accessing Relational Data using JDBC with Spring

[![](https://img.shields.io/static/v1?label=doc&message=Accessing%20Relational%20Data%20using%20JDBC%20with%20Spring&color=green)](https://spring.io/guides/gs/relational-data-access/)
[![](https://img.shields.io/static/v1?label=code&message=relational-data-access&color=blue)](relational-data-access) 

This guide walks you through the process of accessing relational data with Spring.

* 本项目依赖`org.springframework.boot:spring-boot-starter-data-jdbc`，数据库采用H2。
* SpringBoot支持H2数据库，所以会自动创建H2连接。
* 由于使用了`spring-jdbc`，SpringBoot会自动创建`JdbcTemplate`，而`@Autowired JdbcTemplate`则会自动加载它。
* 当插入一条record时使用`insert`，当批量插入数据时使用`batchUpdate`。

### Uploading Files

[![](https://img.shields.io/static/v1?label=doc&message=Uploading%20Files&color=green)](https://spring.io/guides/gs/uploading-files/)
[![](https://img.shields.io/static/v1?label=code&message=uploading-files&color=blue)](uploading-files) 

Learn how to build a Spring application that accepts multi-part file uploads.

* 如果要上传文件到Servlet容器，需要注册一个`MultipartConfigElement`类（相当于`web.xml`中的`<multipart-config>`），不过SpringBoot已经自动配好了（作为SpringMVC自动配置的一部分）；
* 用到了[`MvcUriComponentsBuilder`](uploading-files/src/main/java/com/getset/uploadingfiles/FileUploadController.java#L31)来生成下载文件的链接；
* 限制上传文件的大小：
  * `spring.http.multipart.max-file-size`用于限制总的文件大小；
  * `spring.http.multipart.max-request-size`用于限制一个`multipart/form-data`请求的总大小。
