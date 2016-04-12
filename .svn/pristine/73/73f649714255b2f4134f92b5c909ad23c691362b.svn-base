package fr.eseo.ld.proseboard.models;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ExpertiseMapper;

public class Expertise {
	
	private Long idExp;
	private Long idUser;
    private String name;
    
    public Expertise(){
    	//Empty constructor
    }
    
	public Long getIdExp() {
		return idExp;
	}
	
	public void setIdExp(Long idExp) {
		this.idExp = idExp;
	}

	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getIdUserByExp(long id){
		 SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	        try{	
	            ExpertiseMapper expertiseMapper = sqlSession.getMapper(ExpertiseMapper.class);
	            sqlSession.commit();
	            return expertiseMapper.getIdUserByIdExpMapper(id);
	        }finally{
	            sqlSession.close();
	        }
	}
}
