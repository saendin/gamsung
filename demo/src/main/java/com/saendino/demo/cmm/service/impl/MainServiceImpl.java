package com.saendino.demo.cmm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saendino.demo.cmm.mapper.MainMapper;
import com.saendino.demo.cmm.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainMapper mainMapper;
	
	@Override
	public Map<String, Object> selectMenuList(Map<String, Object> param) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List list = new ArrayList();
		list = mainMapper.selectMenuList(param);
		
		result.put("result", list);
		
		return result;
	}

}
