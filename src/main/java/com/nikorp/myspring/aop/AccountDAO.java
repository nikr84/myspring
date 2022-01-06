package com.nikorp.myspring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(AccountDAO.class);
	
	private int x;
	
	public void addAccount() {
		logger.debug("AOP: ADD ACCOUNT METHOD CALLED");
	}

	public int getX() {
		logger.debug("AOP: getX()");
		return x;
	}

	public void setX(int x) {
		logger.debug("AOP: setX()");
		this.x = x;
	}
	
}
