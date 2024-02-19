package com.saendino.demo.cmm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface MainMapper {
	//메뉴조회
	public List<?> selectMenuList(Map<String,Object> param);
	
}
