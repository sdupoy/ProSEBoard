package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class SeeTrainings
 */
@WebServlet("/SeeTrainings")
public class SeeTrainings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeTrainings() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();		
		Long idUser = Long.parseLong(request.getParameter("user"));
		
		try{
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
			TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
			try{
			
				List <Event> events = eventMapper.getAllEventByIdEventUser(idUser);
				List <Training> trainings = trainingMapper.getTrainByIdEvent(events);
				request.setAttribute("trainings", trainings);
				request.setAttribute("events", events);
			}catch(Exception e){
				
			}
			try{
				List <Event> events2 = eventMapper.getAllEventByIdEventUser2(idUser);
				List <Training> trainings2 = trainingMapper.getTrainByIdEvent(events2);
				request.setAttribute("trainings2", trainings2);
				request.setAttribute("events2", events2);
			}catch(Exception e){
				
			}
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/SeeMyTrainings.jsp").forward(request, response);
	}


}
