package com.nikorp.myspring.config;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nikorp.myspring.model.Student;

@Controller
@RequestMapping("/student")
@PropertySource("classpath:/countries.properties")
@PropertySource("classpath:/languages.properties")
@PropertySource("classpath:/os.properties")
public class StudentController {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Value("#{${countryOptions}}")
	private Map<String, String> countryOptions;
	
	@Value("#{${languageOptions}}")
	private Map<String, String> languageOptions;
	
	@Value("#{${osOptions}}")
	private Map<String, String> osOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("studentObject", new Student());
		theModel.addAttribute("theCountryOptions", countryOptions);
		theModel.addAttribute("theLanguageOptions", languageOptions);
		theModel.addAttribute("theOSOptions", osOptions);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("studentObject") Student stu) {
		logger.debug(stu.toString());
		return "student-confirmation";
	}
}
