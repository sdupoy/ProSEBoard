package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Template;
import fr.eseo.ld.proseboard.models.TemplateTimeslot;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateTimeslotMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class MyTimeslots
 */
@WebServlet("/MyTimeslots")
public class MyTimeslots extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTimeslots() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			
			try {
			TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);
			List<Template> templates = templateMapper.getAll();
			
			
			TemplateTimeslotMapper templateTimeslotMapper = sqlSession.getMapper(TemplateTimeslotMapper.class);
			List<TemplateTimeslot> timeslots = templateTimeslotMapper.getAll();
		
			
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> users = userMapper.getAll2();
			
			
			request.setAttribute("timeslots", timeslots);
			request.setAttribute("users", users);
			request.setAttribute("templates", templates);
			}catch(Exception e){
				
			}
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/MyTimeslots.jsp").forward(request, response);
	}

}
