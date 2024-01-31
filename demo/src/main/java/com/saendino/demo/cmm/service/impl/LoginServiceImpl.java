package com.saendino.demo.cmm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saendino.demo.cmm.mapper.UserMapper;
import com.saendino.demo.cmm.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public String loginProc(Map<String, Object> loginInfo) {
		// 로그인 처리
		System.out.println("로그인 처리 되었습니다");
		
		if(loginInfo.isEmpty()) {
			return "fail";
		}
		
		String id = (String) loginInfo.get("id");
		String pw = (String) loginInfo.get("password");
		
		if(id.equals("saend00") && pw.equals("2580")) {
			return "success";
		} else {
			return "fail";
		}
	}

	//회원가입
	@Override
	public CommResult insertUser(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		int result = userMapper.insertUser(param);
		
		if(result == 0) { //오류
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
		} else { //성공
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMsg(CommResult.RESULT_S_MSG);
		}
		
		return commResult;
	}

	//로그인
	@Override
	public CommResult checkIdPw(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		Map<String, Object> result = userMapper.checkIdPw(param);
		
		
		if(result.get("CNT") == null || result.get("CNT").toString().equals("0")) { //오류
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
			commResult.setResultMap(result);
		} else { //성공
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMsg(CommResult.RESULT_S_MSG);
			commResult.setResultMap(result);
		}
		
		return commResult;
	}

	@Override
	public CommResult signUp(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		int result = userMapper.insertUser(param);
		
		if(result == 0) { //오류
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
		} else { //성공
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMsg(CommResult.RESULT_S_MSG);
		}
		
		return commResult;
	}
}
