package com.nikorp.myspring.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.nikorp.myspring.di.FortuneService;

@Component
@Lazy
public class TrackCoach implements Coach {
	
	private final static Logger logger = LoggerFactory.getLogger(TrackCoach.class);

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.phone}")
	private String phone;
	
	public TrackCoach() {
		logger.debug("TRACKCOACH Constructor()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "TRAAAAACKK ka phone=" + phone;
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void callPostConstruct() {
		logger.debug("TRACKCOACH POST CONSTRUCT");
		logger.debug("fortuneService=" + fortuneService);
	}
	
	@PreDestroy
	public void callPreDestroy() {
		logger.debug("TRACKCOACH PRE DESTROY");
		fortuneService = null;
		logger.debug("fortuneService=" + fortuneService);
	}
	
}
