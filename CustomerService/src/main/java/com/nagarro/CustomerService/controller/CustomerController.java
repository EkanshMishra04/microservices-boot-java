package com.nagarro.CustomerService.controller;

import java.util.List;

import com.nagarro.CustomerService.Repository.CustomerRepo;
import com.nagarro.CustomerService.dto.AccountDto;
import com.nagarro.CustomerService.model.Customer;
import com.nagarro.CustomerService.servicesImpl.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addThisCustomer(customer);
	}

	@GetMapping("/")
	public List<Customer> getAllCustomer() {
		return customerService.findAllCustomers();

	}

	@GetMapping("/{id}")
	public Customer getSingleCustomer(@PathVariable("id") Integer cid) {
		return customerService.getCustomerByCustId(cid);
	}

	@PutMapping("/")
	public Customer updateThisUser(@RequestBody Customer user) {
		return customerService.updateIfUserExists(user);
	}

	@DeleteMapping("/{id}")
	public Customer deleteThisCustomer(@PathVariable("id") Integer cid) {
		return customerService.deleteCustomer(cid);
	}
}
