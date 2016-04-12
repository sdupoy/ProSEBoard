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

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class ServletPayMembers
 */
@WebServlet("/PayMembers")
public class ServletPayMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPayMembers() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		Team team = new Team();
		team.setIdTeamLeader(((User) session.getAttribute("user")).getId());
		List<Team> myTeams = null;
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			myTeams = teamMapper.getTeamByTL(team.getIdTeamLeader());
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(myTeams.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucun membre à rémunérer n'a été trouvé.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			
			request.setAttribute("myTeams", myTeams);
			request.getRequestDispatcher("/WEB-INF/JSP/TeamLeader/PayMembers.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		float nbXtraHours, xtraWage;
		if(request.getParameter("nbXtraHours").isEmpty()){
			nbXtraHours=0;
		}else{
			nbXtraHours=Float.parseFloat(request.getParameter("nbXtraHours"));
		}
		
		if(request.getParameter("xtraWage").isEmpty()){
			xtraWage=0;
		}else{
			xtraWage=Float.parseFloat(request.getParameter("xtraWage"));
		}
		
		Float sum = (Float.parseFloat(request.getParameter("nbRegHours"))*Float.parseFloat(request.getParameter("regWage"))) + (nbXtraHours)*(xtraWage);
		try{
			AccountMapper payMemberMapper = sqlSession.getMapper(AccountMapper.class);
			Account memberAccount = new Account();
			memberAccount.setBalance(sum);
			System.out.println(Long.parseLong(request.getParameter("membAccount")));
			memberAccount.setIdAccount(Long.parseLong(request.getParameter("membAccount")));
			payMemberMapper.creditAccount(memberAccount);
			Account teamAccount = new Account();
			teamAccount.setBalance(sum);
			teamAccount.setIdAccount(Long.parseLong(request.getParameter("teamAccount")));
			payMemberMapper.debitAccount(teamAccount);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		// envoi d'un message pour confirmer?
		session.setAttribute("successMessage", "Ce membre a bien été rémunéré.");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
	}

}
