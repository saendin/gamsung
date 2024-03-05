package com.saendino.demo.cmm.service;

import java.util.Map;

public interface SurveyService {
	public Map<String,Object> addSurvey(Map<String,Object> param);

	public Map<String, Object> selectSurveyList(Map<String, Object> map);
}
