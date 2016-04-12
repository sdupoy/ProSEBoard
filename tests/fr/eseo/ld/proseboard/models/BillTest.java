package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class BillTest {

	@Test
	public void testEmptyConstructor() {
		Bill bill = new Bill();
		assertNotNull(bill);
	}
	
	@Test
	public void testConstructorWithParamaters() throws ParseException {
		// Long idTeamLeader, Long idClient, String subject, float amount, String comments, Date date
		String string = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date date = sdf.parse(string);
		Bill bill = new Bill(12L, 14L, "facture", (float) 102.3, "commentaire", date);
		assertNotNull(bill);
		assertEquals(12L, bill.getIdUserTransmitter(),0.1);
		assertEquals(14L, bill.getIdUserReceiver(),0.1);
		assertEquals("facture", bill.getSubject());
		assertEquals((float) 102.3, bill.getAmount(),0.1);
		assertEquals("commentaire", bill.getComments());
		assertEquals(date, bill.getDate());
		//assertEquals(string, bill.getSimpleDate());
	}

	@Test
	public void testGetIdBill() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setIdBill(1L);
		assertEquals(1L,bill.getIdBill(),0.1);
	}
	
	@Test
	public void testGetIdUserTransmitter() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setIdUserTransmitter(12L);
		assertEquals(12L,bill.getIdUserTransmitter(),0.1);
	}
	
	@Test
	public void testGetIdUserReceiver() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setIdUserReceiver(14L);
		assertEquals(14L,bill.getIdUserReceiver(),0.1);
	}
	
	@Test
	public void testGetSubject() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setSubject("Essai de sujet");
		assertEquals("Essai de sujet",bill.getSubject());
	}
	
	@Test
	public void testGetAmount() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setAmount((float)102.3);
		assertEquals((float)102.3,bill.getAmount(),0.1);
	}
	
	@Test
	public void testGetComments() {
		Bill bill = new Bill();
		assertNotNull(bill);
		bill.setComments("Essai de commentaire");
		assertEquals("Essai de commentaire",bill.getComments());
	}
	
	@Test
	public void testGetDate() throws ParseException {
		Bill bill = new Bill();
		assertNotNull(bill);
		String string = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date date = sdf.parse(string);
		bill.setDate(date);
		assertEquals(date,bill.getDate());
	}
	
	
}
