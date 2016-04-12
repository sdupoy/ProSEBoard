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
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;

/**
 * Servlet implementation class ServletPublierAudit
 */
@WebServlet("/ServletPublierAudit")
public class ServletPublierAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPublierAudit() {
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
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/ListeAuditNonPublies.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Integer.parseInt(request.getParameter("id"));
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			auditReportMapper.publicate(id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ServletPublierAudit"));
	}

}
