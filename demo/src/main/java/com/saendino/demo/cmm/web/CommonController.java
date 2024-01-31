package com.saendino.demo.cmm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
    @GetMapping("/login.do")
    public String login(Model model) {
        return "pages/main/login";
    }
    
    @GetMapping("/main.do")
    public String main(Model model) {
    	return "pages/main/main";
    }
    
    @GetMapping("/signUpPage.do")
	public String signUp(Model model) {
		return "pages/main/signUp";
	}
}
