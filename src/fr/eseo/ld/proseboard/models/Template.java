package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateTimeslotMapper;

public class Template {

    private Long templateId;
    private String templateName;
    private Date updateAt;
    private List<TemplateTimeslot> timeslots;

    public Template(){

    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateAtPrintf() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(updateAt);
    }

    public List<TemplateTimeslot> getTimeslots() {
        if(timeslots == null){
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                setTimeslots(sqlSession.getMapper(TemplateTimeslotMapper.class).getForTemplate(getTemplateId()));
            }finally{
                sqlSession.close();
            }
        }
        return timeslots;
    }

    public void setTimeslots(List<TemplateTimeslot> timeslots) {
        this.timeslots = timeslots;
    }



}
