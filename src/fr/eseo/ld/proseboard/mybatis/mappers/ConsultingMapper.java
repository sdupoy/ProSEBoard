package fr.eseo.ld.proseboard.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.TeamUser;

public interface ConsultingMapper {
	public void insertConsulting(Consulting consulting);
	public Consulting getByEventId(Long id);
	public Long getIdTeamById(Long id);
	public void setConsultToCharged(Consulting consulting);
	public void chargeTeam(Consulting consulting);
	public void creditConsultant(Consulting consulting);
	public List<Consulting> searchConsult(@Param("idUsr") Long idUsr);
	public Consulting getById(Long id);
	public List<Consulting> getAll();
	public List<Consulting> getByConsultant(Long idConsultant);
	public List<Consulting> getByTeam(Long idTeam);
	public List<Consulting> getAllWithUsers();
	public void deleteConsultingBySessionId(Long idSession);
	public List<Consulting> getByConsultantForReport(Long id);
	public void updateReport(Consulting consultReport);
	public List<Consulting> getConsByIdTeam(@Param("list") List<TeamUser> teamUser);
}
