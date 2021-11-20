package com.watflexapi.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilEtc {

	/**
     * JSON (String)을 문자열로 변환하여 클라이언트에 전송.
     * AJax 용. 
     */
    public static void responseJsonValue(HttpServletResponse response, Object value) {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            response.getWriter().print( mapper.writeValueAsString(value));
        } catch (IOException ex) {
            System.out.println("responseJsonValue");
        }        
    }
}
