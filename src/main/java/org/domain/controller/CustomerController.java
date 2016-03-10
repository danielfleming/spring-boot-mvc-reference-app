package org.domain.controller;

import org.domain.model.Customer;
import org.domain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired private CustomerService customerService;
	private static final String CUSTOMER_LIST = "customers/list";
	private static final String CUSTOMER_NEW = "customers/new";
	private static final String CUSTOMER_EDIT = "customers/edit";

	@RequestMapping(value = "")
	public String greetingList(Model model) {		
		model.addAttribute("customers", customerService.listAllCustomers());
		return CUSTOMER_LIST;
	}	
	
	@RequestMapping(value = "/cancel")
	public String cancelGreeting(Model model) {
		model.addAttribute("customers", customerService.listAllCustomers());
		return CUSTOMER_LIST;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newGreeting(Model model) {	
		model.addAttribute("customer", new Customer());
		return CUSTOMER_NEW;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editGreeting(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return CUSTOMER_EDIT;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String process(@ModelAttribute Customer customer, Model model) {		
		customerService.saveCustomer(customer);	
		model.addAttribute("customers", customerService.listAllCustomers());
		return "redirect:/customers"; 
	}

}
