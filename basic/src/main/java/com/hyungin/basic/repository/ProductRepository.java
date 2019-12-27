package com.hyungin.basic.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyungin.basic.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByName(String name);
}

//JpaRepository가 부모, ProductRepository가 자식. 그래서 자식이 부모의 특징들을 상속받음 