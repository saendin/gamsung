package com.saendino.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saendino.demo.cmm.mapper.UserMapper;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	@DisplayName("User Mapper Test")
	void contextLoads() {
		System.out.println(userMapper.selectUserList());
		
        // given
		int userListCnt = 0;

        // when
        userListCnt = Integer.parseInt(String.valueOf(userMapper.selectUserList().get("CNT")));

        // then
        assertThat(userListCnt).isEqualTo(1);

	}

}
