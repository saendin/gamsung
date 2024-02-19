package com.saendino.demo.cmm.service.impl;

import java.util.Map;

public class CommResult {
	
	//처리 성공 여부
	public final static String RESULT_S = "S";
	public final static String RESULT_W = "W";
	public final static String RESULT_E = "E";
	// 메시지
	public final static String RESULT_S_MSG = "정상적으로 처리되었습니다.";
	public final static String RESULT_W_MSG = "처리 할 파라미터값이 없습니다.";
	public final static String RESULT_E_MSG	= "데이터 처리 도중 오류가 발생했습니다.";
	
	private String resultCode;
	private String resultMsg;
	private Map<String, Object> resultMap;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> result) {
		this.resultMap = result;
	}
}

