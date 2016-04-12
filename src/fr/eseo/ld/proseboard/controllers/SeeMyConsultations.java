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
import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;

/**
 * Servlet implementation class SeeMyConsultations
 */
@WebServlet("/SeeMyConsultations")
public class SeeMyConsultations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeeMyConsultations() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		
		Long idUser = ((User)session.getAttribute("user")).getId().longValue();
		
		
		try{
			TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
			List <TeamUser> teamUser = teamUserMapper.getTeamUserByUserId(idUser);
			
			ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
			List <Consulting> consultings = consultingMapper.getConsByIdTeam(teamUser);
			
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
			List <Event> events = eventMapper.getEventByIdConsultings(consultings);
			
			request.setAttribute("consultings", consultings);
			request.setAttribute("events", events);
	
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/SeeMyConsultations.jsp").forward(request, response);
	}

}