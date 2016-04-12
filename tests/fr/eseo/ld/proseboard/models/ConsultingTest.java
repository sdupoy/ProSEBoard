package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConsultingTest {

	@Test
	public void testConsulting() {
		Consulting c = new Consulting();
		assertNotNull(c);
	}
	
	@Test
	public void testConsultingBis() {
		// Long idSession, Long idConsultant
		Consulting c = new Consulting(123L, 124L);
		assertNotNull(c);
		assertEquals(124L, c.getIdConsultant(),0.1);
		assertEquals(123L, c.getId(),0.1);
	}
	
	@Test
	public void testConsultingConstructor1() {
		//Long idEvent,Long idConsultant,Long idTeam, float hourCost,boolean isCharged,String report
		Consulting c = new Consulting(1L,1L,1L,(float)80.2,false,"ceci est un rapport de test");
		assertNotNull(c);
		assertEquals(1L, c.getIdEvent(),0.1);
		assertEquals(1L, c.getIdConsultant(),0.1);
		assertEquals(1L, c.getIdTeam(),0.1);
		assertEquals((float)80.2, c.getHourCost(),0.1);
		assertFalse(c.isCharged());
		assertEquals("ceci est un rapport de test",c.getReport());
	}
	
	@Test
	public void testConsultingConstructor2() {
		//Long id, Long idConsultant, Long idTeam, String report, float hourCost
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",(float)80.2);
		assertNotNull(c);
		assertEquals(1L, c.getIdConsultant(),0.1);
		assertEquals(1L, c.getIdTeam(),0.1);
		assertEquals((float)80.2, c.getHourCost(),0.1);
		assertEquals("ceci est un rapport de test",c.getReport());
	}

	@Test
	public void testGetIdConsultant() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		assertEquals(1L,c.getIdConsultant(),0.1);
	}

	@Test
	public void testSetIdConsultant() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		c.setIdConsultant(5L);
		assertEquals(5L,c.getIdConsultant(),0.1);
	}

	@Test
	public void testGetIdTeam() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		assertEquals(1L,c.getIdTeam(),0.1);
	}

	@Test
	public void testSetIdTeam() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		c.setIdTeam(10L);
		assertEquals(10,c.getIdTeam(),0.1);
	}

	@Test
	public void testGetReport() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		assertEquals("ceci est un rapport de test",c.getReport());
	}

	@Test
	public void testSetReport() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		c.setReport("ceci est un test");
		assertEquals("ceci est un test",c.getReport());
	}
	
	@Test
	public void testSetHourCost() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		c.setHourCost(15);
		assertEquals(15,c.getHourCost(),0.1);
	}

	@Test
	public void testGetIdConsult() {
		Consulting c = new Consulting(10L,1L,1L,"ceci est un rapport de test",1);
		assertEquals(1L,c.getIdConsultant(),0.1);
	}

	@Test
	public void testSetIdConsult() {
		Consulting c = new Consulting(1L,1L,1L,"ceci est un rapport de test",1);
		c.setIdConsultant(50L);
		assertEquals(50L,c.getIdConsultant(),0.1);
	}

	@Test
	public void testGetIdEvent(){
		Consulting c = new Consulting();
		assertNotNull(c);
		c.setIdEvent(12L);
		assertEquals(12L,c.getIdEvent(),0.1);
	}
	
	@Test
	public void testGetNbHours(){
		Consulting c = new Consulting();
		assertNotNull(c);
		c.setNbHours((float)80.9);
		assertEquals((float)80.9, c.getNbHours(),0.1);
	}
	
	@Test
	public void testIsCharged(){
		Consulting c = new Consulting();
		assertNotNull(c);
		c.setCharged(true);
		assertTrue(c.isCharged());
		c.setCharged(false);
		assertFalse(c.isCharged());
	}
}
