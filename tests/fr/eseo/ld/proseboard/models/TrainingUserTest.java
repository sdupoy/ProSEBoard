package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainingUserTest {
	
	
	@Test
	public void testEmptyConstructor() {
		TrainingUser tu = new TrainingUser();
		assertNotNull(tu);
	}
	
	@Test
	public void testGetIdTraining(){
		TrainingUser tu = new TrainingUser();
		tu.setIdTraining(1L);
		assertEquals(tu.getIdTraining(),1L,0.1);
	}
	
	@Test
	public void testGetIdUser(){
		TrainingUser tu = new TrainingUser();
		tu.setIdUser(1L);
		assertEquals(tu.getIdUser(),1L,0.1);
	}
	
	@Test
	public void testGetIsAbsent(){
		TrainingUser tu = new TrainingUser();
		tu.setIsAbsent(true);
		assertEquals(tu.getIsAbsent(),true);
	}
	

}
