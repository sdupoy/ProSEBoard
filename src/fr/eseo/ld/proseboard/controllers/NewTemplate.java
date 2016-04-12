package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Template;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;

/**
 * Servlet implementation class NewTemplate
 */
@WebServlet("/NewTemplate")
public class NewTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTemplate() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/JSP/NewTemplate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Template template = new Template();

		template.setTemplateName(request.getParameter("template"));
		template.setUpdateAt(new Date((Calendar.getInstance()).getTimeInMillis()));
		

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			
			TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);
			templateMapper.insert(template);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Nouveau Template Enregistré");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}

}
