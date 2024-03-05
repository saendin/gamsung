package com.saendino.demo.cmm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saendino.demo.cmm.mapper.SurveyMapper;
import com.saendino.demo.cmm.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	/** log */
	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class.getSimpleName());
	
	@Autowired
	private SurveyMapper surveyMapper;

	// 상품 추가
	@Override
	public Map<String, Object> addSurvey(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		String sSnKey = "";
		
		if(surveyMapper.selectSurveyKey() != null) {
			sSnKey = (String) (surveyMapper.selectSurveyKey()).get("SSN"); //설문 SN 생성
		}
		
		param.put("sSn", sSnKey); //생성키 주입
		
		result.put("result", surveyMapper.insertSurvey(param)); 	//설문 등록
		result.put("result", surveyMapper.insertQuestion(param));	//질문 등록
		result.put("result", surveyMapper.insertAnswer(param));		//답변 문항 등록
		
		return result;
	}

	// 상품 목록 조회
	@Override
	public Map<String, Object> selectSurveyList(Map<String, Object> param) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		result.put("result", surveyMapper.selectSurveyList(param));
		
		return result;
	}
}
