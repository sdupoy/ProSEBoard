package fr.eseo.ld.proseboard.models;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class SessionTestJUnit {
	
	@Test
	public void testEmptyConstructor() {
		Session s = new Session();
		assertNotNull(s);
	}
	
	@Test
	public void testSession() throws ParseException {
		//String name, Long nbTeam, Date startDate, Date endDate
		String sDeb = "08/09/2014";
		String sFin = "08/05/2014";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
		Date dDeb = sdf.parse(sDeb);
		Date dFin = sdf.parse(sFin);
		Session s = new Session("Youhou",12L,dDeb,dFin);
		assertNotNull(s);
		assertEquals("Youhou",s.getName());
		assertEquals(12L,s.getNbTeam(),0.1);
		assertEquals(dDeb,s.getStartDate());
		assertEquals(dFin,s.getEndDate());
	}
	
	@Test
	public void testGetId() {
		Session s = new Session();
		assertNotNull(s);
		s.setId(12L);
		assertEquals(12L,s.getId(),0.1);
	}
	
	@Test
	public void testGetName() {
		Session s = new Session();
		assertNotNull(s);
		s.setName("Test");
		assertEquals("Test",s.getName());
	}
	
	@Test
	public void testGetNbTeam() {
		Session s = new Session();
		assertNotNull(s);
		s.setNbTeam(12L);
		assertEquals(12L,s.getNbTeam(),0.1);
	}
	
	@Test
	public void testGetStartDate() throws ParseException {
		String sDeb = "08/09/2014";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date dDeb = sdf.parse(sDeb);
		Session s = new Session();
		assertNotNull(s);
		s.setStartDate(dDeb);
		assertEquals(dDeb,s.getStartDate());
		assertEquals(sDeb,s.getSlashStartDate());
	}
	
	@Test
	public void testGetEndDate() throws ParseException {
		String sFin = "08/09/2014";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date dFin = sdf.parse(sFin);
		Session s = new Session();
		assertNotNull(s);
		s.setEndDate(dFin);
		assertEquals(dFin,s.getEndDate());
		assertEquals(sFin,s.getSlashEndDate());
	}
	
	@Test
	public void testGetOpen() {
		Session s = new Session();
		assertNotNull(s);
		s.setOpen(false);
		assertFalse(s.isOpen());
		s.setOpen(true);
		assertTrue(s.isOpen());
	}
}