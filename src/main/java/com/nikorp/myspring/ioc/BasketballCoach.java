package com.nikorp.myspring.ioc;

import com.nikorp.myspring.di.FortuneService;

public class BasketballCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	
	public BasketballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String getDailyWorkout() {
		return "BBBBBBAAAASSKETBALLLL from " + emailAddress;
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
