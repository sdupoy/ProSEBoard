package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testEmptyConstructor() {
		Account acc = new Account();
		assertNotNull(acc);
		assertEquals(acc.getBalance(),0,0.1);
	}
	
	@Test
	public void testConstructorWithOneParamater() {
		Account acc = new Account((float) 12.3);
		assertNotNull(acc);
		assertEquals(acc.getBalance(),12.3,0.1);
	}
	
	@Test
	public void testConstructorWithTwoParamaters() {
		Account acc = new Account((float) 12.3,12L);
		assertNotNull(acc);
		assertEquals(acc.getBalance(),12.3,0.1);
		assertEquals(acc.getIdAccount(),12L,0.1);
	}
	
	@Test
	public void testGetId() {
		Account acc = new Account();
		acc.setIdAccount(12L);
		assertNotNull(acc);
		assertEquals(acc.getIdAccount(),12L,0.1);
	}

	@Test
	public void testGetBalance() {
		Account acc = new Account();
		acc.setBalance((float)123.45);
		assertNotNull(acc);
		assertEquals(acc.getBalance(),123.45,0.1);
	}
}
