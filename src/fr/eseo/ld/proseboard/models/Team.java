package fr.eseo.ld.proseboard.models;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

public class Team {

    private Long id;

    private Long idTeamLeader;
    private String teamName;
    private int teamYear;
    private Long idSession;
    private Session session;
    private Long idClient;
    private String projectName;
    private Long idAccount;
    private Account account;
    private List<User> members;

    public Team(){
        //Empty constructor
    }

    public Team(Long idTeamLeader, String teamName, int teamYear, Account account, List<User> members){
        this.idTeamLeader = idTeamLeader;
        this.teamName = teamName;
        this.teamYear = teamYear;
        this.account = account;
        this.members = members;
    }

    public Team(Long idTeamLeader, String teamName, String projectName, Long idSession, Long idAccount, Long idClient){
        this.idTeamLeader = idTeamLeader;
        this.teamName = teamName;
        this.projectName = projectName;
        this.idSession = idSession;
        this.idAccount = idAccount;
        this.idClient = idClient;
    }
    
    public Team(Long idTeamLeader, String teamName, int teamYear, Long idSession, Long idAccount){  
        this.idTeamLeader = idTeamLeader;
        this.teamName = teamName;
        this.teamYear = teamYear; 
        this.idSession = idSession; 
        this.idAccount = idAccount;     
    }

    public Team(Long idTeamLeader, String teamName, int teamYear, Long idSession, Long idAccount, Long idClient){       
        this.idTeamLeader = idTeamLeader;
        this.teamName = teamName;
        this.teamYear = teamYear; 
        this.idSession = idSession; 
        this.idAccount = idAccount;     
        this.idClient = idClient;
    }

    public boolean hasUser(User user){
        for(User member : getMembers()){
            if(member.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }

    public String getName(Long id){
        for(User member : getMembers()){
            if(member.getId() == id){
                String username = new String();
                username = member.getLastName() + member.getFirstName();
                return username;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTeamLeader() {
        return idTeamLeader;
    }

    public void setIdTeamLeader(Long idTeamLeader) {
        this.idTeamLeader = idTeamLeader;
    }

    public String getTeamName() {
        if(teamName == null){
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
                setTeamName(teamMapper.getTeamName(getId()));
                sqlSession.commit();
            }finally{
                sqlSession.close();
            }
        }
        return teamName;

    }

    public Long getSession(Long id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        Long sessionId;
        try{
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            sessionId = teamMapper.getSession(id);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return sessionId;
    }

    public Long getIdBySession(Long id) {

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        try{
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            this.id = teamMapper.getIdBySession(id);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return this.id;

    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projetName) {
        this.projectName = projetName;
    }

    public String getProjectNameById(Long id) {

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        String pName;
        try{
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            pName = teamMapper.getProjectNameById(id);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        return pName;

    }

    public int getTeamYear() {
        return teamYear;
    }

    public void setTeamYear(int teamYear) {
        this.teamYear = teamYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Session getSession(){
        return session;
    }

    public void setSession(Session sess){
        this.session = sess;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

}


