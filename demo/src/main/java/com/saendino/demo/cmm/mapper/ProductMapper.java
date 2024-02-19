package com.saendino.demo.cmm.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	//메뉴조회
	public int insertProduct(Map<String,Object> param);

	public ArrayList<?> selectProductList(Map<String, Object> param);
}
