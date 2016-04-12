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
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class ReservationConsultation
 */
@WebServlet("/TeamLeader/ValidateConsultationOrTrainingForm")
public class ValidateConsultationOrTrainingForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateConsultationOrTrainingForm() {
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
				EventMapper eventMapper = sqlSession
						.getMapper(EventMapper.class);
				TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
				User user = (User) session.getAttribute("user");
				Team team = teamMapper.getUserTeam(user);
				List<User> userTeam = team.getMembers();
				List<Event> eventAll = new ArrayList<Event>();
				for (User currentUser : userTeam) {
					List<Event> eventUser = eventMapper
							.getAllForCreator(currentUser.getId());
					for (Event currentEvent : eventUser) {
						eventAll.add(currentEvent);
					}
				}
				request.setAttribute("eventAll", eventAll);
				request.getRequestDispatcher(
						"/WEB-INF/JSP/TeamLeader/ViewReservation.jsp").forward(
						request, response);
			} finally {
				sqlSession.close();
			}
		}
	}
}