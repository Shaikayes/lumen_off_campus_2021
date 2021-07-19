package com.example.demo.customer_jersey_rest;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerResource {
	
	CustomerService service = new CustomerService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerById(@PathParam("id") int id) {
		return service.getCustomerById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer cust) {
		boolean isAdded = this.service.add(cust);
		
		if(isAdded) {
			return Response.status(201).entity(cust).build();
		}else {
			throw new RuntimeException("Not Added");
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Customer updateCustomer(@PathParam("id")int id ,Customer customer)
	{
		customer.setId(id);
		return service.update(customer);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String removeStudent(@PathParam("id") int id)
	{
	return service.delete(id);

	}
	
	
	
	

}
