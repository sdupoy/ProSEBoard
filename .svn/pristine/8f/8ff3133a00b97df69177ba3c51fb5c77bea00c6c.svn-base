package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamUserTest {

	@Test
	public void testEmptyConstructor() {
		TeamUser tu = new TeamUser();
		assertNotNull(tu);
	}
	
	@Test
	public void testConstructor() {
		TeamUser tu = new TeamUser(1L,2L);
		assertNotNull(tu);
		assertEquals(1L,tu.getIdUser(),0.1);
		assertEquals(2L,tu.getIdTeam(),0.1);
	}

	@Test
	public void testGetIdUser() {
		TeamUser tu = new TeamUser();
		assertNotNull(tu);
		tu.setIdUser(12L);
		assertEquals(tu.getIdUser(), 12L, 0.1);
	}
	
	@Test
	public void testGetIdTeam() {
		TeamUser tu = new TeamUser();
		assertNotNull(tu);
		tu.setIdTeam(12L);
		assertEquals(tu.getIdTeam(), 12L, 0.1);
	}
}
