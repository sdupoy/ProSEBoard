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
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateTimeslotMapper;

/**
 * Servlet implementation class DeleteTemplate
 */
@WebServlet("/DeleteTemplate")
public class DeleteTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTemplate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long id = Long.parseLong(request.getParameter("id"));

		try{
			
			TemplateTimeslotMapper templateTimeslotMapper = sqlSession.getMapper(TemplateTimeslotMapper.class);
			templateTimeslotMapper.deleteByIdTemplate(id);
			
			TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);
			templateMapper.delete(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Template supprimé");
		request.getRequestDispatcher("/WEB-INF/JSP/Templates.jsp").forward(request, response);
	}



}
