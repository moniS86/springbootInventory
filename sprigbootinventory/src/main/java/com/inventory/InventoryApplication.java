package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.inventory.model.Inventory;

@SpringBootApplication
@EnableJpaAuditing
public class InventoryApplication {

	// Redis cache implementation
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Inventory> redisTemplate() {
		RedisTemplate<String, Inventory> redisTemplate = new RedisTemplate<String, Inventory>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	// To start the Inventory application
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}