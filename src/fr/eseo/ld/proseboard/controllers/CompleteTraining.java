package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class UpdateTraining
 */
@WebServlet("/training/CompleteTraining")
public class CompleteTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteTraining() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			response.sendRedirect(request.getContextPath()+response.encodeRedirectURL("/login"));
		}else{ 
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			try{
				TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
				Training training = new Training();
				long id = (Long) session.getAttribute("idEvent");
				training = trainingMapper.getByEventId(id);
				request.setAttribute("training", training);
				request.getRequestDispatcher("/WEB-INF/JSP/educator/CompleteTraining.jsp").forward(request, response);
			}finally{
				sqlSession.close();
			}
		}
		
		response.sendRedirect(request.getContextPath()+response.encodeRedirectURL("/training/CompleteTraining"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		}else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
			try{
				long idEvent = (Long) session.getAttribute("idEvent");
				String ressources = (String)request.getParameter("ressources");
				Float hourCost = Float.parseFloat(request.getParameter("hourCost"));
				trainingMapper.updateRessourcesAndHourCost(idEvent, ressources, hourCost);
				sqlSession.commit();
			}finally{
				sqlSession.close();
			}
		}
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/planning"));
	}

}
