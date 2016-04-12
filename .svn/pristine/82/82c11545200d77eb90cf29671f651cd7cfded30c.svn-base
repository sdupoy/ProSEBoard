package fr.eseo.ld.proseboard.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;

public class AuditReport {

    private Long id;
    private double note;
    private Long idAuditor;
    private Long idTeam;
    private Date date;
    private String report;
    private String comment;
    private int color1;
    private int color2;
    private int color3;
    private int finalColor;
    private int percent;
    private int publicate;

    public AuditReport(){
    }

    public AuditReport(Long id, double note, Long idTeam, String report, String comment, int color1, int color2, int color3, int finalColor, int publicate) {
        this.id = id;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.comment = comment;
        this.finalColor = finalColor;
        this.idTeam = idTeam;
        this.note = note;
        this.report = report;
        this.publicate = publicate;
    }

    public AuditReport(double note, Long idTeam, String report, String comment, int color1, int color2, int color3, int finalColor, int publicate) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.comment = comment;
        this.finalColor = finalColor;
        this.idTeam = idTeam;
        this.note = note;
        this.report = report;
        this.publicate = publicate;
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPublicate(){
        return publicate;
    }

    public void setPublicate(int publicate){
        this.publicate = publicate;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Long getIdAuditor() {
        return idAuditor;
    }

    public void setIdAuditor(Long idAuditor) {
        this.idAuditor = idAuditor;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getReport() {
        return report;
    }

    public Date getDate() {
        return date;
    }

    public String getDatePrintf() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 = color3;
    }

    public int getFinalColor() {
        return finalColor;
    }

    public void setFinalColor(int finalColor) {
        this.finalColor = finalColor;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getTeamName(Long idTeam){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            return auditReportMapper.getAuditTeamName(idTeam);
        }finally{
            sqlSession.close();
        }

    }

    public String getTeamNameDistinct(Long idTeam){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            return auditReportMapper.getAuditTeamNameDistinct(idTeam);
        }finally{
            sqlSession.close();
        }

    }


    public Long getIdSession(Long idTeam){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            return auditReportMapper.getIdSess(idTeam);
        }finally{
            sqlSession.close();
        }

    }

    public Long getMaxIdSession(){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            return auditReportMapper.getMaxIdSess();
        }finally{
            sqlSession.close();
        }

    }

    public Long getTeam(){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            return auditReportMapper.getMaxIdSess();
        }finally{
            sqlSession.close();
        }

    }

    public String getDate(Long id) {
        String myDate;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            myDate = auditReportMapper.getDateFromAudit(id);
        }finally{
            sqlSession.close();
        }
        return myDate;
    }

    public Long getTeam2(Long id) {
        Long id2;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{	
            AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
            sqlSession.commit();
            id2= auditReportMapper.getIdTeamFromAudit(id);
        }finally{
            sqlSession.close();
        }
        return id2;
    }

}