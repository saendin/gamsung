package com.saendino.demo.cmm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saendino.demo.cmm.mapper.ProductMapper;
import com.saendino.demo.cmm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class.getSimpleName());
	
	@Autowired
	private ProductMapper productMapper;

	// 상품 추가
	@Override
	public Map<String, Object> addProduct(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		result.put("result", productMapper.insertProduct(param));
		
		return result;
	}

	// 상품 목록 조회
	@Override
	public Map<String, Object> selectProductList(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		result.put("result", productMapper.selectProductList(param));
		
		return result;
	}
}
