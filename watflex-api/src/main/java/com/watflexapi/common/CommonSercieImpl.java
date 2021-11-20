package com.watflexapi.common;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonSercieImpl implements CommonService {

	@Autowired
	CommonMapper commonMapper;
	
	public HashMap<String, Object> selectUser(String userId) throws Exception{
		return commonMapper.selectUser(userId);
	}
	
}
