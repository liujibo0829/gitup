package com.baa.dailyreport;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication
@MapperScan("com.baa.dailyreport.dao")
public class DailyReportApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DailyReportApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DailyReportApplication.class, args);
	}
}
