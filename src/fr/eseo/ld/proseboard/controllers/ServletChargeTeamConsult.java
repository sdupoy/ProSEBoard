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

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;

/**
 * Servlet implementation class ChargeTeam
 */
@WebServlet("/chargeConsultingSession")
public class ServletChargeTeamConsult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChargeTeamConsult() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		Consulting chargeConsult = new Consulting();
		chargeConsult.setIdConsultant(((User) session.getAttribute("user")).getId());
		List<Consulting> consultingSessions = null;
		try{
			ConsultingMapper chargeMapper = sqlSession.getMapper(ConsultingMapper.class);
			consultingSessions = chargeMapper.searchConsult(chargeConsult.getIdConsultant());
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(consultingSessions.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucune session n'a été trouvée.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			request.setAttribute("sessions", consultingSessions);
			request.getRequestDispatcher("/WEB-INF/JSP/ChargeConsultingSession.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Consulting chargeConsult = new Consulting();
		chargeConsult.setIdConsultant(((User) session.getAttribute("user")).getId());
		chargeConsult.setId(Long.parseLong(request.getParameter("idSessionToCharge")));
		chargeConsult.setNbHours(Float.parseFloat(request.getParameter("nbSpentHours")));
		chargeConsult.setHourCost(Float.parseFloat(request.getParameter("hourCost")));
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			ConsultingMapper chargeMapper = sqlSession.getMapper(ConsultingMapper.class);
			chargeMapper.chargeTeam(chargeConsult);
			chargeMapper.creditConsultant(chargeConsult);
			chargeMapper.setConsultToCharged(chargeConsult);
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "La séance a été facturée.");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}
}