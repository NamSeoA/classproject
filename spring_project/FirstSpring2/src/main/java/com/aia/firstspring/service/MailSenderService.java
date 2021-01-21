package com.aia.firstspring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean simpleMailSend() {

		boolean result = true;
		
		SimpleMailMessage message = new SimpleMailMessage();
		//SimpleMailMessage message = new SimpleMailMessage(templateMessage);
		message.setTo("tjdkzz97@naver.com");
		message.setSubject("테스트 이메일 발송합니다."); //주제
		message.setText("내용입니다.");
		
		try {
			mailSender.send(message);
		}catch (MailException e) {
			result = false;
		}
		return result;
	}

	public boolean mailSend(String toEmailAddress) { // 어디로 보낼 건지
		
		boolean result = true;
		
		MimeMessage message = mailSender.createMimeMessage(); //minemessage 객체 얻을 수 있음
		
		try {
			// 메일 제목
			message.setSubject("[안내] 회원가입을 축하합니다.", "utf-8");
			// 메일 내용에 적용할 html의 내용
			String htmlStr = "<h1 style=\"color:red;\">회원 가입을 축하합니다.</h1>"; // html로 만든 문자열
			// 메일 내용
			message.setText("htmlStr", "utf-8", "html"); 
			// 보내는 사람의 이메일 : gmail을 사용하는 경우에는 인증된메일로 적용이 된다. 
			message.setFrom(new InternetAddress("tjdkzz97@naver.com")); 
			// 받는 사람의 이메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, "남서아 고객님", "utf-8"));
			// 메일 전송
			mailSender.send(message);
		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}

	/*
	param@ toEmailAddress : 받는 사람의 이메일
	param@ name : 받는 사람의 이름
	param@ subject : 메일의 제목
	param@ text : 메일 내용 
	*/
	public boolean mailSend(String toEmailAddress, String name, String subject, String text) {
		boolean result = true;
		MimeMessage message = mailSender.createMimeMessage(); //minemessage 객체 얻을 수 있음
		try {
			// 메일 제목
			message.setSubject(subject, "utf-8");
			// 메일 내용에 적용할 html의 내용
			// String htmlStr = "<h1 style=\"color:red;\">회원 가입을 축하합니다.</h1>"; // html로 만든 문자열
			// 메일 내용
			message.setText(text, "utf-8", "html"); 
			// 보내는 사람의 이메일 : gmail을 사용하는 경우에는 인증된메일로 적용이 된다. 
			message.setFrom(new InternetAddress("aiaseao@gmail.com")); 
			// 메일 전송
			mailSender.send(message);
			// 받는 사람의 이메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, name+"고객님", "utf-8"));

		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

}
