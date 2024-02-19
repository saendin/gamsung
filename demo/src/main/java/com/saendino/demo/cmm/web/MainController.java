package com.saendino.demo.cmm.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saendino.demo.cmm.service.MainService;

@RestController
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@PostMapping("/menu.do")
	public Map<String, Object> selectMenuList(@RequestBody Map<String, Object> param) {
		
		return mainService.selectMenuList(param);
	}
	
}
