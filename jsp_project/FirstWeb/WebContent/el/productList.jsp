<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 컨테이너가 beans를 자동 생성 -->
	<jsp:useBean id="product" class="test.Product" scope="session"/>
	<!--         = Product product = new Product()
	session.setAttribute("product", product) 자동 생성 -->
	
<%-- 	${sessionScope.product} --%>

	<form action="selectProdect.jsp" method="post">
		<select name="sel">
			<%
			for(String item: product.getProductList()){
				out.println("<option>"+item+"</option>");
			}
			%>
		
		</select>
	
		<input type="submit" value="선택">
	</form>

</body>
</html>