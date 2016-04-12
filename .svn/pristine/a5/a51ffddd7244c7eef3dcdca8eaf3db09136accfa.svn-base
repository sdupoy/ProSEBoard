package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.AuditReport;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;

/**
 * Servlet implementation class ServletModifierAudit
 */
@WebServlet("/ServletModifierAudit")
public class ServletModifierAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierAudit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Long idTeam = Long.parseLong(request.getParameter("idTeam"));
		request.setAttribute("id", id);
		request.setAttribute("idTeam", idTeam);
		request.getRequestDispatcher("/WEB-INF/JSP/ModifierAudit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Long idTeam = Long.parseLong(request.getParameter("idTeam"));
		double note = Double.parseDouble(request.getParameter("note"));
		int color1 = Integer.parseInt(request.getParameter("color1"));
		int color2 = Integer.parseInt(request.getParameter("color2"));
		int color3 = Integer.parseInt(request.getParameter("color3"));
		int finalColor = Integer.parseInt(request.getParameter("final_color"));
		String report = request.getParameter("report");
		String comment = request.getParameter("comment");
		AuditReport auditReport = new AuditReport(id, note, idTeam, report, comment, color1, color2, color3, finalColor, 0);
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			auditReportMapper.update(auditReport);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ServletPublierAudit"));
	}

}
