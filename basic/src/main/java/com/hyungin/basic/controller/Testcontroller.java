package com.hyungin.basic.controller;

//Shift Cmd O (전체 import)
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	@GetMapping("/test")
	public String test() {
		return "<h1>Hello~</h1>";
		
	}
}
