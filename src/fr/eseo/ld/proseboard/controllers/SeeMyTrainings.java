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

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class SeeMyTrainings
 */
@WebServlet("/SeeMyTrainings")
public class SeeMyTrainings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeMyTrainings() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		
		Long idUser = ((User)session.getAttribute("user")).getId().longValue();
		
		
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
