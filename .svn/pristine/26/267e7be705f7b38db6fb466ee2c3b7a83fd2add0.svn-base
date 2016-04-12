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
 * Servlet implementation class ChargeTeam
 */
@WebServlet("/chargeTrainingSession")
public class ServletChargeTeamTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChargeTeamTrain() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		Training chargeTrain = new Training();
		chargeTrain.setIdEducator(((User) session.getAttribute("user")).getId());
		List<Training> trainingSessions = null;
		try{
			TrainingMapper chargeMapper = sqlSession.getMapper(TrainingMapper.class);
			trainingSessions = chargeMapper.searchTrain(chargeTrain.getIdEducator());
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(trainingSessions.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucune session n'a été trouvée.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			request.setAttribute("sessions", trainingSessions);
			request.getRequestDispatcher("/WEB-INF/JSP/ChargeTrainingSession.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Training chargeTrain = new Training();
		chargeTrain.setIdEducator(((User) session.getAttribute("user")).getId());		
		chargeTrain.setIdEvent(Long.parseLong(request.getParameter("idEventToCharge")));
		chargeTrain.setNbHours(Float.parseFloat(request.getParameter("nbHours")));
		chargeTrain.setHourCost(Float.parseFloat(request.getParameter("hourCost")));
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			TrainingMapper chargeMapper = sqlSession.getMapper(TrainingMapper.class);
			chargeTrain.setNbAttenders(chargeMapper.getNbAttenders(chargeTrain)-1);
			float montant = chargeTrain.getNbHours()*chargeTrain.getHourCost()/chargeTrain.getNbAttenders();
			chargeTrain.setAmountPerAttender(montant);
			for(int i=0; i<chargeTrain.getNbAttenders();i++){
				chargeMapper.chargeTeam(chargeTrain);
			}
			chargeMapper.creditTrainer(chargeTrain);
			chargeMapper.setTrainingToCharged(chargeTrain);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "La séance a été facturée.");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}
}