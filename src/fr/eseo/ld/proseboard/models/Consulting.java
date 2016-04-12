package fr.eseo.ld.proseboard.models;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;



public class Consulting {
	private Long id;
	private Long idEvent;	
	private Event event;
	private Long idConsultant;
	private User consultant;
	private Long idTeam;
	private Team team;
	private float hourCost;
	private float nbHours;
	private boolean isCharged;
	private String report;
	
	
	public Consulting(){
		//empty constructor
	}
	
	public Consulting(Long idEvent,Long idConsultant,Long idTeam, float hourCost,boolean isCharged,String report){
		this.idEvent=idEvent;
		this.idConsultant=idConsultant;
		this.idTeam=idTeam;
		this.hourCost=hourCost;
		this.isCharged=isCharged;
		this.report=report;
	}
	
	public Consulting(Long id, Long idConsultant, Long idTeam, String report, float hourCost) {
		this.setId(id);
		this.idConsultant = idConsultant;
		this.idTeam = idTeam;
		this.report = report;
		this.setHourCost(hourCost);
	}
	
	public Consulting(Long idSession, Long idConsultant){
		this.id = idSession;
		this.idConsultant=idConsultant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getIdConsultant() {
		return idConsultant;
	}

	public void setIdConsultant(Long idConsultant) {
		this.idConsultant = idConsultant;
	}
	
	public User getConsultant() {
		return consultant;
	}

	public void setConsultant(User consultant) {
		this.consultant = consultant;
	}

	public Long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Long idTeam) {
		this.idTeam = idTeam;
	}
	
	public void setTeam(Team team){
		this.team=team;
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public Long getIdTeamByIdConsult(Long id) {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long fetchedTeamId;
		try{
			ConsultingMapper teamMapper = sqlSession.getMapper(ConsultingMapper.class);
			fetchedTeamId = teamMapper.getIdTeamById(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		return fetchedTeamId;
		
	}

	public float getHourCost() {
		return hourCost;
	}

	public void setHourCost(float hourCost) {
		this.hourCost = hourCost;
	}
	
	public float getNbHours(){
		return this.nbHours;
	}
	
	public void setNbHours(float duration){
		this.nbHours=duration;
	}

	public boolean isCharged() {
		return isCharged;
	}

	public void setCharged(boolean isCharged) {
		this.isCharged = isCharged;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
}
