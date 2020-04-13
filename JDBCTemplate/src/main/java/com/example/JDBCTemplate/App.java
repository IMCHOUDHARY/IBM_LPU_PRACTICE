package com.example.JDBCTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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
		
		//account=service.findByAccountNumber("12417732");
		//System.out.println(account);
		
		Scanner sc = new Scanner(System.in);
		int ch=0;
		while(ch!=5)
		{
			System.out.println("1. Insert a data");
			System.out.println("2. Display All Accounts");
			System.out.println("3. Find Account By Account Number");
			System.out.println("4. Delete Account By Account Number");
			System.out.println("5. Update Account By Account Number");
			
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
			{
				String str[]=UUID.randomUUID().toString().split("-");
				account.setAccountNumber(str[0]);
				account.setAccountType(AccountType.CREDIT_CARD);
				System.out.println("ENTER THE BALANCE:");
				int bal = sc.nextInt();
				account.setInitialBalance(bal);
			}
			break;
			
			case 2:
			{
				List<Account> list=service.getAllAccountDetails();
				Iterator<Account> i=list.iterator(); 
				  while(i.hasNext()) 
				  { 
					  Account account2=i.next();
					  System.out.println(account2);
				  }
			}
			break;
			
			case 3:
			{
				System.out.println("ENTER THE ACCOUNT NUMBER YOU WANT TO SEARCH:");
				String acc_no = sc.next();
				account=service.findByAccountNumber(acc_no);
				System.out.println(account);
			}
			break;
			
			case 4:
			{
				System.out.println("ENTER THE ACCOUNT NUMBER YOU WANT TO DELETE:");
				String acc_no = sc.next();
				service.deleteById(acc_no);
			}
			break;
			
			case 5:
			{
				System.out.println("ENTER THE ACCOUNT NUMBER YOU WANT TO UPDATE:");
				String acc_no = sc.next();
				service.updateById(acc_no);
			}
			break;
			
			case 6:
			{
				System.out.println("DELETING ALL RECORDS......");
				service.deleteAll();
			}
			}
		}
    }
}
