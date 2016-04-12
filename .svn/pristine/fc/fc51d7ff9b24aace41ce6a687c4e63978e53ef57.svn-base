package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class RedmineEventTest {

	@Test
	public void testConstructor() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
	}
	
	@Test
	public void testGetId() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setId(123L);
		assertEquals(123L,redEv.getId(),0.1);
	}

	@Test
	public void testGetTackerId() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setTackerId(123);
		assertEquals(123,redEv.getTackerId());
	}
	
	@Test
	public void testGetSubject() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setSubject("Essai pour test");
		assertEquals("Essai pour test",redEv.getSubject());
	}
	
	@Test
	public void testGetDescription() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setDescription("Ceci est une description test");
		assertEquals("Ceci est une description test",redEv.getDescription());
	}
	
	@Test
	public void testGetStatusId() {
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setStatusId(2);
		assertEquals(2,redEv.getStatusId());
	}
	
	@Test
	public void testGetStartDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setStartDate(d);
		assertEquals(d,redEv.getStartDate());
		//assertEquals(s,redEv.getStartDateString());
	}
	
	@Test
	public void testGetEndDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		RedmineEvent redEv = new RedmineEvent();
		assertNotNull(redEv);
		redEv.setClosedDate(d);
		assertEquals(d,redEv.getClosedDate());
		//assertEquals(s,redEv.getClosedDateString());
	}
	
}
