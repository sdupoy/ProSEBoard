package fr.eseo.ld.proseboard.models;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;


public class Training {
    private Long id;
    private Long idEvent;
    private Event event;
    private Team team;
    private List<User> attenders;
    private List<User> absents;
    private Long idEducator;
    private User educator;
    private String subject;
    private boolean isCharged;
    private String ressources;
    private float hourCost;
    private float nbHours;
    private int nbAttenders;
    private float amountPerAttender;
    private String report;

    public Training(){
        //Empty constructor
    }

    public Training(Long idEducator, String subject, boolean isCharged, String ressources, float hourCost){
        this.idEducator=idEducator;
        this.subject=subject;
        this.isCharged=isCharged;
        this.ressources=ressources;
        this.hourCost=hourCost;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEducator() {
        return idEducator;
    }

    public void setIdEducator(Long idEducator) {
        this.idEducator = idEducator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isCharged() {
        return isCharged;
    }

    public void setCharged(boolean isCharged) {
        this.isCharged = isCharged;
    }

    public String getRessources() {
        return ressources;
    }

    public void setRessources(String ressources) {
        this.ressources = ressources;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<User> getAttenders() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        try{
            attenders = trainingMapper.getAttenders(this);
        }finally{
            sqlSession.close();
        }
        return attenders;
    }

    public List<User> getAttendersBis(){
        return this.attenders;
    }

    public List<User> getAttendersFromTeam(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        try{
            attenders = trainingMapper.getAttendersFromTeam(this.getIdEvent(), user.getTeamList());
        }finally{
            sqlSession.close();
        }
        return attenders;
    }

    public void setAttenders(List<User> attenders) {
        this.attenders = attenders;
    }

    public List<User> getAbsents() {
        return absents;
    }

    public void setAbsents(List<User> absents) {
        this.absents = absents;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public float getHourCost() {
        return hourCost;
    }

    public void setHourCost(float hourCost) {
        this.hourCost = hourCost;
    }

    public void setEvent(Event ev){
        this.event=ev;
    }

    public Event getEventBis(){
        return this.event;
    }

    public Event getEvent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        try{
            event = trainingMapper.getEvent(this.getId());
        }finally{
            sqlSession.close();
        }
        return event;
    }

    public float getNbHours() {
        return nbHours;
    }

    public void setNbHours(float nbHours) {
        this.nbHours = nbHours;
    }

    public List<User> getMembers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        return trainingMapper.getAttenders(this);
    }

    public void setMembers(List<User> members) {
        this.attenders = members;
    }

    public int getNbAttenders() {
        return nbAttenders;
    }

    public User getEducator() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        return trainingMapper.getEducator(this.getIdEducator());
    }

    public void setNbAttenders(int nbAttenders) {
        this.nbAttenders = nbAttenders;
    }

    public float getAmountPerAttender() {
        return amountPerAttender;
    }

    public void setAmountPerAttender(float amountPerAtt) {
        this.amountPerAttender = amountPerAtt;
    }

    public boolean attendTo(User user){
        boolean attend = false;
        if(this.getAttenders()!=null){
            for(User current : this.getAttenders()){
                if(current.getId().equals(user.getId())){
                    attend = true;
                }
            }
        }
        return attend;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public User getEducatorBis() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }

}