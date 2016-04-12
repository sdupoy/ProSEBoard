package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class VoirRequetesEquipe
 */
@WebServlet("/VoirRequetesEquipe")
public class VoirRequetesEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirRequetesEquipe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			List <Team> teams = teamMapper.getAll();
			request.setAttribute("teams", teams);
			
			SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
			List <Session> sessions = sessionMapper.getAllSaufEnd();
			request.setAttribute("sessions", sessions);
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/VoirRequetesEquipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long id = Long.parseLong(request.getParameter("idTeam"));
		try{
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
			List <Event> events = eventMapper.getAllForCreator(id);
			request.setAttribute("events", events);

			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/VoirRequetesEquipe2.jsp").forward(request, response);
		
		
		
		
	}

}
