package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class MessageTest {

	Date date = new Date();
	
	@Test
	public void testMessage1() {
		Message message = new Message();
		assertNotNull(message);
	}
	
	@Test
	public void testMessage2() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertNotNull(message);
	}
	
	@Test
	public void testGetIdMessage() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(1,message.getIdMessage());
	}
	
	@Test
	public void testSetIdMessage() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setIdMessage(2);
		assertEquals(2,message.getIdMessage());
	}
	
	@Test
	public void testGetIdEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(1,message.getIdEmetter());
	}
	
	@Test
	public void testSetIdEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setIdEmetter(2);
		assertEquals(2,message.getIdEmetter());
	}
	
	@Test
	public void testGetIdReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(2,message.getIdReceiver());
	}
	
	@Test
	public void testSetIdReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setIdReceiver(3);
		assertEquals(3,message.getIdReceiver());
	}

	@Test
	public void testGetMailEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals("maxime.boisumeau@reseau.eseo.fr",message.getMailEmetter());
	}
	
	@Test
	public void testSetMailEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setMailEmetter("simon.dupoy@reseau.eseo.fr");
		assertEquals("simon.dupoy@reseau.eseo.fr",message.getMailEmetter());
	}
	
	@Test
	public void testGetMailReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals("simon.dupoy@reseau.eseo.fr",message.getMailReceiver());
	}
	
	@Test
	public void testSetMailReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setMailReceiver("maxime.boisumeau@reseau.eseo.fr");
		assertEquals("maxime.boisumeau@reseau.eseo.fr",message.getMailReceiver());
	}
	
	@Test
	public void testGetDate() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(date,message.getDate());
	}
	
	@Test
	public void testGetDatePrintf() throws ParseException {
		String s = "2011/07/08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date d = sdf.parse(s);
		/*Message message = */new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",d,"Bonjour Simon",0,0,0);
		//assertEquals(s,message.getDatePrintf());
	}
	
	@Test
	public void testSetDate() {
		
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		Date date2 = new Date();
		message.setDate(date2);
		assertEquals(date2,message.getDate());
	}
	
	@Test
	public void testGetContain() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals("Bonjour Simon",message.getContain());
	}
	
	@Test
	public void testSetContain() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setContain("Salut Simon");
		assertEquals("Salut Simon",message.getContain());
	}
	
	@Test
	public void testGetRead() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(0,message.getRead());
	}
	
	@Test
	public void testSetRead() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setRead(1);
		assertEquals(1,message.getRead());
	}
	
	@Test
	public void testGetTrashEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(0,message.getTrashEmetter());
	}
	
	@Test
	public void testSetTrashEmetter() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setTrashEmetter(1);
		assertEquals(1,message.getTrashEmetter());
	}
	
	@Test
	public void testGetTrashReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		assertEquals(0,message.getTrashReceiver());
	}
	
	@Test
	public void testSetTrashReceiver() {
		Message message = new Message(1,1,2,"maxime.boisumeau@reseau.eseo.fr","simon.dupoy@reseau.eseo.fr",date,"Bonjour Simon",0,0,0);
		message.setTrashReceiver(1);
		assertEquals(1,message.getTrashReceiver());
	}
	

}
