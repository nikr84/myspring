package com.nikorp.myspring.config;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("studentObject", new Student());
		fillShowForm(theModel);
		return "student-form";
	}

	private void fillShowForm(Model theModel) {
		theModel.addAttribute("theCountryOptions", countryOptions);
		theModel.addAttribute("theLanguageOptions", languageOptions);
		theModel.addAttribute("theOSOptions", osOptions);
	}
	
	@RequestMapping("/processForm")
	public String processForm(Model theModel, @Valid @ModelAttribute("studentObject") Student stu, BindingResult bindingResult) {
		logger.debug(stu.toString());
		logger.debug("Binding result: " + bindingResult);
		if (bindingResult.hasErrors()) {
			fillShowForm(theModel);
			return "student-form";
		}
		
		return "student-confirmation";
	}

}
