package com.getset.messagingredis;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@Log4j2
@SpringBootApplication
public class MessagingRedisApplication {

    @Bean
	public CountDownLatch countDownLatch() {
    	return new CountDownLatch(1);
	}

	@Bean
	public Receiver receiver(CountDownLatch countDownLatch) {
    	return new Receiver(countDownLatch);
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
    	return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter listenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(redisConnectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
		return container;
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
    	return new StringRedisTemplate(connectionFactory);
	}

	public static void main(String[] args) throws InterruptedException {
		final ApplicationContext context = SpringApplication.run(MessagingRedisApplication.class, args);
		final StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
		final CountDownLatch latch = context.getBean(CountDownLatch.class);

		log.info("Sending message ...");
		template.convertAndSend("chat", "Hello, redis!");

		latch.await();
		System.exit(0);
	}

}
