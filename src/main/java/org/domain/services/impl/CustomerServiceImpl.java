package org.domain.services.impl;

import org.domain.model.Customer;
import org.domain.repositories.CustomerRepository;
import org.domain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired private CustomerRepository customerRepository;
	
	@Override
    public Iterable<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
