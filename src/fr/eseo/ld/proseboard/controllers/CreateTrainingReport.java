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

import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class CreateTrainingReport
 */
@WebServlet("/CreateTrainingReport")
public class CreateTrainingReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTrainingReport() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Training> trainings = null;
		try{		
			TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
			trainings = trainingMapper.getByTrainerForReport(((User) session.getAttribute("user")).getId());
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(trainings.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucune session n'a été trouvée.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			request.setAttribute("trainings", trainings);			
			request.getRequestDispatcher("/WEB-INF/JSP/training/createTrainingReport.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

			// Preparation de l'objet à stocker

			Training trainingReport = new Training();
			// Recupération des différents paramètres.
			trainingReport.setIdEvent(Long.parseLong(request.getParameter("idTraining")));
			User user = new User();
			user = (User) session.getAttribute("user");
			trainingReport.setReport(request.getParameter("report"));
			trainingReport.setIdEducator(user.getId());

			try {
				// enregistrement du rapport de training
				TrainingMapper trainingRepMapper = sqlSession.getMapper(TrainingMapper.class);
				trainingRepMapper.updateReport(trainingReport);
				List<User> attendee = trainingRepMapper.getAttenders(trainingReport);
				request.setAttribute("attenders", attendee);
				request.setAttribute("idTraining", Long.parseLong(request.getParameter("idTraining")));
				sqlSession.commit();
			} finally {
				sqlSession.close();
			}
			// redirection vers la page manageTrainingReport
			request.getRequestDispatcher("/WEB-INF/JSP/training/PublishAbsents.jsp").forward(request, response);
		}
		
	}

}
