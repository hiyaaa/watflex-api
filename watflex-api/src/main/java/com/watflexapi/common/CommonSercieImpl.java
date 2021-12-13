package com.watflexapi.common;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonSercieImpl implements CommonService {

	@Autowired
	CommonMapper commonMapper;
	
	public Integer inserUser(HashMap<String, Object> param) throws Exception{
		return commonMapper.insertUser(param);
	}
	
	public HashMap<String, Object> selectLoginCheck(HashMap<String, Object> param) throws Exception{
		return commonMapper.selectLoginCheck(param);
	}
	
	public HashMap<String, Object> selectUser(String userNo) throws Exception{
		return commonMapper.selectUser(userNo);
	}
	
	public List<HashMap<String, Object>> selectMovieReplyList(String movieCd) throws Exception{
		return commonMapper.selectMovieReplyList(movieCd);
	}
	
	public Integer insertMovieReply(HashMap<String, Object> param) throws Exception{
		return commonMapper.insertMovieReply(param);
	}
	
	public Integer deleteMovieReply(String replyNo) throws Exception{
		return commonMapper.deleteMovieReply(replyNo);
	}
	
	public List<HashMap<String, Object>> selectBrdList(HashMap<String, Object> param) throws Exception{
		return commonMapper.selectBrdList(param);
	}
	
	public Integer insertBrd(HashMap<String, Object> param) throws Exception{
		return commonMapper.insertBrd(param);
	}
	
	public Integer updateBrd(HashMap<String, Object> param) throws Exception{
		return commonMapper.updateBrd(param);
	}
	
	public Integer deleteBrd(String brdNo) throws Exception{
		return commonMapper.deleteBrd(brdNo);
	}
	
	public List<HashMap<String, Object>> selectBrdReplyList(String brdNo) throws Exception{
		return commonMapper.selectBrdReplyList(brdNo);
	}
	
	public Integer insertBrdReply(HashMap<String, Object> param) throws Exception{
		return commonMapper.insertBrdReply(param);
	}
	
	public Integer deleteBrdReply(String replyNo) throws Exception{
		return commonMapper.deleteBrdReply(replyNo);
	}
	
}
