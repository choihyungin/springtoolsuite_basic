package com.hyungin.basic.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hyungin.basic.model.User;

@Controller
public class SessionController {
	@GetMapping("/login")
	public String login() {
	return"login";
	}

	@PostMapping("/login")
	public String loginPost(User user, HttpSession session) {
		// 세션은 어디서든지 (현재 스프링 서버) 사용 가능 
		session.setAttribute("user", user);
			//redirect 이쪽 주소로 던지겠다는 뜻. request가 들어와서 view templates을 거쳐서 응답으로 간다가 아니라..
	return"redirect:/main";
	}

	@GetMapping("/main")
	public String main() { 
		return "main"; 
	}
}
