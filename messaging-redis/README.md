### Messaging with Redis

[![](https://img.shields.io/static/v1?label=doc&message=Messaging%20with%20Redis&color=green)](https://spring.io/guides/gs/messaging-redis/)

This guide walks you through the process of using Spring Data Redis to publish and subscribe to messages sent via Redis.

This is an application that uses `StringRedisTemplate` to publish a string message and has a [POJO](https://spring.io/understanding/POJO) subscribe for it using `MessageListenerAdapter`.

* `Receiver`是一个POJO类，可以将其注册为一个 message listener 来接受和处理消息，注册的时候可以指定处理方法；注册本质上是用一个`MessageListenerAdapter`进行了包装。
* Spring Data Redis 内置有所有的用于处理Redis消息接受和处理的组件，开发着通常需要配置如下几点：
  * A Redis template，用于向redis发送消息。
  * A message listener container，`Receiver`就是与它注册。
  * A connection factory，同时驱动`RedisTemplate`和`RedisMessageListenerContainer`与redis的连接。本例中使用了SpringBoot默认的`RedisConnectionFactory`。
