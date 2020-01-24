package com.hyungin.basic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hyungin.basic.model.Product;
import com.hyungin.basic.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JpaController {
	// 어딘가에 작성된 ProductRepository를 가져다 쓰고 싶음. 원래는 new를 써야함.
	// spring이라고 하는 framework가 new를 안해도 되게끔 해줌. @Autowired를 사용하여. 연결시켜줌 (IocDI)
	// @Autowired가 가능한 기능 (@Repository, @Controller, @Service, @Component)
	@Autowired
	ProductRepository productRepository;

	
	// ProductRepository.java에 가서 먼저 메소드를 설정하고 (pdf2 36p) 코드 작성 
	@GetMapping("/jpa/product2")
	public List<Product> product2(String name) {
		List<Product> list = productRepository.findByName(name);
		return list;
	}
	
	
	@GetMapping("/jpa/product")
	public List<Product> product() {
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	//post 방식이니까 Talend API tester 사용하여 form - add form parameter
	@PostMapping("/jpa/product")
	public String productPost(@ModelAttribute Product product) {
		Product pro = productRepository.save(product);
		log.error(pro.toString()); //error는 string에 대해서만 받아주고 처리해주기 때문에 클래스에 toString()해주면 해당 데이터를 문자열로 풀어
		return "redirect:/jpa/product";
	}
}