package com.nikorp.myspring.di;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RandomFortuneService implements FortuneService, DisposableBean {

	private final static Logger logger = LoggerFactory.getLogger(RandomFortuneService.class);
	
	private String[] fortunes = null;
	private Random rd = null;
	
	public RandomFortuneService() {
		logger.debug("RandomFortuneService Constructor()");
		rd = new Random();
	}
	
	@Override
	public String getFortune() {
		return fortunes[rd.nextInt(fortunes.length)];
	}

	@PostConstruct
	public void callPostConstruct() {
		logger.debug("RandomFortuneService POST CONSTRUCT");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(RandomFortuneService.class.getClassLoader().getResource("fortunes.txt").getPath()));
			var tempList = br.lines().filter(x -> x != null).map(x -> x.trim()).collect(Collectors.toList());
			fortunes = tempList.toArray(new String[tempList.size()]);
		} catch (Exception e) {
			logger.error("falling back to hard-coded values", e);
			fortunes = new String[] {"Good", "Bad", "Ugly"};
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					logger.error("", e);
				}
		}
		
		logger.debug("this=" + this);
	}
	
	@Override
	public void destroy() throws Exception {
		logger.debug("RandomFortuneService DISPOSABLEBEAN -> destroy()");
		rd = null;
		logger.debug("this.rd=" + rd);
	}

}
