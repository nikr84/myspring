package com.nikorp.myspring.ioc;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nikorp.myspring.di.FortuneService;

public class SwimCoach implements Coach {
	
	private final static Logger logger = LoggerFactory.getLogger(SwimCoach.class);

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		logger.debug("SWIMCOACH Constructor() fortuneService=" + fortuneService);
	}
	
	@Override
	public String getDailyWorkout() {
		return "SWIM KARO SAALE";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PreDestroy
	public void windingUp() {
		logger.debug("Killing SwimCoach!");
	}
}
