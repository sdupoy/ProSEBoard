package fr.eseo.ld.proseboard.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TeamTest {

	@Test
	public void testEmptyConstructor() {
		Team team= new Team();
		assertNotNull(team);
	}
		
	@Test
	public void testSecondConstructor() {
		//Long idTeamLeader, String teamName, String projectName, Long idSession, Long idAccount, Long idClient
		Team team= new Team(1L,"Equipe 1", "Appli", 10L, 123L, 29L);
		assertNotNull(team);
		assertEquals(1L, team.getIdTeamLeader(), 0.1);
		assertEquals("Equipe 1", team.getTeamName());
		assertEquals("Appli", team.getProjectName());
		assertEquals(10L, team.getIdSession(), 0.1);
		assertEquals(123L, team.getIdAccount(), 0.1);
		assertEquals(29L, team.getIdClient(), 0.1);
	}
	
	@Test
	public void testThirdConstructor() {
		//Long idTeamLeader, String teamName, int teamYear, Long idSession, Long idAccount
		Team team= new Team(1L,"Equipe 1", 2015, 10L, 123L);
		assertNotNull(team);
		assertEquals(1L, team.getIdTeamLeader(), 0.1);
		assertEquals("Equipe 1", team.getTeamName());
		assertEquals(10L, team.getIdSession(), 0.1);
		assertEquals(123L, team.getIdAccount(), 0.1);
		assertEquals(2015, team.getTeamYear());
	}
	
	@Test
	public void testForthConstructor() {
		//Long idTeamLeader, String teamName, int teamYear, Long idSession, Long idAccount, Long idClient
		Team team= new Team(1L,"Equipe 1", 2015, 10L, 123L, 29L);
		assertNotNull(team);
		assertEquals(1L, team.getIdTeamLeader(), 0.1);
		assertEquals("Equipe 1", team.getTeamName());
		assertEquals(10L, team.getIdSession(), 0.1);
		assertEquals(123L, team.getIdAccount(), 0.1);
		assertEquals(29L, team.getIdClient(), 0.1);
		assertEquals(2015, team.getTeamYear());
	}
	
	
	@Test
	public void testGetId() {
		Team team= new Team();
		assertNotNull(team);
		team.setId(43L);
		assertEquals(43L,team.getId(),0.1);
	}
	
	@Test
	public void testGetIdSession() {
		Team team= new Team();
		assertNotNull(team);
		team.setIdSession(43L);
		assertEquals(43L,team.getIdSession(),0.1);
	}

	@Test
	public void testGetIdTL() {
		Team team= new Team();
		assertNotNull(team);
		team.setIdTeamLeader(43L);
		assertEquals(43L,team.getIdTeamLeader(),0.1);
	}
	
	@Test
	public void testGetIdClient() {
		Team team= new Team();
		assertNotNull(team);
		team.setIdClient(43L);
		assertEquals(43L,team.getIdClient(),0.1);
	}
	
	@Test
	public void testGetIdAccount() {
		Team team= new Team();
		assertNotNull(team);
		team.setIdAccount(43L);
		assertEquals(43L,team.getIdAccount(),0.1);
	}
	
	@Test
	public void testGetTeamName() {
		Team team= new Team();
		assertNotNull(team);
		team.setTeamName("Youhou");
		assertEquals("Youhou",team.getTeamName());
	}
	
	@Test
	public void testGetProjectName() {
		Team team= new Team();
		assertNotNull(team);
		team.setProjectName("Youhou");
		assertEquals("Youhou",team.getProjectName());
	}
	
	@Test
	public void testGetTeamYear() {
		Team team= new Team();
		assertNotNull(team);
		team.setTeamYear(2015);
		assertEquals(2015,team.getTeamYear());
	}
}
