package com.qingsong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableElasticsearchRepositories(basePackages = {com.qingsong.repository})
// @EnableJpaRepositories
public class SpringbootEsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEsDemoApplication.class, args);
	}

}

