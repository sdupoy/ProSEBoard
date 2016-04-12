package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class ManageTrainingAbsents
 */
@WebServlet("/training/manageAbsents")
public class ManageTrainingAbsents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ManageTrainingAbsents() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

			Long idEvent = Long.parseLong(request.getParameter("idTraining"));
			
			if(request.getParameterValues("absent[]")!=null){
				String[] absents = request.getParameterValues("absent[]");				
				try {
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					for(int i=0; i<absents.length; i++){
						if(!absents[i].isEmpty()){
							userMapper.setAbsence(idEvent, Long.parseLong(absents[i]));
							sqlSession.commit();
						}
					}
				} finally {
					sqlSession.close();
				}
			}
			response.sendRedirect(request.getContextPath()+ response.encodeRedirectURL("/training/manager"));
		}
	}

}