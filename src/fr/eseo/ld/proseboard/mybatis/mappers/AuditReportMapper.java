package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.AuditReport;
import fr.eseo.ld.proseboard.models.Team;

public interface AuditReportMapper {
	
	public List<AuditReport> getAll();
	public void insert(AuditReport auditReport);
	public void publicate(Long id);
	public void publicate2(Long id);
	public void publicate3(Long id);
	public void publicate4(Long id);
	public List<AuditReport> getByIdAuditor(Long id);
	public List<AuditReport> getStudentAudit(Long id);
	public List<AuditReport> getByIdTeam(Long id);
	public void update(AuditReport auditReport);
	public String getAuditTeamName(Long id);
	public String getAuditTeamNameDistinct(Long id);
	public Long getIdSess(Long id);
	public Long getMaxIdSess();
	public Long getMaxIdSess2();
	public Long getIdTeamFromAudit(Long id);
	public String getDateFromAudit(Long id);
	public AuditReport getById(Long id);
	public long getFinalColor(Long id);
	public List<AuditReport> getAllOrderByDate();
	public List<AuditReport> getAllOrderByEquipe();
	public List<AuditReport> getAllOrderByFond();
	public List<AuditReport> getAllOrderByForme();
	public List<AuditReport> getAllOrderByAttitude();
	public List<AuditReport> getAllOrderByCouleur();
	public List<AuditReport> getAllOrderByNote();
	public void deleteAuditsBySessionId(Long idSession);
	public List<AuditReport> getAllByTeams(@Param("list") List<Team> teamListe);
	public List<AuditReport> getAllByTeams2(@Param("list") List<Team> teamListe);
}