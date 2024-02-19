package com.saendino.demo.cmm.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saendino.demo.cmm.service.ProductService;
import com.saendino.demo.cmm.service.impl.CommResult;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/selectProductList.do")
	public CommResult selectProductList(@RequestBody Map<String,Object> param) {
		CommResult result = new CommResult();
		
		result.setResultMap(productService.selectProductList(param));
		result.setResultCode(CommResult.RESULT_S);
	
		return result;
	}
	
	@PostMapping("/addProduct.do")
	public CommResult addProduct(@RequestBody Map<String,Object> param) {
		CommResult result = new CommResult();
		
		if(param != null) {
			result.setResultMap(productService.addProduct((Map<String, Object>) param.get("dataInfo")));
			
			if(result.getResultMap().get("result").equals(0)) {
				result.setResultCode(CommResult.RESULT_E);
				result.setResultMsg(CommResult.RESULT_E_MSG);
			} else {
				result.setResultCode(CommResult.RESULT_S);
			}
		} else {
			result.setResultCode(CommResult.RESULT_W);
			result.setResultMsg(CommResult.RESULT_W_MSG);
			result.setResultMap(null);
		}
		
		return result;
	}
}
