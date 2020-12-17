<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Enumeration<String> attrNames = application.getAttributeNames();  //속성의 이름 목록을 구한다.
		
		while(attrNames.hasMoreElements()){
			String attrName = attrNames.nextElement();
			Object value = application.getAttribute("name");
			
			out.println( attrName+"=" +value.toString()+"<br>");
		}

%>

</body>
</html>