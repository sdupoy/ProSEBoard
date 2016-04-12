package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;

/**
 * Servlet implementation class ServletSelectionPublierAudit
 */
@WebServlet("/ServletSelectionPublierAudit")
public class ServletSelectionPublierAudit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSelectionPublierAudit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/JSP/SelectionPublierAudit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		int publi = Integer.parseInt(request.getParameter("publicate"));
		
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			AuditReportMapper auditReportMapper = sqlSession.getMapper(AuditReportMapper.class);
			if(publi == 2){
				auditReportMapper.publicate2(id);
			}else if(publi == 3){
				auditReportMapper.publicate3(id);
			}else if(publi == 4){
				auditReportMapper.publicate4(id);
			}
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ServletPublierAudit"));
	}

}
