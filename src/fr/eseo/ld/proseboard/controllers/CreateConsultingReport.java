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

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class CreateConsultingReport
 */
@WebServlet("/consultation/creer")
public class CreateConsultingReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateConsultingReport() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			List<Team> teams = teamMapper.getAllTeam();
			request.setAttribute("teams", teams);
			
			SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
			List<Session> sessions = sessionMapper.getAllSaufEnd();
			request.setAttribute("sessions", sessions);
			
			ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
			List<Consulting> consults = consultingMapper.getByConsultantForReport(((User) session.getAttribute("user")).getId());
			request.setAttribute("consults", consults);
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/consulting/createConsulting.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

			// Preparation de l'objet à stocker

			Consulting consultReport = new Consulting();
			
			// Recupération des différents paramètres.
			consultReport.setId(Long.parseLong(request.getParameter("idConsult")));
			User user = new User();
			user = (User) session.getAttribute("user");
			consultReport.setReport(request.getParameter("report"));
			consultReport.setIdConsultant(user.getId());

			try {
				// enregistrement du rapport de consulting
				ConsultingMapper consultingRepMapper = sqlSession.getMapper(ConsultingMapper.class);
				consultingRepMapper.updateReport(consultReport);
				sqlSession.commit();
			} finally {
				sqlSession.close();
			}
			// redirection vers la page manageConsultingReport
			response.sendRedirect(request.getContextPath()+ response.encodeRedirectURL("/consultation/manager"));
		}
	}
}
