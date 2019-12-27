package com.hyungin.basic.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyungin.basic.model.Member;

@RestController
public class RequestController {

	
	// 주소창에 model 변수명 그대로 맞춰서 
	// http://localhost:8080/req/model?name=11&userId=22&userPassword=33
	@GetMapping("req/model")
	public String model(@ModelAttribute Member member) {
		return member.toString();
	}

	
	
	@GetMapping("req/http")
	@ResponseBody
	public String http(HttpServletRequest request) {

		String name = request.getParameter("name");
		String pageNum = request.getParameter("pageNum");
		return name + ", " + pageNum;
	}

	
	
	@GetMapping("req/param1")
	public String param1(@RequestParam("key1") String key1, @RequestParam("key2") String key2) {
		return key1 + ", " + key2;
	}

	
	
	@GetMapping("req/param2")
	public String param2(@RequestParam Map<String, Object> map) {
		return map.toString();
	}
}