package com.saendino.demo.cmm.service;

import java.util.Map;

public interface ProductService {
	public Map<String,Object> addProduct(Map<String,Object> param);

	public Map<String, Object> selectProductList(Map<String, Object> map);
}
