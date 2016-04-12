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
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;

/**
 * Servlet implementation class PublishTraining
 */
@WebServlet("/Educator/PublishTraining")
public class PublishTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublishTraining() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
					.openSession();
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
			String name = null;
			try {
				name = (String)request.getParameter("name");
				long id = Long.parseLong(request.getParameter("eventId"));
				name=name.intern();
				if(name=="publish"){
					eventMapper.acceptById(id);
					sqlSession.commit();
					response.sendRedirect(request.getContextPath()
							+ response.encodeRedirectURL("/planning"));
				} else if(name=="modify"){
					session.setAttribute("idEvent", id);
					response.sendRedirect(request.getContextPath()+response.encodeRedirectURL("/Educator/ModifyTraining"));				
					}
			} finally {
				sqlSession.close();
			}
			
		}
	}
}
