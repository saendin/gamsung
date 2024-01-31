package com.saendino.demo.cmm.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saendino.demo.cmm.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/loginProc.do")
	public Map<String, Object> LoginProc(@RequestBody Map<String, Object> param) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", loginService.checkIdPw(param));
		
		return result;
	}
	
	@PostMapping("/signUp.do")
	public Map<String, Object> signUp(@RequestBody Map<String, Object> param) {
		
		param = (Map<String, Object>) param.get("dataInfo");
		
		String phone = "";
		phone += (param.get("phone1"));
		phone += (param.get("phone2"));
		phone += (param.get("phone3"));
				
		param.put("phone", phone);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("result", loginService.signUp(param));
		
		return result;
	}
}
