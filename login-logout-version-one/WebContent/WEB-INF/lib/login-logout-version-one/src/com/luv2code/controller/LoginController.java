package com.luv2code.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processesRequest(request, response);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processesRequest(request, response);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getMyConnection() throws SQLException, NamingException
	{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/ibm");
		return ds.getConnection();
		
	}
	
	
	
	protected void processesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		connection=getMyConnection();
		PreparedStatement pst=connection.prepareStatement("select name,password,usertype from userdetail where name=? AND password=? AND usertype=? ");
		pst.setString(1, request.getParameter("uName").trim());
		pst.setString(2, request.getParameter("uPass"));
		pst.setString(3, request.getParameter("uType").trim());
		
		ResultSet rs=pst.executeQuery();
		int item=0;
		while(rs.next())
		{
			item++;
		}
		
		if(item>0)
		{
			HttpSession session=request.getSession();
			
			session.setAttribute("SES",request.getParameter("uName") );
			session.setMaxInactiveInterval(10);
			RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/userpage.jsp");
			view.forward(request, response);
		
		}
		else
		{
			out.println("<font color='red'>user id/password is incorrect!</font><br/>");
			RequestDispatcher view=request.getRequestDispatcher("home.jsp");
			view.include(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
