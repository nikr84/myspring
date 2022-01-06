package com.nikorp.myspring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(MembershipDAO.class);

	private String fff;
	
	public void addAccount(int x) {
		logger.debug("AOP: ADD ACCOUNT METHOD CALLED X VALUE=" + x);
	}

	public String getFff() {
		logger.debug("AOP: getFff()");
		return fff;
	}

	public void setFff(String fff) {
		logger.debug("AOP: setFff()");
		this.fff = fff;
	}
	
}
