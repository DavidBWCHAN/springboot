package com.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties(Setting.class)
@EntityScan("com.springboot.entity")
@EnableJpaRepositories("com.springboot.repository")
public class Application implements EmbeddedServletContainerCustomizer {
	private static int port = 8080;
	public static void main(String[] args) throws Exception {
		if(args.length > 0){
			port = Integer.parseInt(args[0]);
		}
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(port);
	}
}
