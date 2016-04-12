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
import fr.eseo.ld.proseboard.models.Expertise;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.ExpertiseMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class CreateTraining
 */
@WebServlet("/Educator/CreateTraining")
public class CreateTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTraining() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		} else {	
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
					.openSession();
			try {
				User user = (User) session.getAttribute("user");
				ExpertiseMapper expertiseMapper = sqlSession.getMapper(ExpertiseMapper.class);
				List<Expertise> expertiseTeacher = expertiseMapper.getByIdUser(user);
				request.setAttribute("expertiseTeacher", expertiseTeacher);
				request.getRequestDispatcher("/WEB-INF/JSP/educator/CreateTraining.jsp").forward(request, response);
			} finally {
				sqlSession.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean validateFailed = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
		ExpertiseMapper expertiseMapper = sqlSession.getMapper(ExpertiseMapper.class);
		TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
		// PrÃ©paration de l'objet Ã  stocker
		User user = (User) session.getAttribute("user");
		String description = new String();
		Date start = null, end = null;
		String messageError = "errorMessage";
		try {
			start = sdf.parse(request.getParameter("start"));
			end = sdf.parse(request.getParameter("end"));
		} catch (ParseException e1) {
			request.setAttribute(messageError,
					"La date n'est pas au format voulu.");
			validateFailed = true;
		}	
		if (!user.isAvailable(start, end)) {
			request.setAttribute(
					messageError,
					"L'utilisateur "
							+ user.getFirstName()
							+ " "
							+ user.getLastName()
							+ " n'est pas disponible sur cette tranche horaire.");
			validateFailed = true;
		}
		if (start.after(end) || start.equals(end)) {
			request.setAttribute(messageError,
					"La date de fin est avant la date de dÃ©but.");
			validateFailed = true;
		}
		if (validateFailed) {
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/JSP/educator/CreateTraining.jsp")
			.forward(request, response);
			return;
		}
		
		long validation = 0;
		description = request.getParameter("description");
		Long idExpertise = Long.valueOf(request.getParameter("idExpertise"));
		String subject = expertiseMapper.getById(idExpertise).getName();
		String ressources = request.getParameter("ressources");
		float hourCost = Float.valueOf(request.getParameter("idExpertise"));
		boolean isCharged = false;
		
		Event event = new Event();
		event.setName("Training " + start);
		event.setStartDate(start);
		event.setEndDate(end);
		event.setIdCreator(user.getId());
		event.setDescription(description);
		event.setValidation(validation);
		event.setType("default");
		
		Training training = new Training(user.getId(), subject, isCharged, ressources, hourCost);
		
		try {
			eventMapper.insertEvent(event);
			eventMapper.bindEventToUser(event, user);
			training.setIdEvent(event.getId());
			training.setIdEducator(event.getIdCreator());
			trainingMapper.insertTrainingPartial(training);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}		

		response.sendRedirect(request.getContextPath()
				+ response.encodeRedirectURL("/planning"));
	}

}
