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
 * Servlet implementation class ServletVoirAudit
 */
@WebServlet("/ServletVoirAudit")
public class ServletVoirAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVoirAudit() {
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
		request.getRequestDispatcher("/WEB-INF/JSP/ListeAuditPublies.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		int order = Integer.parseInt(request.getParameter("order"));
		List <AuditReport> audits;
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			
			if(order==1){
				audits = auditReportMapper.getAllOrderByDate();
			}else if(order==2){
				audits = auditReportMapper.getAllOrderByEquipe();
			}else if(order==3){
				audits = auditReportMapper.getAllOrderByFond();
			}else if(order==4){
				audits = auditReportMapper.getAllOrderByForme();
			}else if(order==5){
				audits = auditReportMapper.getAllOrderByAttitude();
			}else if(order==6){
				audits = auditReportMapper.getAllOrderByCouleur();
			}else{
				audits = auditReportMapper.getAllOrderByNote();
			}
			
			request.setAttribute("audits", audits);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/ListeAuditPublies.jsp").forward(request, response);
	}
	
}
