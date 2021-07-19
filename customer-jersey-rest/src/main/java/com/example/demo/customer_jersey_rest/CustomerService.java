package com.example.demo.customer_jersey_rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

	private List<Customer> custList;
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub

		custList = new ArrayList<Customer>();
		init();
	}
	
	private void init() {
		this.custList.add(new Customer(101,"Suresh", 2884));
		this.custList.add(new Customer(102,"Ramesh", 3994));
	}
	
	public boolean add(Customer cust) {
		return this.custList.add(cust);
	}
	
	public Customer getCustomerById(int id) {
		
		Customer cust=null;
		Optional<Customer> resp=
				this.custList.stream().filter(c -> c.getCustomerId()==id).findFirst();
		
		if(resp.isPresent()) {
			cust = resp.get();
		}else {
			throw new RuntimeException("Element Not found");
		}
		return cust;
	}
	
	public List<Customer> getAllCustomers(){
		return this.custList;
	}

	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
		

	
}
