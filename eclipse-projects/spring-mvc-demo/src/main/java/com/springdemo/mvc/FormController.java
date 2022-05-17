package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class FormController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	
	
	@RequestMapping("/displayForm")
	public String displayForm(Model model) {
		
		Student student = new Student();
		model.addAttribute(student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult) {
		
		System.out.println(student.getName() + " " + student.getPhone());
		System.out.println("Binding Result: "+ bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "student-form";
		}
		else {
			return "show-details";
		}
		
	}
	
}
