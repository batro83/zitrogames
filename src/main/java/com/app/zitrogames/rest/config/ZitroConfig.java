package com.app.zitrogames.rest.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.app.zitrogames.rest.filter.JwtRequestFilter;

@Configuration
public class ZitroConfig {

	@Bean
	@Order(1)
	public FilterRegistrationBean<JwtRequestFilter> jwtRequestFilterRegistration() {
		FilterRegistrationBean<JwtRequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(jwtRequestFilter());
		registrationBean.addUrlPatterns("/casino/*");
		return registrationBean;
	}

	@Bean
	public JwtRequestFilter jwtRequestFilter() {
		return new JwtRequestFilter();
	}

}