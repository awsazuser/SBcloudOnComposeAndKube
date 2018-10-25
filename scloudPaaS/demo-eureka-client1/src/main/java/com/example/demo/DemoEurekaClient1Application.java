package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCaching
@Configuration

public class DemoEurekaClient1Application {
	public static void main(String[] args) {
	SpringApplication.run(DemoEurekaClient1Application.class, args);
	}
}
