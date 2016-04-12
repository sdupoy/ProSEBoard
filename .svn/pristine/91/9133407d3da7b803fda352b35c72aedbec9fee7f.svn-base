package fr.eseo.ld.proseboard.models;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class AccountHistoryTest {
	
	
	@Test
	public void testEmptyConstructor() {
		AccountHistory acc = new AccountHistory();
		assertNotNull(acc);
	}
	
	@Test
	public void testGetIdHistory(){
		AccountHistory acc = new AccountHistory();
		acc.setIdHistory((long)1);
		assertEquals(acc.getIdHistory(),1,0.1);
	}
	
	@Test
	public void testGetIdAccount(){
		AccountHistory acc = new AccountHistory();
		acc.setIdAccount((long)1);
		assertEquals(acc.getIdAccount(),1,0.1);
	}
	
	@Test
	public void testGetSolde(){
		AccountHistory acc = new AccountHistory();
		acc.setSolde((float)1);
		assertEquals(acc.getSolde(),1,0.1);
	}
	
	@Test
	public void testGetDate(){
		AccountHistory acc = new AccountHistory();
		Date date = new Date();
		date.setTime(61202516585000L);
		acc.setDate(date);
		AccountHistory acc2 = new AccountHistory();
		Date date2 = new Date();
		date2.setTime(61202516585000L);
		acc2.setDate(date2);
		assertEquals(acc.getDate(),acc2.getDate());
	}

	
	
	
	
}
