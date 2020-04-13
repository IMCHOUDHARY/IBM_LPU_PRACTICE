package com.example.JDBCTemplate.Repo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.JDBCTemplate.bean.Account;
import com.example.JDBCTemplate.bean.AccountRowMapper;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO{
	
	private JdbcTemplate jdbcTemplate;
	private Logger logger=Logger.getLogger("AccountDAOImpl");
	@Autowired
	public AccountDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}



	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		String query="insert into account(accountNumber,accountType,balance) values('"
				+account.getAccountNumber()+"','"
				+account.getAccountType()+"',"+account.getInitialBalance()+")";
		
		jdbcTemplate.update(query);
		
		return account;
	}



	public List<Account> getAllAccountDetails() {
		List<Account> accounts=jdbcTemplate.query("select * from account", new AccountRowMapper());
		return accounts;
	}
	
	public Account findByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from account where accountNumber=?", new Object[] {accountNumber},new AccountRowMapper());
	}

}
