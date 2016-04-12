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


@WebServlet("/ManageTeams")
public class ManageTeams extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ManageTeams() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
		Long id = new Long(request.getParameter("idSession"));
		try{
		    List<Team> list = teamMapper.getTeamsFromSession(id);
		    request.setAttribute("teams", list);
		    request.setAttribute("sessionName", sessionMapper.getSessionById(id).getName());
		}finally{
		    sqlSession.close();
		}
		request.setAttribute("idSession", id);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageTeams.jsp").forward(request, response);
	}
}
