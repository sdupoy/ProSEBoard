package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.TeamUser;


public interface TeamUserMapper {

	public Long idTeamPrevious(Long id);
	public Long idTeamCurrent(Long id);
	public void insertTeamUser(TeamUser teamUser);
	public List<TeamUser> getTeamUserByUserId(Long idUser);
	public void deleteTeamUser(@Param("idUser") Long idUser, @Param("idTeam") Long idTeam);
	public Long getTeamIdFromUserId(Long idUser);
	public List<TeamUser> getAll();
	public void deleteTeamUserByTeamId(Long idTeam);
	public void deleteTeamUserBySessionId(Long idSession);
	public List<TeamUser> getTeamUserByIdTeam(Long idTeam);
}
