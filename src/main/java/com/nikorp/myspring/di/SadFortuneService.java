package com.nikorp.myspring.di;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your fucky day!";
	}

}
