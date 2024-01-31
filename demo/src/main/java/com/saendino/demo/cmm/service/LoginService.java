package com.saendino.demo.cmm.service;

import java.util.Map;

import com.saendino.demo.cmm.service.impl.CommResult;

public interface LoginService {
	
	//회원가입
	public CommResult insertUser (Map<String,Object> param);
	
	//로그인검증
	public CommResult checkIdPw (Map<String, Object> param);
	
	//로그인처리
	public String loginProc (Map<String, Object> param);

	public CommResult signUp(Map<String, Object> param);
	
}
