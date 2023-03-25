package com.nagarro.CustomerService.servicesImpl;

import java.util.List;

import com.nagarro.CustomerService.Repository.CustomerRepo;
import com.nagarro.CustomerService.dto.AccountDto;
import com.nagarro.CustomerService.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;

	public Customer addThisCustomer(Customer customer) {
		Customer dummy = repo.save(customer);
		AccountDto account = new AccountDto(dummy.getCid(), 1000l);

		ResponseEntity<AccountDto> demo = restTemplate.postForEntity("http://ACCOUNT-SERVICE/account/", account,
				AccountDto.class);
		dummy.setAid(demo.getBody().getAid());
		return repo.save(dummy);
		
	}

	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}

	public Customer getCustomerByCustId(Integer cid) {
		return repo.findById(cid).orElse(null);
	}

	public Customer updateIfUserExists(Customer user) {
		Customer checkedUser = repo.findById(user.getCid()).orElse(null);
		if (checkedUser != null) {
			user.setAid(checkedUser.getAid());
			return repo.save(user);
		}
		return null;
	}

	public Customer deleteCustomer(Integer cid) {
		Customer user = repo.findById(cid).orElse(null);
		if (user != null) {
			restTemplate.delete("http://ACCOUNT-SERVICE/account/customer/"+cid);
			repo.delete(user);
			return user;
		}
		return null;
	}
	
	

}
