<%@page import="form.RegData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	RegData data = (RegData) request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>

<body>
    <h1>회원 가입</h1>
    <hr>
        <table>
            <tr>
                <td>아이디(email)</td>
                <td>
                    <%= data.getId()  %>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <%= data.getPw() %>
                </td>
                </tr>
            <tr>
                <td>이름</td>
                <td>
                    <%= data.getUsername() %>
                </td>
            </tr>
            <tr>
                <td>사진</td>
                <td>
                    <%= data.getUserPhoto() %>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
    
</body>
</html>