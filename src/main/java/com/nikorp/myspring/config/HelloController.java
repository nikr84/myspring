package com.nikorp.myspring.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/showForm")
	public String showStudentForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processStudentForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormV2")
	public String processStudentFormV2(HttpServletRequest request, Model model) {
		var stuName = request.getParameter("studentName");
		model.addAttribute("message", "Yo! " + stuName.toUpperCase());
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String processStudentFormV3(@RequestParam("studentName") String stuName, Model model) {
		logger.debug("processFormV3");
		model.addAttribute("message", "Yo! " + stuName.toUpperCase());
		return "helloworld";
	}
}
