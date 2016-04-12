package fr.eseo.ld.proseboard.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;


public class Notification {
    private Long idNotification;
    private Long idUser;
    private User user;
    private Long idObject;
    private Object object;
    private String type;
    private boolean saw;
    private Date createdAt;
    
    public Notification(){
        setSaw(false);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt2() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return sdf.format(createdAt);
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        if(user == null){
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                user = userMapper.getByIdWithPermissions(getIdUser());
            }finally{
                sqlSession.close();
            }
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdObject() {
        return idObject;
    }

    public void setIdObject(Long idObject) {
        this.idObject = idObject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSaw() {
        return saw;
    }

    public void setSaw(boolean saw) {
        this.saw = saw;
    }

    public Object getObject() {
        if(object == null){
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
                object = eventMapper.getById(getIdObject());

            }finally{
                sqlSession.close();
            }
        }
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
