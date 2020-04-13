package com.example.JDBCTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.example.JDBCTemplate.bean.Account;
import com.example.JDBCTemplate.bean.AccountType;
import com.example.JDBCTemplate.service.AccountService;
import com.example.JDBCTemplate.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AccountService service=context.getBean("accountServiceImpl",AccountServiceImpl.class);
		Account account=context.getBean("account",Account.class);
		
//		String str[]=UUID.randomUUID().toString().split("-");
//		account.setAccountNumber(str[0]);
//		account.setAccountType(AccountType.CREDIT_CARD);
//		account.setInitialBalance(100000);
//	
//		account=service.createAccount(account);
//		System.out.println(account);
		
//		  List<Account> list=service.getAllAccountDetails();
//		  Iterator<Account> i=list.iterator(); 
//		  while(i.hasNext()) 
//		  { 
//			  Account account2=i.next();
//			  System.out.println(account2);
//		  }
		
		account=service.findByAccountNumber("12417732");
		System.out.println(account);
		
    }
}
