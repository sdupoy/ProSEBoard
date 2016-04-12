package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermissionTest {

	@Test
	public void testEmptyConstructor() {
		Permission perm = new Permission();
		assertNotNull(perm);
	}
	
	@Test
	public void testGetId() {
		Permission perm = new Permission();
		assertNotNull(perm);
		perm.setId(123L);
		assertEquals(perm.getId(), 123L, 0.1);
	}

	@Test
	public void testGetName() {
		Permission perm = new Permission();
		assertNotNull(perm);
		perm.setName("permission");
		assertEquals(perm.getName(), "permission");
	}
}
