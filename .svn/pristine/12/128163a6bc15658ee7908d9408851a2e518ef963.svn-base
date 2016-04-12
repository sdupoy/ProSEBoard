package fr.eseo.ld.proseboard.models;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateTest {

	
	@Test
	public void testEmptyConstructeur() {
		Template t = new Template();
		assertNotNull(t);
	}
	
	@Test
	public final void testGetTemplateId(){
		Template t = new Template();
		t.setTemplateId(1L);
		assertEquals(t.getTemplateId(), 1L,0.1);
	}
	
	@Test
	public final void testGetTamplateName(){
		Template t = new Template();
		t.setTemplateName("prose");
		assertEquals(t.getTemplateName(),"prose");
	}
	
	@Test
	public void testGetUpdateAt(){
		Template t = new Template();
		Date date = new Date();
		date.setTime(61202516585000L);
		t.setUpdateAt(date);
		Template t2 = new Template();
		Date date2 = new Date();
		date2.setTime(61202516585000L);
		t2.setUpdateAt(date2);
		assertEquals(t.getUpdateAt(),t2.getUpdateAt());
	}
	
	
}
