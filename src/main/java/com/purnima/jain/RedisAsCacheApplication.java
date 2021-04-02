package com.purnima.jain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableCaching
public class RedisAsCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAsCacheApplication.class, args);
		log.info("Started RedisAsCacheApplication..............");
	}

}
