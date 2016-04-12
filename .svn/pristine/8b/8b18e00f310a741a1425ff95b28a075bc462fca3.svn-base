package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;

@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public DeleteTeam() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = new Long(request.getParameter("idTeam"));
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		Team team = teamMapper.getTeamById(id);
		request.setAttribute("team", team);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/DeleteTeam.jsp").forward(request, response);
		sqlSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = new Long(request.getParameter("idTeam"));
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
		TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
		
		Team team = teamMapper.getTeamById(id);
		Long idSession = team.getIdSession();
		
		teamUserMapper.deleteTeamUserByTeamId(team.getId());
		teamMapper.deleteTeamById(id);
		sessionMapper.decrementNbTeamById(idSession);
		sqlSession.commit();

		List<Team> list = teamMapper.getTeamsFromSession(idSession);
		request.setAttribute("sessionName",sessionMapper.getSessionById(idSession).getName());
		request.setAttribute("teams", list);
		request.setAttribute("idSession",idSession);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageTeams.jsp").forward(request, response);
		sqlSession.close();
	}

}