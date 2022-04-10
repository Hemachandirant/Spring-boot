package com.simplilearn.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public String indexMapping() {
		return "Welcome, to spring boot developement, Server is up and running !";
	}
	@RequestMapping(value="/Hello",method = RequestMethod.GET)
	@ResponseBody
	public String helloMapping() {
		return "Hai Hemachandiran!, Welcome to Webservice Learning!";
	}
	
	@RequestMapping(value="/hi",method = RequestMethod.GET)
	@ResponseBody
	public String hiMapping(@RequestParam("name") String name) {
		return "Hai "+name+" welcome to webservice learning";
		
	}
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String idMapping(@PathVariable("id") long id) {
		return "Hai!, your ID is"+id;
	}
	
}
