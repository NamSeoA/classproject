package com.aia.firstspring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aia.firstspring.Util.AES256Util;
import com.aia.firstspring.Util.Sha256;
import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.dao.MybatisMemberDao;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.service.MailSenderService;

@Service
public class MemberRegService {

//	@Autowired
//	private MemberDao dao;
	
//	@Autowired
//	private MybatisMemberDao dao;
	
	private MemberInterfaceDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private Sha256 sha256;
	
	@Autowired
	private AES256Util aes246Util;
	
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder;
	
//	@Autowired
//	private MailSenderService mailSenderService;
	
	public int insertMember(Member member) {
		int result = 0;
		try {
			dao = template.getMapper(MemberInterfaceDao.class);
			//result = dao.insertMember(member); // DB에 넣음. 회원 가입완료. 메일 전송
			result = 1;
			
			System.out.println("암호화 : "+sha256.encrypt(member.getPassword()));
			//8bb0cf6eb9b17d0f7d22b456f121257dc1254e1f01665370476383ea776df414
			
			// AES256으로 암호화 된 문자열 : DB에 insert / update 시 사용
			String epw = aes246Util.encrypt(member.getPassword()); // 암호화된 문자열 넣기
			// AES256으로 복구화 된 문자열 : select 시 사용
			String ppw = aes246Util.decrypt(epw);
			System.out.println("----------------------------");
			System.out.println("AES256으로 암호화 된 문자열 : "+ epw);
			System.out.println("AES256으로 복구화 된 문자열 : "+ ppw);
			
			System.out.println("----------------------------");
			System.out.println("Spring Security BCryptPasswordEncoder 이용한 암호화 ");
			String securityPw = cryptPasswordEncoder.encode(member.getPassword());
			System.out.println(securityPw); //$2a$10$tsTmwrY0KceUh6AowT8mDOxWgFJvnNMkAGlBR0Hdf2in5sBbv.GGu
			System.out.println("비밀번호 비교 메서드 : matches");
			System.out.println(cryptPasswordEncoder.matches("111", securityPw)); // false
			System.out.println(cryptPasswordEncoder.matches(member.getPassword(), securityPw)); // true
			
			
			String html = "<h1>아래 링크를 통해 인증해주세요."
					+ "<a href=\"http://localhost:8080/firstspring\"> 인증하기 </a></h1>";
			
			// 메일 전송
//			mailSenderService.mailSend(
//					member.getMemberid(), 
//					member.getMembername(), 
//					"[안내] 회원가입을 위한 계정 인증 안내", 
//					html);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return result;
		
	}

}