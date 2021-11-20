package com.watflexapi.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class CommonController {

	@RequestMapping(path = "/SibalGut")
	public String LoginChk(HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws Exception{
		System.out.println(param);
		return "¾¾¹ß123455555123";
	}
}
