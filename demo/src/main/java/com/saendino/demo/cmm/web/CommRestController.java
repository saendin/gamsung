//package com.saendino.demo.cmm.web;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.saendino.demo.cmm.service.CommService;
//import com.saendino.demo.cmm.service.impl.CommResult;
//
///**
// * @Class Name : CommRestController.java
// * @Description : 공통 restAPI 서비스를 처리하는 컨트롤러
// * @Modification Information
// * 
// * 	수정일			수정자		수정내용
// * 	----------		-------		-------------------
// * 	2024.02.06.		홍선진		최초작성
// *
// * @author 홍선진
// * @since 2024.02.06.
// * @version 1
// * @see
// *
// */
//@RestController
//public class CommRestController {
//	
//	CommService commService;
//	
//	@Autowired
//	public CommRestController(CommService commService) {
//		this.commService = commService;
//		// TODO Auto-generated constructor stub
//	}
//	
//	//공통 selectData 반환
//	@SuppressWarnings("unchecked")
//	@PostMapping("/comm/selectData.do")
//	public CommResult selectData(@RequestBody Map<String,Object> param) {
//		
//		Map<String,Object> data = new HashMap<String,Object>();
//		CommResult result = new CommResult();
//		
//		Class clss;
////		String commservice = "commService.selectData(param)";
//		
//		try {
//			clss = Class.forName("CommService");
//			clss.getMethod("selectData",param.getClass());
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		//파람 널값 체크
//		if(param != null) {
////			param = UserStringUtils.unscriptMap(param); // 넘어온 데이터 XSS 방지
//			
////			param = param; //복호화 해줄것*******************
//			result.setResultMap((Map<String, Object>) commService.selectData(param));
//			
//			if(result != null) {
////				result = UserStringUtils.unscriptMap(result); // 결과값 XSS 방지
//			}
//			result.setResultCode(CommResult.RESULT_S);
//			result.setResultMsg(CommResult.RESULT_S_MSG);
//		} else {
//			result.setResultCode(CommResult.RESULT_W);
//			result.setResultMsg(CommResult.RESULT_W_MSG);
//		}
//		return result;
//	}
//	
//	//공통 selectListData 반환
//	@PostMapping("/comm/selectListData.do")
//	public CommResult selectListData(@RequestBody Map<String,Object> param) {
//		Map<String,Object> data = new HashMap<String,Object>();
//		CommResult result = new CommResult();
//		
//		//파람 널값 체크
//		if(param != null) {
////			param = UserStringUtils.unscriptMap(param); // 넘어온 데이터 XSS 방지
//			
//			data = (Map<String, Object>) param.get("dataInfo"); //복호화 해줄것*******************
//			result.setResultMap((Map<String, Object>) commService.selectListData(data));
//			
//			if(result != null) {
////				result = UserStringUtils.unscriptMap(result); // 결과값 XSS 방지
//			}
//			result.setResultCode(CommResult.RESULT_S);
//			result.setResultMsg(CommResult.RESULT_S_MSG);
//		} else {
//			result.setResultCode(CommResult.RESULT_W);
//			result.setResultMsg(CommResult.RESULT_W_MSG);
//		}
//		return result;
//	}
//	
//	//공통 insertData 반환
//	@PostMapping("/comm/insertData.do")
//	public CommResult insertData(@RequestBody Map<String,Object> param) {
//		Map<String,Object> data = new HashMap<String,Object>();
//		CommResult result = new CommResult();
//		
//		//파람 널값 체크
//		if(param != null) {
////			param = UserStringUtils.unscriptMap(param); // 넘어온 데이터 XSS 방지
//			
//			data = (Map<String, Object>) param.get("dataInfo"); //복호화 해줄것*******************
//			result.setResultMap((Map<String, Object>) commService.insertData(data));
//			
//			if(result != null) {
////				result = UserStringUtils.unscriptMap(result); // 결과값 XSS 방지
//			}
//			result.setResultCode(CommResult.RESULT_S);
//			result.setResultMsg(CommResult.RESULT_S_MSG);
//		} else {
//			result.setResultCode(CommResult.RESULT_W);
//			result.setResultMsg(CommResult.RESULT_W_MSG);
//		}
//		return result;
//	}
//	
//	//공통 updateData 반환
//	@PostMapping("/comm/updateData.do")
//	public CommResult updateData(@RequestBody Map<String,Object> param) {
//		Map<String,Object> data = new HashMap<String,Object>();
//		CommResult result = new CommResult();
//		
//		//파람 널값 체크
//		if(param != null) {
////			param = UserStringUtils.unscriptMap(param); // 넘어온 데이터 XSS 방지
//			
//			data = (Map<String, Object>) param.get("dataInfo"); //복호화 해줄것*******************
//			result.setResultMap((Map<String, Object>) commService.updateData(data));
//			
//			if(result != null) {
////				result = UserStringUtils.unscriptMap(result); // 결과값 XSS 방지
//			}
//			result.setResultCode(CommResult.RESULT_S);
//			result.setResultMsg(CommResult.RESULT_S_MSG);
//		} else {
//			result.setResultCode(CommResult.RESULT_W);
//			result.setResultMsg(CommResult.RESULT_W_MSG);
//		}
//		return result;
//	}
//	
//	//공통 deleteData 반환
//	@PostMapping("/comm/deleteData.do")
//	public CommResult deleteData(@RequestBody Map<String,Object> param) {
//		Map<String,Object> data = new HashMap<String,Object>();
//		CommResult result = new CommResult();
//		
//		//파람 널값 체크
//		if(param != null) {
////			param = UserStringUtils.unscriptMap(param); // 넘어온 데이터 XSS 방지
//			
//			data = (Map<String, Object>) param.get("dataInfo"); //복호화 해줄것*******************
//			result.setResultMap((Map<String, Object>) commService.deleteData(data));
//			
//			if(result != null) {
////				result = UserStringUtils.unscriptMap(result); // 결과값 XSS 방지
//			}
//			result.setResultCode(CommResult.RESULT_S);
//			result.setResultMsg(CommResult.RESULT_S_MSG);
//		} else {
//			result.setResultCode(CommResult.RESULT_W);
//			result.setResultMsg(CommResult.RESULT_W_MSG);
//		}
//		return result;
//	}
//}
