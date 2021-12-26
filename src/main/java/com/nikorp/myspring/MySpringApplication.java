package com.nikorp.myspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nikorp.myspring.config.NewSportsConfig;
import com.nikorp.myspring.ioc.Coach;

@SpringBootApplication
@ComponentScan("com.nikorp.myspring")
public class MySpringApplication {

	private final static Logger logger = LoggerFactory.getLogger(MySpringApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringApplication.class, args);
		
		logger.info("shit");
//		new Thread(() -> new Runnable() {
//		public void run() {
			new MySpringApplication().run();
//		}
//	}).start();
	}
	
	private void run() {
		ClassPathXmlApplicationContext context = null;
		AnnotationConfigApplicationContext context2 = null;
		try {
//			context2 = new AnnotationConfigApplicationContext(OldSportsConfig.class);
//			context = new ClassPathXmlApplicationContext("applicationContext.xml");
//			
//			Coach basketballCoach = context.getBean("myCoach", Coach.class);
//			logger.debug("basketballCoach.getDailyWorkout()="+basketballCoach.getDailyWorkout());
//			logger.debug("basketballCoach.getDailyFortune(1)="+basketballCoach.getDailyFortune());
//			logger.debug("basketballCoach.getDailyFortune(2)="+basketballCoach.getDailyFortune());
//			logger.debug("basketballCoach.getDailyFortune(3)="+basketballCoach.getDailyFortune());
//			
//			Coach trackCoachCoach = context2.getBean("trackCoach", Coach.class);
//			logger.debug("trackCoachCoach.getDailyWorkout()="+trackCoachCoach.getDailyWorkout());
//			logger.debug("trackCoachCoach.getDailyFortune(1)="+trackCoachCoach.getDailyFortune());
//			logger.debug("trackCoachCoach.getDailyFortune(2)="+trackCoachCoach.getDailyFortune());
//			logger.debug("trackCoachCoach.getDailyFortune(3)="+trackCoachCoach.getDailyFortune());
			
			context2 = new AnnotationConfigApplicationContext(NewSportsConfig.class);
			Coach swimCoachCoach = context2.getBean("swimCoach", Coach.class);
			logger.debug("swimCoachCoach.getDailyWorkout()="+swimCoachCoach.getDailyWorkout());
			logger.debug("swimCoachCoach.getDailyFortune(1)="+swimCoachCoach.getDailyFortune());
		} finally {
			if (context != null)
				context.close();
			
			if (context2 != null)
				context2.close();
		}
	}

}
