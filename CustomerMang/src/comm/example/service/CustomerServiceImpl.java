package comm.example.service;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cDao;

	public CustomerServiceImpl() {
		super();

		cDao = new CustomerDAOImpl();
	}

	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			System.out.println("hi service");
		cDao.createCustomer(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
