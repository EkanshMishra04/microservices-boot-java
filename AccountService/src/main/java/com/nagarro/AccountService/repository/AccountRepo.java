package com.nagarro.AccountService.repository;

import java.util.List;

import com.nagarro.AccountService.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

	@Query("from Account a where a.cid=?1")
	public List<Account> findAccountsByCid(Integer cid);
}
