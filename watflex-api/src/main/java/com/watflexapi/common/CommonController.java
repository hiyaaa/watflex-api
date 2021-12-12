package com.watflexapi.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.watflexapi.util.Crolling;
import com.watflexapi.util.UtilEtc;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

@RequestMapping("/comm")
@Controller
public class CommonController {

	@Autowired
	CommonService commonService;
	
	@Value("${api.key}")
    private String apiKey;
	
	@RequestMapping(path = "/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println(param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = commonService.selectUser(String.valueOf(param.get("userId")));
		
		resultMap.put("userInfo", userInfo);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getComCodeList") //공통코드
	public void getComCodeList(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getComCodeList param - " + param);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);		
		String comCode = apiService.getComCodeList(true, String.valueOf(param.get("comCode")));
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> comCodeResult = mapper.readValue(comCode, HashMap.class);
		
		resultMap.put("comCode", comCodeResult);

		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getDailyBoxOfficeList") //일별 박스오피스
	public void getDailyBoxOffice(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getDailyBoxOfficeList param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);
		String daily = apiService.getDailyBoxOffice(true, param);
		
		//ObjectMapper mapper = new ObjectMapper();
		//HashMap<String, Object> dailyResult = mapper.readValue(daily, HashMap.class);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj1 = (JSONObject) parser.parse(daily);
		JSONObject jsonObj2 = (JSONObject) jsonObj1.get("boxOfficeResult");
		JSONArray jsonArray = (JSONArray) jsonObj2.get("dailyBoxOfficeList");
		for(int i=0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArray.get(i);
			jsonObj.put("movieSubInfo", Crolling.getMovieInfo(jsonObj.get("movieCd").toString()));
		}
		
		resultMap.put("daily", jsonArray);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getWeeklyBoxOffice") //주간/주말 박스오피스
	public void getWeeklyBoxOffice(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getWeeklyBoxOffice param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);
		String weekly = apiService.getWeeklyBoxOffice(true, param);
		
		//ObjectMapper mapper = new ObjectMapper();
		//HashMap<String, Object> weeklyResult = mapper.readValue(weekly, HashMap.class);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj1 = (JSONObject) parser.parse(weekly);
		JSONObject jsonObj2 = (JSONObject) jsonObj1.get("boxOfficeResult");
		JSONArray jsonArray = (JSONArray) jsonObj2.get("weeklyBoxOfficeList");
		for(int i=0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArray.get(i);
			jsonObj.put("movieSubInfo", Crolling.getMovieInfo(jsonObj.get("movieCd").toString()));
		}
		
		resultMap.put("weekly", jsonArray);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getMovieList") //영화목록
	public void getMovieList(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getMovieList param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);
		String movie = apiService.getMovieList(true, param);
		
		//ObjectMapper mapper = new ObjectMapper();
		//HashMap<String, Object> movieResult = mapper.readValue(movie, HashMap.class);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj1 = (JSONObject) parser.parse(movie);
		JSONObject jsonObj2 = (JSONObject) jsonObj1.get("movieListResult");
		JSONArray jsonArray = (JSONArray) jsonObj2.get("movieList");
		for(int i=0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArray.get(i);
			jsonObj.put("movieSubInfo", Crolling.getMovieInfo(jsonObj.get("movieCd").toString()));
		}

		resultMap.put("movie", jsonArray);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getMovieInfo") //영화상세
	public void getMovieInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getMovieInfo param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		KobisOpenAPIRestService apiService = new KobisOpenAPIRestService(apiKey);
		String movieInfo = apiService.getMovieInfo(true, param);
		
		//ObjectMapper mapper = new ObjectMapper();
		//JSONObject movieInfoResult = mapper.readValue(movieInfo, JSONObject.class);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj1 = (JSONObject) parser.parse(movieInfo);
		JSONObject jsonObj2 = (JSONObject) jsonObj1.get("movieInfoResult");
		JSONObject jsonResult = (JSONObject) jsonObj2.get("movieInfo");

		jsonResult.put("movieSubInfo", Crolling.getMovieInfo(jsonResult.get("movieCd").toString()));

		resultMap.put("movieInfo", jsonResult);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
}
