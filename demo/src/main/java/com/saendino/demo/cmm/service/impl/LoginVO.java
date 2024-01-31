package com.saendino.demo.cmm.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@Getter
@ToString
@AllArgsConstructor // 어노테이션을 사용하는 것으로, 인자를 받아 필드에 대입하는 생성자를 자동으로 생성할 수 있다.
@NoArgsConstructor 	// 어노테이션을 사용하는 것으로, 인자가 없는 생성자를 자동으로 생성
public class LoginVO {
	private String id;			// 아이디
	private String password;	// 비밀번호
	private String grade; 		// 등급
	private String name;		// 이름
	private String phoneNumber;	// 휴대폰번호
	private String zip;			// 우편번호
	private String address;		// 주소
}
