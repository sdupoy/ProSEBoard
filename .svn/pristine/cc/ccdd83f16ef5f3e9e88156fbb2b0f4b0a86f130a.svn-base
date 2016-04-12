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
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateTimeslotMapper;

/**
 * Servlet implementation class DeleteTimeslot
 */
@WebServlet("/DeleteTimeslot")
public class DeleteTimeslot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTimeslot() {
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
			templateTimeslotMapper.delete(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Timeslot supprimé");
		request.getRequestDispatcher("/WEB-INF/JSP/Timeslots.jsp").forward(request, response);
	}


}
