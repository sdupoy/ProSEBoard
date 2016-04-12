package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainingTest {
	
	@Test
	public final void testTraining1() {
		Training t = new Training(26L, "TEST",false,"rouge", 12.3f);
		assertNotNull(t);
	}
	
	@Test
	public final void testTraining() {
		Training t = new Training();
		assertNotNull(t);
	}
	
	@Test
	public final void testGetId() {
		Training t = new Training();
		assertNotNull(t);
		t.setId(12L);
		assertEquals(12L,t.getId(),0.1);
	}
	
	@Test
	public final void testGetIdEvent() {
		Training t = new Training();
		assertNotNull(t);
		t.setIdEvent(12L);
		assertEquals(12L,t.getIdEvent(),0.1);
	}
	
	@Test
	public final void testGetHourCost() {
		Training t = new Training();
		assertNotNull(t);
		t.setHourCost((float)29.5);
		assertEquals((float)29.5,t.getHourCost(),0.1);
	}
	
	@Test
	public final void testGetNbHours() {
		Training t = new Training();
		assertNotNull(t);
		t.setNbHours((float)2.5);
		assertEquals((float)2.5,t.getNbHours(),0.1);
	}
	
	@Test
	public final void testGetAmountPerAttender() {
		Training t = new Training();
		assertNotNull(t);
		t.setAmountPerAttender((float)52.5);
		assertEquals((float)52.5,t.getAmountPerAttender(),0.1);
	}
	
	@Test
	public final void testGetIdEducator() {
		Training t = new Training();
		assertNotNull(t);
		t.setIdEducator(12L);
		assertEquals(12L,t.getIdEducator(),0.1);
	}
	
	@Test
	public final void testCharge() {
		Training t = new Training();
		assertNotNull(t);
		t.setCharged(true);
		assertTrue(t.isCharged());
		t.setCharged(false);
		assertFalse(t.isCharged());
	}
	
	@Test
	public final void testGetRessources() {
		Training t = new Training();
		assertNotNull(t);
		t.setRessources("Besoins");
		assertEquals("Besoins",t.getRessources());
	}
	
	@Test
	public final void testTraining2() {
		Training t = new Training();
		assertNotNull(t);
	}

	@Test
	public final void testGetSubject() {
		Training t = new Training(26L, "TEST",false,"rouge", 12.3f);
		assertEquals(t.getSubject(),"TEST");
	}

	@Test
	public final void testSetSubject() {
		Training t = new Training(26L, "TEST",false,"rouge", 12.3f);
		t.setSubject("BONJOUR");
		assertEquals(t.getSubject(),"BONJOUR");		
	}

	@Test
	public final void testGetNbGroup() {
		Training t = new Training(26L, "TEST",false,"rouge", 12.3f);
		t.setNbAttenders(12);
		assertEquals(t.getNbAttenders(),12);
	}

	
}