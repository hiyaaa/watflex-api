package com.watflexapi.common;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

	public HashMap<String, Object> selectUser(String userId) throws Exception;
	
}
