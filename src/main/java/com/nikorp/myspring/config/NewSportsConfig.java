package com.nikorp.myspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nikorp.myspring.di.FortuneService;
import com.nikorp.myspring.di.SadFortuneService;
import com.nikorp.myspring.ioc.Coach;
import com.nikorp.myspring.ioc.SwimCoach;

@Configuration
public class NewSportsConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
