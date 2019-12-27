package com.hyungin.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
	@GetMapping("req/get")
	public String get() {
		return "GET";
	}

	// get은 되는데 post가 안되는 이유. get을 제외한 나머지 방식들은 평범한 방식으로 호출이 안 됨 (직접 접근이 안 됨)
	// 그래서 Talend API tester 사용 (브라우저에서 호출하는 방식은 무조건 get이기 때문에..)
	
	@PostMapping("req/post")
	public String post() {
		return "POST";
	}

	@PutMapping("req/put")
	public String put() {
		return "PUT";
	}

	@DeleteMapping("req/delete")
	public String delete() {
		return "DELETE";
	}
	
	
}