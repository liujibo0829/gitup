package com.baa.dailyreport.interceptor;

//import org.springframework.beans.BeansException;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//public class WebMvcConfig extends WebMvcConfigurationSupport implements ApplicationContextAware {
//
//	private ApplicationContext applicationContext;
//
//	public WebMvcConfig() {
//		super();
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		String resource = ResourceUtils.CLASSPATH_URL_PREFIX + "/static/";
//		registry.addResourceHandler("/**").addResourceLocations("/static/**");
//		String html = ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/";
//		registry.addResourceHandler("/**").addResourceLocations("/templates/**");
//
//		super.addResourceHandlers(registry);
//	}
//
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// 拦截规则：除了login，其他都拦截判断
//		registry.addInterceptor((HandlerInterceptor) new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
//		super.addInterceptors(registry);
//	}
//
//}
