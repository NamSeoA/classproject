<%@page import="form.LoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    LoginData data = (LoginData) request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
    <h1>회원 로그인 </h1>
    <hr>
        <table>
            <tr>
                <td>아이디</td>
                <td>
                    <%= data.getId() %>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <%= data.getPw() %>
                </td>
            </tr>
        </table>
    </form>

</body>

</html>