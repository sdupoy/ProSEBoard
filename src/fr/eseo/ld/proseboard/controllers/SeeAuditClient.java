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
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class SeeAuditClient
 */
@WebServlet("/SeeAuditClient")
public class SeeAuditClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeAuditClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		
		Long idClient = ((User)session.getAttribute("user")).getId().longValue();
		Long idSession;
		
		
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			idSession =  teamMapper.getSessionMax();
			List<Team> team = teamMapper.getTeamsFromAuditor(idClient,idSession);
			
			List<AuditReport> audits = null;
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			if(!team.isEmpty()){
				audits = auditReportMapper.getAllByTeams2(team);
			}
			request.setAttribute("audits", audits);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/SeeAuditClient.jsp").forward(request, response);
	}


}
