package com.saendino.demo.cmm.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class LayoutController {
	
	// thymeleaf layout
	// layout-dialect를 사용하기 위한 bean 등록
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
