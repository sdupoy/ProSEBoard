package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
 * Servlet implementation class ServletAuditReport
 */
@WebServlet("/audit/creer")
public class ServletAuditReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuditReport() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		Long idSess;
		
		
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			idSess = auditReportMapper.getMaxIdSess2();
			
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			List<Team> teams = teamMapper.getTeamsFromSession(idSess);
			request.setAttribute("teams", teams);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
		
		
		User user = (User) session.getAttribute("user");
		if(user == null){
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
		}else if(!user.hasPermission("create_audit")){
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{	
			request.getRequestDispatcher("/WEB-INF/JSP/WelcomeAuditor.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		AuditReport audit = new AuditReport();
		audit.setIdTeam(Long.parseLong(request.getParameter("idTeam")));
		audit.setNote(Double.parseDouble(request.getParameter("note")));
		audit.setReport(request.getParameter("report"));
		audit.setComment(request.getParameter("comment"));
		audit.setColor1(Integer.parseInt(request.getParameter("color1")));
		audit.setColor2(Integer.parseInt(request.getParameter("color2")));
		audit.setColor3(Integer.parseInt(request.getParameter("color3")));
		audit.setFinalColor(Integer.parseInt(request.getParameter("final_color")));
		audit.setIdAuditor(((User)session.getAttribute("user")).getId());
		audit.setDate(new Date((Calendar.getInstance()).getTimeInMillis()));
		
		//La validation passe, on se prépare à enregistrer en base de données
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			//Enregistrement du nouvel audit
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			auditReportMapper.insert(audit);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Audit enregistré avec succès");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));

	}

}
