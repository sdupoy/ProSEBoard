package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

	@Test
	public void testGetId() {
		User u = new User();
		Long i = (long) 214748374;
		u.setId(i);
		assertEquals(i,u.getId());
	}
	
	@Test
	public void testGetIdOnRedmine() {
		User u = new User();
		Long i = (long) 214748374;
		u.setIdRedmine(i);
		assertEquals(i,u.getIdRedmine());
	}
	
	@Test
	public void testGetIdAccount() {
		User u = new User();
		Long i = (long) 214748374;
		u.setIdAccount(i);
		assertEquals(i,u.getIdAccount());
	}

	@Test
	public void testGetMail(){
		User u = new User();
		u.setMail("machin@truc.com");
		String mail = u.getMail();
		assertEquals(mail,"machin@truc.com");
	}
	
	@Test
	public void testGetPasswordClear(){
		User u = new User();
		u.setPassword("kzjfvkoj");
		String pswd = u.getPassword();
		assertEquals(pswd,"kzjfvkoj");
	}
	
	@Test
	public void testGetName(){
		User u = new User();
		u.setLastName("Johnny");
		String name = u.getLastName();
		assertEquals(name,"Johnny");
	}
	
	@Test
	public void testGetFirstName(){
		User u = new User();
		u.setFirstName("Cotine");
		String first = u.getFirstName();
		assertEquals(first,"Cotine");
	}
	
	@Test
	public void testGetStatus(){
		User u = new User();
		Status s = new Status(); // Mock?
		s.setId(1L);
		s.setName("admin");
		ArrayList<Status> statuses = new ArrayList<Status>();
		statuses.add(s);
		u.setStatuses(statuses);
		assertEquals(u.getStatuses(),statuses);
	}
	
	@Test
	public void testGetAbsence(){
		User u = new User();
		u.setAbsent(false);
		assertFalse(u.isAbsent());
		u.setAbsent(true);
		assertTrue(u.isAbsent());
	}
}
