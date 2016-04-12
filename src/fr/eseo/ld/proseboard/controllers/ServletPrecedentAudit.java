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
 * Servlet implementation class ServletPrecedentAudit
 */
@WebServlet("/ServletPrecedentAudit")
public class ServletPrecedentAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrecedentAudit() {
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
		request.getRequestDispatcher("/WEB-INF/JSP/VoirAuditPrecedent.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idTeam = Long.parseLong(request.getParameter("idTeam"));
		request.setAttribute("idTeam2", idTeam);
		int auditsNull;
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			
			List <AuditReport> audits = null;
			audits = auditReportMapper.getByIdTeam(idTeam);
			if(audits.isEmpty() == true){
				auditsNull =0;
			}else{
				auditsNull =1;
			}
			
			request.setAttribute("audits", audits);
			request.setAttribute("auditsNull", auditsNull);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/VoirAuditPrecedent2.jsp").forward(request, response);
		
	}

	
	
}
