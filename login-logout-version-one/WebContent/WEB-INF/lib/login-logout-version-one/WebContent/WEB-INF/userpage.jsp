<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	Object o=session.getAttribute("SES");
	out.println("Hello: "+o.toString()+"<br/>");
	out.println(session.isNew()
	
			);
	
%>
<a href="another_page.jsp">another page</a>

</body>
</html>