<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="E" class="comm.example.model.Customer"></jsp:useBean>
<jsp:getProperty property="cName" name="E"/>
<p>success full inserted </p>>
</body>
</html>