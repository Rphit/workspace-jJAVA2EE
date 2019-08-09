<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.crypto.provider.RSACipher"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%!

	List<String> l=null;
%>
<%
try
{
	Context ctx=new InitialContext();
	javax.sql.DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/ibm");
	Connection connection=ds.getConnection();
	Statement st=connection.createStatement();
	ResultSet rs=st.executeQuery("select usertype from userdetail ");
	l=new ArrayList<String>();
	while(rs.next())
	{
		l.add(rs.getString("usertype"));
	}
}
catch(Exception e)
{
	e.printStackTrace();
}


%>
</head>
<body>
	<form id="form-1" action="loginController.do" method="post">
		<label id="label-1">User Name:</label>
		<input id="input-1" name="uName" placeholder="user name" autofocus="true" required="true" type="text"/><br/>
		<label for="input-2">User Password</label>
		<input id="input-2" placeholder="password" required="true" type="password" name="uPass"/><br/>
		<label id="label-3">User Type</label>
		<select name="uType">
		<option value="UNKNOWN">Select....</option>
		<%
			for(String str:l)
			{%>
				
				<option value=<%=str %>><%=str %></option>
				
				
			<% }%>
		
		
		
		</select><br/>
		<input type="submit" value="Log Me In!" id="button-1"/>
		<input type="reset" value="Cancel" id="button-2"/>
	</form>
</body>
</html>