package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.service.MailSenderService;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

	@Autowired
	MailSenderService mailSenderService;
	
//	@Autowired
//	private JavaMailSender mailSender;
	
//	@Autowired
//	private SimpleMailMessage templateMessage;
	
	@RequestMapping("/simplemail") //  contextpath/mail/simplemail
	public void simpleMailSend() { // void 반환 처리 시 자동으로 경로를 찾음 (view도 mail안에 simplemail.jsp를 찾음)   
		
		
		//mailSenderService.simpleMailSend();
		mailSenderService.mailSend("tjdkzz97@naver.com");
		
		// return "mail/simplemail";
	}
}