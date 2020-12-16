<%@page import="form.RegData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	RegData regData = new RegData();

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String username = request.getParameter("username");
	Object userPhoto = request.getParameter("userPhoto");
	
	regData.setId(id);
	regData.setPw(pw);
	regData.setUsername(username);
	regData.setUserPhoto(userPhoto);
	
	request.setAttribute("data", regData);


%>

<jsp:forward page = "regView.jsp" />
    