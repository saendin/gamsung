package com.saendino.demo.cmm.service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.saendino.demo.cmm.service.impl.CommResult;

public interface LoginService {
	
	//로그인검증
	public CommResult checkIdPw (Map<String, Object> param);

	public CommResult signUp(Map<String, Object> param) throws NoSuchAlgorithmException;

	public CommResult checkDuplId(Map<String, Object> param);

	public String findId(Map<String, Object> param);

	public CommResult setNewPassword(Map<String, Object> param);
	
}
