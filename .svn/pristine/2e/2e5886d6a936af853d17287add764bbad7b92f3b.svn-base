package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class EventTest {

	@Test
	public void testEmptyConstructor() {
		Event event = new Event();
		assertNotNull(event);
	}
	
	@Test
	public void testGetId() {
		Event event = new Event();
		assertNotNull(event);
		event.setId(123L);
		assertEquals(123L, event.getId(), 0.1);
	}

	@Test
	public void testGetName() {
		Event event = new Event();
		assertNotNull(event);
		event.setName("EssaiNom");
		assertEquals("EssaiNom",event.getName());
	}
	
	@Test
	public void testGetDescription() {
		Event event = new Event();
		assertNotNull(event);
		event.setDescription("EssaiDescription");
		assertEquals("EssaiDescription",event.getDescription());
	}
	
	@Test
	public void testGetValidation() {
		Event event = new Event();
		assertNotNull(event);
		event.setValidation(123L);
		assertEquals(123L,event.getValidation(), 0.1);
	}
	
	@Test
	public void testGetIdCreator() {
		Event event = new Event();
		assertNotNull(event);
		event.setIdCreator(123L);
		assertEquals(123L,event.getIdCreator(), 0.1);
	}
	
	@Test
	public void testGetType(){
		Event event = new Event();
		assertNotNull(event);
		event.setType("TEST");
		assertEquals("TEST", event.getType());
	}
	
	@Test
	public void testGetStartDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		Event event = new Event();
		assertNotNull(event);
		event.setStartDate(d);
		assertEquals(d,event.getStartDate());
		//assertEquals("07/08/2011 03:48",avUser.getStartDateString());
	}
	
	@Test
	public void testGetEndDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		Event event = new Event();
		assertNotNull(event);
		event.setEndDate(d);
		assertEquals(d,event.getEndDate());
		//assertEquals("07/08/2011 03:48",avUser.getEndDateString());
	}
}
