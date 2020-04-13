package com.example.JDBCTemplate.Repo;

import java.util.List;
import java.util.Scanner;
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

	
	public void deleteById(String accountNumber) {
		// TODO Auto-generated method stub
		 String str="delete from account where accountNumber='"+accountNumber+"'";
		 jdbcTemplate.update(str);
		 System.out.println("account deleted successfully with id: "+accountNumber);
	}



	public void updateById(String accountNumber)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER BALANCE:");
		int bal = sc.nextInt();
		String str = "update from account set balance=" + bal + "where accountNumber='"+accountNumber+"'";
		jdbcTemplate.update(str);
	}



	public void deleteAll() {
		String str = "delete from account";
		jdbcTemplate.update(str);
	}
}
