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
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;

/**
 * Servlet implementation class SeeMyAudits
 */
@WebServlet("/SeeMyAudits")
public class SeeMyAudits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeMyAudits() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		Long id = ((User)session.getAttribute("user")).getId();
		Long team1 = 0L;
		Long team2 = 0L;
		Long team3 = 0L;
		
		
		try{
			TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
			team1 = teamUserMapper.idTeamPrevious(id);
			team2 = teamUserMapper.idTeamCurrent(id);
			team3 = team2;
			
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			List <AuditReport> audits = auditReportMapper.getByIdTeam(team1);
			request.setAttribute("audits", audits);
			
			if(team1!=team2){
				List <AuditReport> audits2 = auditReportMapper.getByIdTeam(team2);
				request.setAttribute("audits2", audits2);
				
				
			}else{
				try{
				team2 = teamMapper.getIdTeamPrevious(id);
				if(team2 != team3){
        				List <AuditReport> audits2 = auditReportMapper.getByIdTeam(team2);
        				request.setAttribute("audits2", audits2);
        				
				}
				}catch(Exception e){
					// L'élève n'a pas redoublé dans ce cas
				}
				
			}
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/SeeMyAudits.jsp").forward(request, response);
	}


}
