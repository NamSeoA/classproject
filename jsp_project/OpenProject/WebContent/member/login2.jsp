<%@page import="member.service.MemberLoginService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자 요청에 맞는 서비스 클래스의 인스턴스를 생성 -> 메서드 실행(사용자 요청처리하는 핵심로직 - MemberLoginService_memberLogin)
	// 사용자 요청에 맞는 View를 선택 , forward
	MemberLoginService service = MemberLoginService.getInstance();
	service.memberLogin(request, response);
	
	
%>
<jsp:forward page="loginView.jsp"/>
