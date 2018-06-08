package com.szczepaniak.zmwaw.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.szczepaniak.zmwaw.interceptor.AddressInterceptor;
import com.szczepaniak.zmwaw.interceptor.PersonInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new PersonInterceptor()).addPathPatterns("/person/*");
		registry.addInterceptor(new AddressInterceptor()).addPathPatterns("/address/*");
	}
}
