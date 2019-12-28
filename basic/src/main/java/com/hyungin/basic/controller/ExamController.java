package com.hyungin.basic.controller;




import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ExamController {
	@ResponseBody
	@GetMapping("/Exam")
	 public Map getString() {
	 RestTemplate rt = new RestTemplate();
	 Map result = rt.getForObject("http://ggoreb.com/m/exam.jsp", Map.class);
	 return result;
	 }
	
	@GetMapping("/exam")
	public String exam() {
		return "exam";
	}
	
}