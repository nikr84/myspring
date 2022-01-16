package com.nikorp.myspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nikorp.myspring.hibernate.dao.EmployeeDAO;
import com.nikorp.myspring.hibernate.dao.EmployeeRepository;

@Controller
public class HomeController {
	
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public HomeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		logger.debug("employeeRepository.findAll()=" + employeeRepository.findAll());
		return "landing";
	}
	
	@RequestMapping("/home")
	public String showMainPage() {
		return "main-menu";
	}
	
	@RequestMapping("/home/leaders")
	public String showLeadersPage() {
		return "leaders-page";
	}
	
	@GetMapping("/home/accessdenied")
	public String accessDeniedPage() {
		return "access-denied";
	}

}
