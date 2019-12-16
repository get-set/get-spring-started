### Building a RESTful Web Service
    
[![](https://img.shields.io/static/v1?label=doc&message=Consuming%20a%20RESTful%20Web%20Service&color=green)](https://spring.io/guides/gs/rest-service/) 

* [Spring Boot Maven Plugin](https://github.com/get-set/get-spring-started/blob/master/rest-service/pom.xml#L43)提供了如下能力：
    * 将classpath下的所有jar都打包成一个大的便于运行的jar；
    * 搜索 `public static void main(String[] args)`，并自动配置为执行入口；
    * 内置有针对Spring的依赖管理，当不指定Spring组件的版本号时，会自动为其分配版本号。
* Controller注解：
    * [`@RequestMapping`](https://github.com/get-set/get-spring-started/blob/master/rest-service/src/main/java/hello/GreetingController.java#L16)用于将请求路径映射到具体的Controller方法；
    * [`@RequestParam`](https://github.com/get-set/get-spring-started/blob/master/rest-service/src/main/java/hello/GreetingController.java#L17)用于将请求中的参数与方法中的参数进行对应，并可进行设置默认值等操作。不加的话，默认按字符串匹配；
    * [`@RestController`](https://github.com/get-set/get-spring-started/blob/master/rest-service/src/main/java/hello/GreetingController.java#L10) 是 @Controller 和 @RequestBody 的组合体。
* [`@SpringBootApplication`](https://github.com/get-set/get-spring-started/blob/master/rest-service/src/main/java/hello/Application.java#L6) 是如下几个注解的组合：
    * `@Configuration`，表明该 class 是用于定义 application context 的；
    * `@EnableAutoConfiguration`，使得 SpringBoot 能够基于 classpath 设置来加载 bean，
      以及相关的设置。比如，如果 spring-mvc 在 classpath 中，那么会自动配置为 web 项目，
      并自动设置 DispatcherServlet。
    * `@ComponentScan`，让 SpringBoot 在其所在的包及以下子包中查找 configuration、
      component、service 和 controller。


