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

import fr.eseo.ld.proseboard.models.AuditReport;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class SeeAuditsTL
 */
@WebServlet("/SeeAuditsTL")
public class SeeAuditsTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeeAuditsTL() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long id = ((User)session.getAttribute("user")).getId();
		Long idTeam;

		String choix = (String) request.getParameter("choix");
		try{
			
			TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
			idTeam = teamUserMapper.idTeamCurrent(id);
			List <TeamUser> teamUser = teamUserMapper.getTeamUserByIdTeam(idTeam);
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> users = userMapper.getAllByIdUsers(teamUser);
			request.setAttribute("users", users);
			request.setAttribute("idTL",id);
			choix = choix.intern();
			request.setAttribute("choix",choix);
			request.getRequestDispatcher("/WEB-INF/JSP/SeeAuditsTL.jsp").forward(request, response);
			
		}finally{
			sqlSession.close();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long idUser = Long.parseLong(request.getParameter("user"));
		
		
		TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
		List<TeamUser> teamUser = teamUserMapper.getTeamUserByUserId(idUser);
		
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		List<Team> team = teamMapper.getAllTeamsByTeamUsers(teamUser);

		
		List<AuditReport> audits = null;
		AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
		if(!team.isEmpty()){
			audits = auditReportMapper.getAllByTeams(team);
		}
		
		request.setAttribute("audits", audits);
		request.getRequestDispatcher("/WEB-INF/JSP/SeeAuditsTL2.jsp").forward(request, response);
		
	}

}