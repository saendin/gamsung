package com.saendino.demo.cmm.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	// 메소드명은 Mapper.xml에 작성될 쿼리문의 ID
		
	//회원가입
	public int insertUser(Map<String,Object> param);
	
	//로그인 검증
	public Map<String, Object> checkIdPw(Map<String,Object> param);

	//유저 cnt
	public Map<String, Object> selectUserList();

	//아이디 중복체크
	public int duplChkUserId(Map<String, Object> param);

	//아이디 찾기
	public String findId(Map<String, Object> param);

	//새 비밀번호 설정
	public int setNewPassword(Map<String, Object> param);
	
}
