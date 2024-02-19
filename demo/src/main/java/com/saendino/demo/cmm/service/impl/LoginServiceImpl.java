package com.saendino.demo.cmm.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saendino.demo.cmm.mapper.UserMapper;
import com.saendino.demo.cmm.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class.getSimpleName());
	
	@Autowired
	private UserMapper userMapper;

	//로그인
	@Override
	public CommResult checkIdPw(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		// 비밀번호 평문
//		String rawPw = (String) param.get("password");
//		String hex = "";
//		hex = encrypt(rawPw); //암호화
//		
//		param.put("password", hex);
		
		Map<String, Object> result = userMapper.checkIdPw(param);
		String cnt = result.get("CNT").toString();
		
		if(!result.isEmpty()) {
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMap(result);
			
			if(cnt.equals("0")) {
				commResult.setResultMsg("아이디 혹은 비밀번호를 확인해주세요!");
			} else {
				commResult.setResultMsg("로그인되었습니다.");
			}
			
		} else {
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
			commResult.setResultMap(result);
		}
		
		return commResult;
	}

	/* 회원가입 */
	@Override
	public CommResult signUp(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		// 비밀번호 평문
		String rawPw = (String) param.get("password");
		String hex = "";
		hex = encrypt(rawPw); //암호화
		
		param.put("password", hex);
		
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

	@Override
	public CommResult checkDuplId(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		int result = userMapper.duplChkUserId(param);
		
		if(result == 0) { //사용가능
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMsg(CommResult.RESULT_S_MSG);
		} else { //사용불가능
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
		}
		
		return commResult;
	}

	@Override
	public String findId(Map<String, Object> param) {
		String result = userMapper.findId(param);
		
		return result;
	}

	@Override
	public CommResult setNewPassword(Map<String, Object> param) {
		CommResult commResult = new CommResult();
		
		// 비밀번호 평문
//		String rawPw = (String) param.get("password");
//		String hex = "";
//		hex = encrypt(rawPw); //암호화
//		
//		param.put("password", hex);
		
		int result = userMapper.setNewPassword(param);
		
		if(result == 1) { //성공
			commResult.setResultCode(CommResult.RESULT_S);
			commResult.setResultMsg(CommResult.RESULT_S_MSG);
		} else { //실패
			commResult.setResultCode(CommResult.RESULT_E);
			commResult.setResultMsg(CommResult.RESULT_E_MSG);
		}
		
		return commResult;
	}
	
	/* 암호화 */
	private String encrypt(String rawPw) {
		String hex = "";
		
		// "SHA1PRNG"은 알고리즘 이름
		SecureRandom random;
		byte[] bytes = new byte[16];
		
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			
			random.nextBytes(bytes);
			
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("NoSuchAlgorithmException ==========> " + e.toString());
		}
		
		// SALT 생성
		String salt = new String(Base64.getEncoder().encode(bytes));
		String rawPwAndSalt = rawPw + salt;
		
		LOGGER.debug("원 비번 : "	+ rawPw);
		LOGGER.debug("salt : "	+ salt);
		LOGGER.debug("rawPwAndSalt : "	+ rawPwAndSalt);
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			
			// 평문 암호화
			md.update(rawPw.getBytes());
			hex = String.format("%064x", new BigInteger(1, md.digest()));
			
			LOGGER.debug("rawPw의 해시값 : " + hex);
			
			md.update(rawPwAndSalt.getBytes());// rawPw + salt =>sha-256 암호화
			
			hex = String.format("%064x", new BigInteger(1, md.digest())); // 값 해시로 변환
			
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("NoSuchAlgorithmException ==========> " + e.toString());
		}
		
		// 평문+salt 암호화
		LOGGER.debug("rawPwAndSalt 해시값 : " + hex);
		
		return hex;
	}
	
}
