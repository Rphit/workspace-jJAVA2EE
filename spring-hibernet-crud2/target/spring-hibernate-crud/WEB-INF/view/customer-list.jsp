<%@page import="comm.example.springdemo.entity.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table  id="table-1" >
		<%-- 
		<tbody>
			<tr>
				<td>First name</td>
				<td>Last name</td>
				<td>Email</td>
			</tr>
			
			<c:forEach var="customer" items="${customerList}">
			<tr>
			<td>{customer.firstName}</td>
			<td>{customer.lastName}</td>
			<td>{customer.email}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table> --%>
	
	<% 
		List<Customer> list=request.getListAttribute("customerList");
	
	
	%>
	
	

</body>
</html>