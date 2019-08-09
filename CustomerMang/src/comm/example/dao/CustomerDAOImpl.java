package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private Connection connection;
	private MyConnectionFactory myConnectionFactory;
	@Override
	
	
	
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("hi dao");
			PreparedStatement pStatement=connection.prepareStatement("insert into customer (cname,caddress,item) values(?,?,?)");
			System.out.println("hi after pst");
			
		pStatement.setString(1, customer.getcName());
			
			pStatement.setString(2, customer.getcAddress());
			pStatement.setString(3, customer.getItem());
			int i=pStatement.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public CustomerDAOImpl() {
		super();
		
		myConnectionFactory=MyConnectionFactory.getMyConnectionFactory();
		
		connection=myConnectionFactory.connection;
		
		
	}

}
