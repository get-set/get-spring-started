### Accessing Relational Data using JDBC with Spring

[![](https://img.shields.io/static/v1?label=doc&message=Accessing%20Relational%20Data%20using%20JDBC%20with%20Spring&color=green)](https://spring.io/guides/gs/relational-data-access/)

* 本项目依赖`org.springframework.boot:spring-boot-starter-data-jdbc`，数据库采用H2。
* SpringBoot支持H2数据库，所以会自动创建H2连接。
* 由于使用了`spring-jdbc`，SpringBoot会自动创建`JdbcTemplate`，而`@Autowired JdbcTemplate`则会自动加载它。
* 当插入一条record时使用`insert`，当批量插入数据时使用`batchUpdate`。
