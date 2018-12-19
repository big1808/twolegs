package com.tedu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("hello/")
public class UserContrller {
	@RequestMapping("hi")
	public String hi() {
		return "hello    ddddtwolegs!";
	public String hi( int i) {

		return "hello twolegs!";	
		
	}
}
