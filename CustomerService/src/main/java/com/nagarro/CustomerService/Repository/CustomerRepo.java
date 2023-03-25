package com.nagarro.CustomerService.Repository;

import com.nagarro.CustomerService.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
