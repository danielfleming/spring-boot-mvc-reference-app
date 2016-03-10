package org.domain.services;

import org.domain.model.Customer;

public interface CustomerService {
	
	Iterable<Customer> listAllCustomers();

	Customer getCustomerById(Long id);

	Customer saveCustomer(Customer customer);

}
