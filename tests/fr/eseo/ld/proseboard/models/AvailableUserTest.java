package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class AvailableUserTest {

	@Test
	public void testEmptyConstructor() {
		AvailableUser avUser = new AvailableUser();
		assertNotNull(avUser);
	}
	
	@Test
	public void testGetIdUser() {
		AvailableUser avUser = new AvailableUser();
		assertNotNull(avUser);
		avUser.setIdUser(123L);
		assertEquals(123L,avUser.getIdUser(),0.1);
	}

	@Test
	public void testGetStartDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		AvailableUser avUser = new AvailableUser();
		assertNotNull(avUser);
		avUser.setDateStart(d);
		assertEquals(d,avUser.getDateStart());
		//assertEquals("07/08/2011 03:48",avUser.getDateStartString());
	}
	
	@Test
	public void testGetEndDate() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		AvailableUser avUser = new AvailableUser();
		assertNotNull(avUser);
		avUser.setDateEnd(d);
		assertEquals(d,avUser.getDateEnd());
		//assertEquals("07/08/2011 03:48",avUser.getDateEndString());
	}
}
