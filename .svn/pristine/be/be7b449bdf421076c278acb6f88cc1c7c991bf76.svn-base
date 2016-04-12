package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;

public interface TeamMapper {
    public Long getIdBySession(long id);
    public List<Team> getAllTeam();
    public Team getTeamNameById(long id);
    public List<User> getById(long idTeam);
    public List<User> getById2(long idTeam);
    Team getUserTeam(User user);
    public List<Team> getTeamsFromSession(Long idSession);
    public List<Team> getTeamsByClient(Long idClient);
    public List<Team> getTeamByTL(Long idTeamLeader);
    public void insert(Team team);
    public Long getIdTeamPrevious(Long id);
    public Long getIdTeamActual(Long id);
    public Team getTeamById(Long idTeam);
    public void deleteTeamById(Long idTeam);
    public void deleteTeamsAndAccountsBySessionId(Long id);
    public List<Team> getAll();
    public String getTeamName(Long id);
    public String getProjectNameById(Long id);
    public Long getSession(Long id);
    public List<User> getMembersByTeamId(Long id);
    public Long getSessionMax();
    public List<Team> getTeamsFromAuditor(@Param("idClient") Long idClient, @Param("idSession") Long idSession);
    public Long getIdTLByIdTeam(Long id);
    public Long getIdAccountByIdTL(Long id);
    public List<Team> getTeamByIdTeam(Long id);
    public List<Team> getAllTeamsByTeamUsers(@Param("list") List<TeamUser> teamUserListe);

}