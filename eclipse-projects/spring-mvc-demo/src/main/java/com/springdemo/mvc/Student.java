package com.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	
	@NotNull(message = "Required field. you can't keep it Blank!")
	@Size(min=1, message="Enter atleast more than or equal to 2 chars!")
	private String name;
	
	@NotNull(message="Required, Please enter phone no.")
	@Pattern(regexp = "^[0-9]{10}", message="Enter Valid Phone Number.")
	private String phone;
	
	@NotNull(message="Required field, Please enter your age.")
	@Min(value = 0, message = "Age can't be less than 0. please enter valid age!")
	@Max(value = 100, message = "must be less than or equal to 100.")
	private Integer age;
	
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	
	@NotEmpty(message="please select gender.")
	private String gender;
	private String[] progLanguages;
	
	
	public String[] getProgLanguages() {
		return progLanguages;
	}
	public void setProgLanguages(String[] progLanguages) {
		this.progLanguages = progLanguages;
	}
	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		
		countryOptions.put("India", "India");
		countryOptions.put("China", "China");
		countryOptions.put("USA", "USA");
		countryOptions.put("Germany", "Germany");
		countryOptions.put("Canada", "Canada");

	}
	
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


}
