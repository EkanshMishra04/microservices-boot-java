package com.nagarro.AccountService.controller;

import java.util.List;

import com.nagarro.AccountService.model.Account;
import com.nagarro.AccountService.services.AccountServiceImpl;

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

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;

	@GetMapping("/")
	public List<Account> getAllAccounts() {
		return accountService.findAllAccounts();
	}

	@GetMapping("/{id}")
	public Object getAccountDetail(@PathVariable("id") Integer aid){
		return accountService.findAccountWithId(aid);
	}

	@PostMapping("/")
	public Account createNewAccount(@RequestBody Account account) {
		return accountService.saveThisAccount(account);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAccount(@PathVariable("id") Integer aid) {
		return accountService.deleteAccountWithAccountId(aid);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteAccountByUserid(@PathVariable("id") Integer cid) {
		accountService.deleteAccountWithCustomerId(cid);
	}

	@PutMapping("/addmoney/{id}")
	public ResponseEntity<Object> addMoney(@PathVariable("id") Integer aid, @RequestBody Long amount) {
		return accountService.addMoneyToThisAccountId(aid,amount);
	}

	@PutMapping("/withdraw/{id}")
	public ResponseEntity<Object> withdrawMoney(@PathVariable("id") Integer aid, @RequestBody Long amount) {
		return accountService.withdrawnMoneyToThisAccountId(aid, amount);
	}

}
