package com.aia.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {

	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		return "simple/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody // 반환하는 문자열 그대로 응답
	public String simple(@RequestBody String body) {
		System.out.println(body + "@ResponseBody 어노테이션은 일반 객체도 그대로 반환이 됩니다."); // uname=cool&age=20
		return body + "@ResponseBody 어노테이션은 일반 객체도 그대로 반환이 됩니다.";
	}
	
	
}
