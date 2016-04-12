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

import fr.eseo.ld.proseboard.models.PayTeam;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.PayTeamMapper;

/**
 * Servlet implementation class PayTeam
 */
@WebServlet("/payTeam")
public class ServletPayTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPayTeam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		PayTeam payTeam = new PayTeam();
		payTeam.setIdClient(((User) session.getAttribute("user")).getId());
		List<Team> teamsToPay = null;
		try{
			PayTeamMapper payMapper = sqlSession.getMapper(PayTeamMapper.class);
			teamsToPay = payMapper.searchTeamsToPay(payTeam.getIdClient());
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(teamsToPay.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucune équipe à rémunérer n'a été trouvée.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			request.setAttribute("teams", teamsToPay);
			request.getRequestDispatcher("/WEB-INF/JSP/PayTeam.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PayTeam payTeam = new PayTeam();
		payTeam.setIdClient(((User) session.getAttribute("user")).getId());
		payTeam.setIdTeam(Long.parseLong(request.getParameter("idTeamToPay")));
		payTeam.setAmount(Integer.parseInt(request.getParameter("amount")));
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PayTeamMapper payMapper = sqlSession.getMapper(PayTeamMapper.class);
			payMapper.creditTeam(payTeam);
			payMapper.debitClient(payTeam);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		// envoi d'un message pour confirmer?
		session.setAttribute("successMessage", "L'équipe a bien été rémunérée.");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}

}
