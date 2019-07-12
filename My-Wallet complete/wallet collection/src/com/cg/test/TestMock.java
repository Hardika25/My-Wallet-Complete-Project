package com.cg.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.service.AccountService;

class TestMock {

	private AccountService service;
	private AccountDAO mockDao;
	

	@Before
	public void setup() {
		service = new AccountService();
		mockDao = EasyMock.createMock(AccountDAO.class);
	   
	}
	@Test
	public void test(){
		Account ob = new Account();
		int aid=108;
		long mobileno=965718603;
		String name= "hardika";
		double sal=80000;
		EasyMock.expect(mockDao.findAccount(mobileno)).andReturn(ob);
		EasyMock.replay(mockDao);
		assertNotNull(service.findAccount(mobileno));
		EasyMock.verify(mockDao);
		
		
		
	}
		
	}