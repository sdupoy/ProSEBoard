package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.AuditReport;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class CompareAudits
 */
@WebServlet("/CompareAudits")
public class CompareAudits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompareAudits() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			List <AuditReport> audits = auditReportMapper.getAll();
			request.setAttribute("audits", audits);
			
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
		request.getRequestDispatcher("/WEB-INF/JSP/CompareAudits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idAudits = Long.parseLong(request.getParameter("idAudit"));
		Long idAudits2 = Long.parseLong(request.getParameter("idAudit2"));
		Long idTeam = Long.parseLong(request.getParameter("idTeam"));
		Long idTeam2 = Long.parseLong(request.getParameter("idTeam2"));
		
		Long color1;
		Long color2;
		
		request.setAttribute("idTeam", idTeam);
		request.setAttribute("idTeam2", idTeam2);
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			
			AuditReport audits1 = auditReportMapper.getById(idAudits);
			AuditReport audits2 = auditReportMapper.getById(idAudits2);
			request.setAttribute("audit", audits1);
			request.setAttribute("audit2", audits2);
			sqlSession.commit();
			color1 = auditReportMapper.getFinalColor(idAudits);
			color2 = auditReportMapper.getFinalColor(idAudits2);
			request.setAttribute("color1", color1);
			request.setAttribute("color2", color2);
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/CompareAudits2.jsp").forward(request, response);
	}

}
