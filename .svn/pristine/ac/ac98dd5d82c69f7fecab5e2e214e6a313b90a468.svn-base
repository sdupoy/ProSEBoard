package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;

/**
 * Servlet implementation class SeeConsultings
 */
@WebServlet("/SeeConsultings")
public class SeeConsultings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeeConsultings() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long idUser = Long.parseLong(request.getParameter("user"));
		
		
		TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
		List<TeamUser> teamUser = teamUserMapper.getTeamUserByUserId(idUser);
		
		List<Consulting> consultings = null;
		ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
		consultings = consultingMapper.getConsByIdTeam(teamUser);
		
		
		EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
		List <Event> events = eventMapper.getEventByIdConsultings(consultings);
			
		
		
		request.setAttribute("consultings", consultings);
		request.setAttribute("events", events);
		request.getRequestDispatcher("/WEB-INF/JSP/SeeConsultings.jsp").forward(request, response);
	}

}
