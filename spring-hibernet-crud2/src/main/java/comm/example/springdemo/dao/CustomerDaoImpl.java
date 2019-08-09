package comm.example.springdemo.dao;



import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comm.example.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		
	 Query<Customer>query = session.createQuery("from Customer",Customer.class);
		List<Customer> customers =query.getResultList();
		
		return customers;
	}
	}


