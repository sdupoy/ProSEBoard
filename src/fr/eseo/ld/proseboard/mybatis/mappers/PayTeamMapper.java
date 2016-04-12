package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.PayTeam;
import fr.eseo.ld.proseboard.models.Team;

public interface PayTeamMapper {
	public List<Team> searchTeamsToPay(@Param("idUsr") Long idUsr);
	public void creditTeam(PayTeam payTeam);
	public void debitClient(PayTeam payTeam);
}
