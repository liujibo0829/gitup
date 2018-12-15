package com.baa.dailyreport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baa.dailyreport.dao")
public class DailyReport66Application {

	public static void main(String[] args) {
		SpringApplication.run(DailyReport66Application.class, args);
	}
}
