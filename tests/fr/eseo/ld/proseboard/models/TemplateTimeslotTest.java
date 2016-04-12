package fr.eseo.ld.proseboard.models;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemplateTimeslotTest {
	
	
	@Test
	public void testEmptyContructeur() {
		TemplateTimeslot tt = new TemplateTimeslot();
		assertNotNull(tt);
	}
	
	@Test
	public void testGetTemplateTimeslotId() {
		TemplateTimeslot tt = new TemplateTimeslot();
		tt.setTemplateTimeslotId(1L);
		assertEquals(tt.getTemplateTimeslotId(),1L,0.1);
	}
	
	@Test
	public void testGetTimesName() {
		TemplateTimeslot tt = new TemplateTimeslot();
		tt.setTimeslotName("UML");
		assertEquals(tt.getTimeslotName(),"UML");
	}
	
	@Test
	public void testGetQuantity() {
		TemplateTimeslot tt = new TemplateTimeslot();
		tt.setQuantity(1);
		assertEquals(tt.getQuantity(),1,0.1);
	}
	
	@Test
	public void testGetTemplateId() {
		TemplateTimeslot tt = new TemplateTimeslot();
		tt.setTemplateId(1L);
		assertEquals(tt.getTemplateId(),1L,0.1);
	}
	
	@Test
	public void testGetTeacherId() {
		TemplateTimeslot tt = new TemplateTimeslot();
		tt.setTeacherId(1L);
		assertEquals(tt.getTeacherId(),1L,0.1);
	}
	
	
	

}
