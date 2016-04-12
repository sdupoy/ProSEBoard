package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class NotificationTest {

	@Test
	public void testConstructor() {
		Notification note = new Notification();
		assertNotNull(note);
		assertFalse(note.isSaw());
	}
	
	@Test
	public void testGetIdNotif() {
		Notification note = new Notification();
		assertNotNull(note);
		note.setIdNotification(123L);
		assertEquals(123L, note.getIdNotification(),0.1);
	}

	@Test
	public void testGetIdUser() {
		Notification note = new Notification();
		assertNotNull(note);
		note.setIdUser(123L);
		assertEquals(123L, note.getIdUser(),0.1);
	}
	
	@Test
	public void testGetIdObject() {
		Notification note = new Notification();
		assertNotNull(note);
		note.setIdObject(123L);
		assertEquals(123L, note.getIdObject(),0.1);
	}
	
	@Test
	public void testGetType() {
		Notification note = new Notification();
		assertNotNull(note);
		note.setType("Test");
		assertEquals("Test", note.getType());
	}
	
	@Test
	public void testGetSaw() {
		Notification note = new Notification();
		assertNotNull(note);
		assertFalse(note.isSaw());
		note.setSaw(true);
		assertTrue(note.isSaw());
	}
	
	@Test
	public void testGetCreatedAt() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		Notification note = new Notification();
		assertNotNull(note);
		note.setCreatedAt(d);
		assertEquals(d,note.getCreatedAt());
	}
}
