package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;


/**
 * Servlet implementation class ServletPublishAccountTeam
 */
@WebServlet("/ServletPublishAccountTeam")
public class ServletPublishAccountTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPublishAccountTeam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
            //récup toutes les sessions
			SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
			List<Session> sessionAll = new ArrayList<Session>();
			sessionAll = sessionMapper.getAllSession();		
			request.setAttribute("sessionAll", sessionAll);
			
			//récup toutes les teams
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			List<Team> teamAll = new ArrayList<Team>();
			teamAll = teamMapper.getAllTeam();
			request.setAttribute("teamAll", teamAll);
			
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/PublishAccountTeam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//récup la team choisi
		Long idTeam = Long.parseLong(request.getParameter("Team"));
		
		Account account = null;
		Team team = new Team();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			
			//récup les infos de compte en fct de l'équipe choisi
			AccountMapper accountTeamMapper = sqlSession.getMapper(AccountMapper.class);
			account = accountTeamMapper.getByIdTeam(idTeam);
			
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			team = teamMapper.getTeamById(idTeam);
			
		}finally{
			sqlSession.close();
		}
		
		//balance le résultat
		String teamName = new String();
		String project = new String();
		teamName = team.getTeamName();
		project = team.getProjectName();
		request.setAttribute("account", account);
		request.setAttribute("teamName", teamName);
		request.setAttribute("project", project);
		request.getRequestDispatcher("/WEB-INF/JSP/ValidPublishAccountTeam.jsp").forward(request, response);
	}
}