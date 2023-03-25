package com.nagarro.AccountService.services;

import java.util.List;

import com.nagarro.AccountService.customExceptions.RequestedResourceNotFoundException;
import com.nagarro.AccountService.dto.CustomerDto;
import com.nagarro.AccountService.model.Account;
import com.nagarro.AccountService.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountServiceImpl {

	@Autowired
	private AccountRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${error.accountNotFound}")
	private String accountErrorMsg;

	@Value("${error.customerNotFound}")
	private String customerErrorMsg;

	public Account saveThisAccount(Account account) {
		return repo.save(account);
	}

	public Account deleteAccount(Account account) {
		return null;
	}

	public ResponseEntity<Object> findAccountWithId(Integer aid) {
		try {
			Account account = repo.findById(aid)
					.orElseThrow(() -> new RequestedResourceNotFoundException("Account Not Found!!"));
			if (account.getCid() != null) {
				ResponseEntity<CustomerDto> dummy = restTemplate.getForEntity("http://CUSTOMER-SERVICE/customer/{id}",
						CustomerDto.class, account.getCid());
				account.setCustomerDetail(dummy.getBody());
				return ResponseEntity.ok(account);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerErrorMsg);

		} catch (RequestedResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountErrorMsg);
		}
	}

	public List<Account> findAllAccounts() {
		return repo.findAll();
	}

	public ResponseEntity<Object> deleteAccountWithAccountId(Integer aid) {
		Account account = repo.findById(aid).orElse(null);
		if (account != null) {
			repo.delete(account);
			return ResponseEntity.ok(account);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountErrorMsg);
	}

	public void deleteAccountWithCustomerId(Integer cid) {
		List<Account> accountsByThisUser = repo.findAccountsByCid(cid);
		for (Account a : accountsByThisUser) {
			repo.delete(a);
		}

	}

	public ResponseEntity<Object> addMoneyToThisAccountId(Integer aid, Long amount) {
		try {
			Account account = repo.findById(aid)
					.orElseThrow(() -> new RequestedResourceNotFoundException(accountErrorMsg));
			account.setBalance(account.getBalance() + amount);
			repo.save(account);
			return ResponseEntity.ok(account);
		} catch (RequestedResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountErrorMsg);
		}
	}

	public ResponseEntity<Object> withdrawnMoneyToThisAccountId(Integer aid, Long amount) {
		try {
			Account account = repo.findById(aid)
					.orElseThrow(() -> new RequestedResourceNotFoundException(accountErrorMsg));
			if (account.getBalance() >= amount) {
				account.setBalance(account.getBalance() - amount);
				repo.save(account);
				return ResponseEntity.ok(account);
			}
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Balance is Less than withdrawl money");
		} catch (RequestedResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountErrorMsg);
		}
	}
}
