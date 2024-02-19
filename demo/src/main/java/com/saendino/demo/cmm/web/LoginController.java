package com.saendino.demo.cmm.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saendino.demo.cmm.service.LoginService;
import com.saendino.demo.cmm.service.impl.CommResult;

@RestController
public class LoginController {
	
	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class.getSimpleName());
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/loginProc.do")
	public Map<String, Object> LoginProc(@RequestBody Map<String, Object> param) {
		CommResult commResult = loginService.checkIdPw(param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", commResult);
		
		return result;
	}
	
	@PostMapping("/signUp.do")
	public Map<String, Object> signUp(@RequestBody Map<String, Object> param) {
		
		if(param != null) {
			param = (Map<String, Object>) param.get("dataInfo");
			
			String phone = "";
			phone += (param.get("phone1"));
			phone += (param.get("phone2"));
			phone += (param.get("phone3"));
			
			param.put("phone", phone);
		}
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result.put("result", loginService.signUp(param));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.toString());
		}
		
		return result;
	}
	
	@PostMapping("/checkDuplId.do")
	public Map<String, Object> checkDuplId(@RequestBody Map<String,Object> param) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", loginService.checkDuplId(param));
		
		return result;
	}
	
	@PostMapping("/findId.do")
	public Map<String, Object> findId(@RequestBody Map<String,Object> param) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", loginService.findId(param));
		
		return result;
	}
	
	@PostMapping("/setNewPassword.do")
	public Map<String, Object> resetPw(@RequestBody Map<String,Object> param) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", loginService.setNewPassword(param));
		
		return result;
	}
	
	
}
