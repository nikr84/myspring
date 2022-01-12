package com.nikorp.myspring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.nikorp.myspring.di.FortuneService;
import com.nikorp.myspring.di.SadFortuneService;
import com.nikorp.myspring.ioc.Coach;
import com.nikorp.myspring.ioc.SwimCoach;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.nikorp.myspring")
public class NewSportsConfig {

	@Bean
	public MessageSource messageSource() {
		var messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setUseCodeAsDefaultMessage(true);
	    return messageSource;
	}
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
