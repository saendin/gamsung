package com.saendino.demo.cmm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;

import com.saendino.demo.cmm.service.CommService;

@Service
public class CommServiceImpl implements CommService {
//
//	@Autowired
//	CommDAO commDAO;
//	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 목록 조회
	 * @param map
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map, Map<String, Object> param) {
		
		if (MapUtils.isEmpty(map)) {
			return sqlSession.selectList(String.valueOf(param.get("path")), param.get("data"));
		} else {
			return sqlSession.selectList(String.valueOf(map.get("path")), map.get("data"));
		}
	}

	
	//	/* SELECT ONE */
//	@Override
//	public Map<?,?> selectData(Map<String, Object> param) {
//		return commDAO.selectData((String) param.get("queryId"), param.get("paramData"));
//	}

//	/* SELECT LIST */
//	@Override
//	public List<?> selectListData(Map<String, Object> param) {
//		return commDAO.selectListData((String) param.get("queryId"), param.get("paramData"));
//	}
	
//	/* INSERT */
//	@Override
//	public Map<?, ?> insertData(Map<String, Object> param) {
//		Map<String,Object> result = new HashMap<String,Object>();
//		result.put("result", commDAO.insertData((String) param.get("queryId"), param.get("paramData")));
//		
//		return result;
//	}
	
//	/* UPDATE */
//	@Override
//	public Map<?,?> updateData(Map<String, Object> param) {
//		Map<String,Object> result = new HashMap<String,Object>();
//		result.put("result", commDAO.updateData((String) param.get("queryId"), param.get("paramData")));
//		
//		return result;
//	}
	
//	/* DELETE */
//	@Override
//	public Map<?,?> deleteData(Map<String, Object> param) {
//		Map<String,Object> result = new HashMap<String,Object>();
//		result.put("result", commDAO.deleteData((String) param.get("queryId"), param.get("paramData")));
//		
//		return result;
//	}
}
