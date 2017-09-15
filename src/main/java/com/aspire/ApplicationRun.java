package com.aspire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRun {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationRun.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args);
		logger.info("系统加载完毕");
		System.out.println("-----------------OK------------------");
	}
}
