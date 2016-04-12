package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class AfficherContrat
 */
@WebServlet("/AfficherContrat")
public class AfficherContrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherContrat() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long idTeam = Long.parseLong(request.getParameter("id"));
		Long idUser = ((User)session.getAttribute("user")).getId();
		
		
		try{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.getById(idUser);
			
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			Team team = teamMapper.getTeamById(idTeam);
			
			SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
			Session sess = sessionMapper.getSessionById(team.getIdSession());
			
			request.setAttribute("user", user);
			request.setAttribute("team", team);
			request.setAttribute("sess", sess);
			
			
			
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/AfficherContrat.jsp").forward(request, response);
	}


}
