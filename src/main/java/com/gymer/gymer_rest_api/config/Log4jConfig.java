package com.gymer.gymer_rest_api.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
public class Log4jConfig {

	@PostConstruct
	public void init() {
		File file = new File("src/main/resources/log4j.properties");
		PropertyConfigurator.configure(file.getAbsolutePath());
	}
}
