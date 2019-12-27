package com.hyungin.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.hyungin.basic.interceptor.SignInCheckInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private SignInCheckInterceptor signInCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/main");
		//addPathPatterns에 제한이 걸려서 main으로 접속할 때마다 login으로 튕김 
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}