package com.cg.pl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsuffecientFundException;
import com.cg.service.AccountService;
import com.cg.service.Validator;

import sun.print.resources.serviceui;

class ValidateusingJunit  {

	AccountService as= new AccountService();

	/*static AccountService as;
	@BeforeAll       //junit4 @BeforeClass
	public static void beforeAllTest() {
		System.out.println("BEFORE ALL TEST");
		AccountService as= new AccountService();
	}*/
	
	/*@AfterAll     //junit4 @AfterClass
	public static void afterAllTest() {
	System.out.println("AFTER ALL TEST");
	as=null;
	}*/

	/*@Test
	void testwithdraw() {
		Account ob=new Account(100,987654321, "hardika",10000);
		System.out.println("Add Tested");
	
	}*/
	@Test
	void testaddaccount() {
		Account ob=new Account(145,987654321, "hardika",10000);
		//as.addAccount(ob);
		System.out.println("Add Tested");
		assertTrue(as.addAccount(ob));
		
	}
	
	@Test
	void testaddaccount1() {
		Account ob=new Account(100,987654321, "hardika",10000);
		
		String s_id=Integer.toString(ob.getAid());
		assertTrue(Validator.validatedata(s_id, Validator.aidpattern));
		System.out.println("Add1 Tested");
	}

	@Test
	void testupdateaccount() {
		Account ob=new Account(101,987654321, "kalyani",20000);
		//as.updateAccount(ob);
		System.out.println("Update Tested");
		assertTrue(as.updateAccount(ob));	
	}
	
	@Test
	void testdeleteaccount() {
		Account ob=new Account(101,987654321, "kalyani",20000);
		//as.deleteAccount(ob);
		System.out.println("delete Tested");
		assertTrue(as.deleteAccount(ob));	
	}
	
	@Test
	void testtransferaccount() {
		Account from=new Account(101,987654321, "kalyani",20000);
		Account to=new Account(100,987654321, "hardika",10000);
		
		System.out.println("Transfer Tested");
		assertThrows(InsuffecientFundException.class,()->as.transferMoney(from, to, 2000));	

	}
	
	

	
	
	
}
