package com.watflexapi.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crolling {
	
	public static HashMap<String, Object> getMovieInfo(String movieCode) {

		String url = "https://www.kobis.or.kr/kobis/business/mast/mvie/searchMovieDtl.do?code=" + movieCode;
			
		HashMap<String, Object> resultMap = new HashMap<>();
		
	    Connection conn = Jsoup.connect(url);

	    try {
	      Document document = conn.get();
	      
	      resultMap.put("poster", "https://kobis.or.kr" + document.select(".cont_tab .item_tab img").get(0).attr("src"));
	      resultMap.put("desc", document.select("p.desc_info").get(0).ownText());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return resultMap;
	}

}
