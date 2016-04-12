package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.StatusUser;
import fr.eseo.ld.proseboard.models.Template;
import fr.eseo.ld.proseboard.models.TemplateTimeslot;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.StatusUserMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateTimeslotMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class NewTimeslot
 */
@WebServlet("/NewTimeslot")
public class NewTimeslot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public NewTimeslot() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			
			TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);
			List<Template> templates = templateMapper.getAll();
			
			StatusUserMapper statusUserMapper = sqlSession.getMapper(StatusUserMapper.class);
			List<StatusUser> statusUser= statusUserMapper.getByIdTeacher();
			
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List <User> users = userMapper.getAllByIdStatus(statusUser);
			
			request.setAttribute("templates", templates);
			request.setAttribute("users", users);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/NewTimeslot.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		
		Long idTemplate = Long.parseLong(request.getParameter("template"));
		Long idUser = Long.parseLong(request.getParameter("user"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		
		TemplateTimeslot templateTimeslot = new TemplateTimeslot();
		templateTimeslot.setQuantity(quantity);
		templateTimeslot.setTeacherId(idUser);
		templateTimeslot.setTemplateId(idTemplate);
		templateTimeslot.setTimeslotName(name);
		
		try{
			TemplateTimeslotMapper templateTimeslotMapper = sqlSession.getMapper(TemplateTimeslotMapper.class);
			templateTimeslotMapper.insert(templateTimeslot);
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Nouveau TimeSlot ajouté");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}

}
