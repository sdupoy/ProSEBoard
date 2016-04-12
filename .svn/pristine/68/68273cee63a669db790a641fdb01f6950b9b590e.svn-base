package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;

/**
 * Servlet implementation class ManageConsultingReport
 */
@WebServlet("/consultation/manager")
public class ManageConsultingReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageConsultingReport() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()+response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			try {
				ConsultingMapper consultingReportMapper = sqlSession.getMapper(ConsultingMapper.class);
				request.setAttribute("consulting", consultingReportMapper.getAllWithUsers());
				request.setAttribute("id", ((User) session.getAttribute("user")).getId());
				request.getRequestDispatcher("/WEB-INF/JSP/consulting/manageConsulting.jsp").forward(request, response);
			} finally {
				sqlSession.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
	}

}
