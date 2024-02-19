package com.saendino.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saendino.demo.cmm.mapper.UserMapper;
import com.saendino.demo.cmm.service.CommService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CommService commService;

	 @DisplayName("User Mapper Test")
	 void contextLoads() {
		 System.out.println(userMapper.selectUserList());
		 
		  // given int userListCnt = 0;
		  
		  // when userListCnt =
		  Integer.parseInt(String.valueOf(userMapper.selectUserList().get("CNT")));
		  
		  // then assertThat(userListCnt).isEqualTo(1);
		  
	  }
	 

	@DisplayName("Bean Test")
	void BeanTest() {
		// given
		Map<String, Object> paramData = new HashMap<String, Object>();
		paramData.put("userId", "admin");
		paramData.put("password", "1234");

		Map<String, Object> info = new HashMap<String, Object>();
		info.put("queryId", "UserMapper.checkIdPw");
		info.put("data", paramData);

		// when
//		commService.selectData(paramData);

		// then
//		assertThat(commService.selectData(paramData).get("CNT")).isEqualTo(1);
	}

	@Test
	@DisplayName("Check id pw Test")
	void checkIdPwTest() {
		// given
		Map<String, Object> paramData = new HashMap<String, Object>();
		paramData.put("userId", "admin");
		paramData.put("password", "1234");

		Map<String, Object> info = new HashMap<String, Object>();
		info.put("queryId", "UserMapper.checkIdPw");
		info.put("data", paramData);

		// when
//		commService.selectData(paramData);

		// then
//		assertThat(commService.selectData(paramData).get("CNT")).isEqualTo(1);
	}

}
