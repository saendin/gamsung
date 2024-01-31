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
	
}
