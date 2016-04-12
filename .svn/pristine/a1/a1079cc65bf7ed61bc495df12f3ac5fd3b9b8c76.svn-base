package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Notification;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.NotificationMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class PlanifierAudit
 */
@WebServlet("/PlanifierAudit")
public class PlanifierAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanifierAudit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
					.openSession();
			try {
				TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
				SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
				Session sess;
				sess = sessionMapper.getLastSession();
				List<Team> teams = teamMapper.getTeamsFromSession(sess.getId());
				request.setAttribute("teams", teams);
			} finally {
				sqlSession.close();
			}
	
		
		request.getRequestDispatcher("/WEB-INF/JSP/PlanifierAudit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		User user = (User) session.getAttribute("user");
		Long idTeam = Long.parseLong(request.getParameter("idTeam"));
		Date start = null, end = null;
		String messageError = "errorMessage";
		try {
			start = sdf.parse(request.getParameter("start"));
			end = sdf.parse(request.getParameter("end"));
		} catch (ParseException e1) {
			request.setAttribute(messageError,
					"La date n'est pas au format voulu.");
		}
		Event event = new Event();
		EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		NotificationMapper notificationMapper = sqlSession.getMapper(NotificationMapper.class);
		event.setName("Audit");
		event.setDescription(user.getFirstName());
		event.setStartDate(start);
		event.setEndDate(end);
		event.setType("audit");
		event.setIdCreator(user.getId());
		
		Notification notification = new Notification();
		notification.setType("audit_application");
		
		try {
		
			
			
			eventMapper.insertEvent(event);
			
			notification.setIdObject(eventMapper.getLastId());
			notification.setIdUser(teamMapper.getIdTLByIdTeam(idTeam));
			notificationMapper.addNotification(notification);
			
			List<User> userTeam = teamMapper.getById2(idTeam);
			eventMapper.bindEventToUser(event, user);
			for(int i = 0; i<userTeam.size(); i++) {
				eventMapper.bindEventToUser(event, userTeam.get(i));
			}
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Audit planifié");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}

}
