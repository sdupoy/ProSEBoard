package fr.eseo.ld.proseboard.models;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

public class TemplateTimeslot {

    private Long templateTimeslotId;
    private String timeslotName;
    private int quantity;
    private Long templateId;
    private Long teacherId;
    private User teacher;

    public TemplateTimeslot(){
    }

    public Long getTemplateTimeslotId() {
        return templateTimeslotId;
    }

    public void setTemplateTimeslotId(Long templateTimeslotId) {
        this.templateTimeslotId = templateTimeslotId;
    }

    public String getTimeslotName() {
        return timeslotName;
    }

    public void setTimeslotName(String timeSlotName) {
        timeslotName = timeSlotName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public User getTeacher() {
        if(teacher == null){
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                setTeacher(sqlSession.getMapper(UserMapper.class).getById(getTeacherId()));
            }finally{
                sqlSession.close();
            }
        }
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }


}
