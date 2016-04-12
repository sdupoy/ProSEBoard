package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;

/**
 * Servlet implementation class ReservationConsultation
 */
@WebServlet("/AcceptConsultationOrTrainingForm")
public class AcceptConsultationOrTrainingForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptConsultationOrTrainingForm() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
					.openSession();
			try {
				EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
				User user = (User) session.getAttribute("user");
				List<Event> eventAll = new ArrayList<Event>();
				eventAll = eventMapper.getAllValidateByUser(user);
				request.setAttribute("eventAll", eventAll);
				request.getRequestDispatcher("/WEB-INF/JSP/ViewRequest.jsp").forward(request, response);
				sqlSession.commit();
			} finally {
				sqlSession.close();
			}
		}
		
	}


}