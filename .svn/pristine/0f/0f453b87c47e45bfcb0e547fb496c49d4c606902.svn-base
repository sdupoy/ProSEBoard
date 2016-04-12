package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class ModifyTraining
 */
@WebServlet("/Educator/ModifyTraining")
public class ModifyTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyTraining() {
		super();
	}


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
				TrainingMapper trainingMapper = sqlSession
						.getMapper(TrainingMapper.class);
				Training currentTraining = new Training();
				long id = (Long) session.getAttribute("idEvent");
				currentTraining = trainingMapper.getByEventId(id);
				Event currentEvent = currentTraining.getEvent();
				request.setAttribute("training", currentTraining);
				request.setAttribute("event", currentEvent);
			} finally {
				sqlSession.close();
			}
		}
		request.getRequestDispatcher("/WEB-INF/JSP/educator/UpdateTraining.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			TrainingMapper trainingMapper = sqlSession
					.getMapper(TrainingMapper.class);
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
			Training currentTraining = new Training();
			Event currentEvent = new Event();
			currentTraining = trainingMapper.getByEventId((long) session
					.getAttribute("idEvent"));
			currentEvent = currentTraining.getEvent();
			String description = (String) request.getParameter("description");
			String ressources = (String) request.getParameter("ressources");
			Float hourCost = Float.parseFloat(request.getParameter("hourCost"));
			Date start = null, end = null;
			String messageError = null;
			try {
				start = sdf.parse(request.getParameter("start"));
				end = sdf.parse(request.getParameter("end"));
			} catch (ParseException p) {
				request.setAttribute(messageError,
						"La date n'est pas au format voulu.");
			}
			trainingMapper.modifyTraining(currentTraining.getId(), description,
					hourCost, ressources);
			currentEvent.setEndDate(end);
			currentEvent.setStartDate(start);
			eventMapper.updateByEducator(currentEvent);


			sqlSession.commit();
		

		} finally {
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Session d'entaînement bien modifiée");
		response.sendRedirect(request.getContextPath()
				+ response.encodeRedirectURL("/"));
	}

}

