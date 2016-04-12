package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AuditReportMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.StatusUserMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;

@WebServlet("/DeleteSession")
public class DeleteSession extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public DeleteSession() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
		Long id = new Long(request.getParameter("idSession"));
		request.setAttribute("sessionName", sessionMapper.getSessionById(id).getName());
		request.setAttribute("sessionId", id);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/DeleteSession.jsp").forward(request, response);
		sqlSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
		AuditReportMapper auditMapper = sqlSession.getMapper(AuditReportMapper.class);
		ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
		StatusUserMapper statusUserMapper = sqlSession.getMapper(StatusUserMapper.class);
		
		Long id = new Long(request.getParameter("delete"));
		statusUserMapper.deleteBySessionId(id);
		teamUserMapper.deleteTeamUserBySessionId(id);
		auditMapper.deleteAuditsBySessionId(id);
		consultingMapper.deleteConsultingBySessionId(id);
		teamMapper.deleteTeamsAndAccountsBySessionId(id);
		sessionMapper.deleteSessionById(id);
		sqlSession.commit();
		List<Session> list = sessionMapper.getAll();
		request.setAttribute("sessions", list);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageSessions.jsp").forward(request, response);
		sqlSession.close();
	}

}