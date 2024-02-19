package com.saendino.demo.cmm.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.HandlerMapping;

/**
 * @Class Name : CommController.java
 * @Description : 공통 서비스를 처리하는 컨트롤러
 * @Modification Information
 * 
 * 	수정일			수정자		수정내용
 * 	----------		-------		-------------------
 * 	2024.02.06.		홍선진		최초작성
 *
 * @author 홍선진
 * @since 2024.02.06.
 * @version 1
 * @see
 *
 */
@Controller
public class CommController {
	
	//공통 페이지 반환
	@GetMapping("/demo/{program}/{url}")
	public String returnPage(HttpServletRequest request, @PathVariable("program") String program, @PathVariable("url") String url) {
		// 요청 URL이 "http://localhost/first-path"면 얻는 값은 "first-path"
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		path = path.replace("/demo", "");
		path = path.replace(".do", "");
		path = "pages" + path;
		return path;
	}
}

//String[] pageNm = url.split("\\.");
//
//if(pageNm != null && pageNm.length == 2) {
//	String page = "pages/" + program + "/" + pageNm[0];
//	return page;
//} else {
//	return "pages/main/main";
//}