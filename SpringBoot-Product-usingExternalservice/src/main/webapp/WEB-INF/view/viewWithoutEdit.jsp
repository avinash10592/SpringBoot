<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Products List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>price</th>



		</tr>
		<c:forEach var="product" items="${list}">

			<tr>
				<td>${product.pId }</td>
				<td>${product.pName}</td>
				<td>${product.price}</td>




			</tr>
		</c:forEach>
	</table>

</body>
</html>