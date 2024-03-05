package com.saendino.demo.cmm.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saendino.demo.cmm.service.ProductService;
import com.saendino.demo.cmm.service.impl.CommResult;

@RestController
public class SurveyController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/selectSurveyList.do")
	public CommResult selectProductList(@RequestBody Map<String,Object> param) {
		CommResult result = new CommResult();
		
		result.setResultMap(productService.selectProductList(param));
		result.setResultCode(CommResult.RESULT_S);
	
		return result;
	}
	
	@PostMapping("/addSurvey.do")
	public CommResult addProduct(@RequestBody Map<String,Object> param) {
		CommResult result = new CommResult();
		
		if(param != null) {
			result.setResultMap(productService.addProduct((Map<String, Object>) param.get("dataInfo")));
			
			if(result.getResultMap().get("result").equals(0)) { //등록 실패
				result.setResultCode(CommResult.RESULT_E);
				result.setResultMsg(CommResult.RESULT_E_MSG);
			} else { //등록 성공
				result.setResultCode(CommResult.RESULT_S);
			}
			
		} else { //param값 없음
			result.setResultCode(CommResult.RESULT_W);
			result.setResultMsg(CommResult.RESULT_W_MSG);
			result.setResultMap(null);
		}
		
		return result;
	}
}
