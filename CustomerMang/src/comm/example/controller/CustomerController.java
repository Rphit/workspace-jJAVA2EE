package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Customer;
import comm.example.service.CustomerService;
import comm.example.service.CustomerServiceImpl;

@WebServlet("/controller.do")
public class CustomerController extends HttpServlet {

	private CustomerService cService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		List<String> l = new ArrayList<String>();
		String name = req.getParameter("cName");
		String address = req.getParameter("cAddress");
		String item = req.getParameter("item");

		cService = new CustomerServiceImpl();

		Customer customer = new Customer(name, address, item);
		System.out.println("hi 1");
		cService.createCustomer(customer);
		req.setAttribute("E", customer);
		RequestDispatcher view = req.getRequestDispatcher("/success.jsp");
		view.forward(req, resp);

	}

}
