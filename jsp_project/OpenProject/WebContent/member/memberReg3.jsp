<%@page import="member.service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	//패턴 : fom.jsp -> controller.jsp -> service -> dao -> service -> controller.jsp -> view.jsp
	// memberReg3.jsp 역할 (like controller)
	// 사용자의 요청에 맞는  service class를 선택 - 기준 :  -> 메서드 실행
	// View 페이지를 선택 -> forward

	
	// MemberRegService 필요
	// insertMember(HttpServletRequset request) -> int i or 0  
	
	MemberRegService service = MemberRegService.getInstance();
	
	service.insertMember(request);
	
%>
		<jsp:forward page="memberRegView.jsp" />


