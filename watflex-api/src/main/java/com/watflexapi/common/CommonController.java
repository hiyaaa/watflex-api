package com.watflexapi.common;

import java.util.HashMap;
import java.util.List;

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
	
	@RequestMapping(path = "/registUser")
	public void userRegist(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("registUser param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.inserUser(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/loginCheck")
	public void loginCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("loginCheck param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = commonService.selectLoginCheck(param);
		
		resultMap.put("userInfo", userInfo);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("getUser param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = commonService.selectUser(String.valueOf(param.get("userId")));
		
		resultMap.put("userInfo", userInfo);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/updateUser")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("updateUser param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.updateUser(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/selectMovieReplyList")
	public void selectMovieReply(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("selectMovieReplyList param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> replyList = commonService.selectMovieReplyList(String.valueOf(param.get("movieCd")));
		
		resultMap.put("replyList", replyList);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/insertMovieReply")
	public void insertMovieReply(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("insertMovieReply param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.insertMovieReply(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/deleteMovieReply")
	public void deleteMovieReply(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("deleteMovieReply param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.deleteMovieReply(String.valueOf(param.get("replyNo")));
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/selectBrdList")
	public void selectBrd(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("selectBrdList param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> brdList = commonService.selectBrdList(param);
		
		resultMap.put("brdList", brdList);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/insertBrd")
	public void insertBrd(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("insertBrd param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.insertBrd(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/updateBrd")
	public void updateBrd(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("updateBrd param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.updateBrd(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/deleteBrd")
	public void deleteBrd(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("deleteBrd param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.deleteBrd(String.valueOf(param.get("brdNo")));
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/selectBrdReplyList")
	public void selectBrdReplyList(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("selectBrdReplyList param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> replyList = commonService.selectBrdReplyList(String.valueOf(param.get("brdNo")));
		
		resultMap.put("replyList", replyList);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/insertBrdReply")
	public void insertBrdReply(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("insertBrdReply param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.insertBrdReply(param);
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	@RequestMapping(path = "/deleteBrdReply")
	public void deleteBrdReply(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println("deleteBrdReply param - " + param);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Integer succ = commonService.deleteBrdReply(String.valueOf(param.get("replyNo")));
		
		resultMap.put("succ", succ);
		
		UtilEtc.responseJsonValue(response, resultMap);
	}
	
	///////////////////////////////////////////////////////////////////////////////  API
	
	@RequestMapping(path = "/getComCodeList")
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
	
	@RequestMapping(path = "/getDailyBoxOfficeList")
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
	
	@RequestMapping(path = "/getWeeklyBoxOffice")
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
	
	@RequestMapping(path = "/getMovieList")
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
	
	@RequestMapping(path = "/getMovieInfo")
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
