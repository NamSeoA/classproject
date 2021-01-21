package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

	@Autowired
	private JavaMailSender mailSender;
	
	private SimpleMailMessage templateMessage;
	
	@RequestMapping("/simplemail") //  contextpath/mail/simplemail
	public void simpleMailSend() { // void 반환 처리 시 자동으로 경로를 찾음 (view도 mail안에 simplemail.jsp를 찾음)   
		
		//SimpleMailMessage message = new SimpleMailMessage();
		SimpleMailMessage message = new SimpleMailMessage(templateMessage);
		message.setTo("tjdkzz97@naver.com");
		//message.setSubject("테스트 이메일 발송합니다."); //주제
		//message.setText("내용입니다.");
		
		mailSender.send(message);
		
		// return "mail/simplemail";
	}
}
