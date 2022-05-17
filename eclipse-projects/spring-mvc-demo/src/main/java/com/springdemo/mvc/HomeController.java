package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "home-page";
	}
	
	@RequestMapping("/displayForm")
	public String displayForm() {
		return "input-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "display-info";
	}
	
	@RequestMapping("display-info")
	public String doCaseConversion(HttpServletRequest request, Model model) {
		String name = request.getParameter("employeeName");
		
		name = name.toUpperCase();
		
		String msg = "Good morning " + name;
		
		model.addAttribute("message", msg);
		
		return "display-info";
	}
	
	
}
