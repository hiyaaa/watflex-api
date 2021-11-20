package com.watflexapi.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.watflexapi.util.UtilEtc;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

@RequestMapping("/dashBoard")
@Controller
public class CommonController {

	@Autowired
	CommonService commonService;
	
	@RequestMapping(path = "/getDailyBoxOffice")
	public void getDailyBoxOffice(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println(param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		String apiKey = "5b33409868cb7a565f875e013c4120da";
		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);
		
		String daily = apiService.getDailyBoxOffice(true, "20211119", "1", "", "", "");
		//String comCode = apiService.getComCodeList(true, "2201");
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> dailyResult = mapper.readValue(daily, HashMap.class);
		//HashMap<String, Object> comCodeResult = mapper.readValue(comCode, HashMap.class);
		
		resultMap.put("daily", dailyResult);
		//resultMap.put("comCode", comCodeResult);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println(param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = commonService.selectUser(String.valueOf(param.get("userId")));
		
		resultMap.put("userInfo", userInfo);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
}
