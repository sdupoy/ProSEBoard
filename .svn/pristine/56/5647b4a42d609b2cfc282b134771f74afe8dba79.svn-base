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
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;

@WebServlet("/ManageSessions")
public class ManageSessions extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ManageSessions() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
		List<Session> list = sessionMapper.getAllAdmin();
		request.setAttribute("sessions", list);
		request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageSessions.jsp").forward(request, response);
		sqlSession.close();
	}
}
