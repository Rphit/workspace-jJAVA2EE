<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
     <jsp:useBean id="pBean" scope="request"  class="comm.examplemodel.Player" > </jsp:useBean>
      <jsp:setProperty property="*" name="pBean"/>
      <jsp:getProperty property="playerName" name="pBean"/>
      <jsp:getProperty property="teamName" name="pBean"/>
      <jsp:getProperty property="playerCountry" name="pBean"/>
      

     
</body>
</html>