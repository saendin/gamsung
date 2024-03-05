package com.saendino.demo.cmm.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SurveyMapper {
	public Map<String,Object> selectSurveyKey();
	
	public int insertSurvey(Map<String,Object> param);
	public int insertQuestion(Map<String,Object> param);
	public int insertAnswer(Map<String,Object> param);
	
	public ArrayList<?> selectSurveyList(Map<String, Object> param);
	
}
