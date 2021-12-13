package com.watflexapi.common;

import java.util.HashMap;
import java.util.List;

public interface CommonService {
	
	public Integer inserUser(HashMap<String, Object> param) throws Exception;
	
	public HashMap<String, Object> selectLoginCheck(HashMap<String, Object> param) throws Exception;
	
	public HashMap<String, Object> selectUser(String userNo) throws Exception;
	
	public List<HashMap<String, Object>> selectMovieReplyList(String movieCd) throws Exception;
	
	public Integer insertMovieReply(HashMap<String, Object> param) throws Exception;
	
	public Integer deleteMovieReply(String replyNo) throws Exception;
	
	public List<HashMap<String, Object>> selectBrdList(HashMap<String, Object> param) throws Exception;
	
	public Integer insertBrd(HashMap<String, Object> param) throws Exception;
	
	public Integer updateBrd(HashMap<String, Object> param) throws Exception;
	
	public Integer deleteBrd(String brdNo) throws Exception;
	
	public List<HashMap<String, Object>> selectBrdReplyList(String brdNo) throws Exception;
	
	public Integer insertBrdReply(HashMap<String, Object> param) throws Exception;
	
	public Integer deleteBrdReply(String replyNo) throws Exception;
	
}
