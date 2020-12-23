<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<ul><!--			 /op --> 
		<li> <a href=" <c:url value="/" />">Home</a> </li>
		<!--																						 절대경로 -->
		<li> <a href=" <c:url value="/member/memberRegForm.jsp" />">회원가입</a> </li>
		<li> 
		
		<%
			if(session.getAttribute("loginInfo")==null){
		
		%>
			<a href="<c:url value="/member/loginForm.jsp" />">LOGIN</a> 
		<%
			}else {
		%>
			<a href=" <c:url value="/member/logout.jsp" />">LOGOUT</a> 
		<%
			} 
		%>
		</li>
		<li> <a href="<c:url value="/member/mypage/mypage1.jsp" />">Mypage1</a> </li>
		<li> <a href=" <c:url value="/member/mypage/mypage2.jsp" />">Mypage2</a> </li>
		<li> <a href="#">Home</a> </li>
	</ul>
</nav>