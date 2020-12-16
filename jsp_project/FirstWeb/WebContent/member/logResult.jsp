<%@page import="form.LoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LoginData loginData = new LoginData();

	// 데이터를 받아온다.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// beans에 데이터 저장
	loginData.setId(id); //id 저장
	loginData.setPw(pw); //pw 저장
	
	
	// view.js로 beans 객체 전달
	request.setAttribute("data", loginData);
	
%>

<jsp:forward page="logView.jsp"/>