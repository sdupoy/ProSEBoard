package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class SeeTraining
 */
@WebServlet("/TeamMember/SeeTraining")
public class SeeTraining extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeTraining() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
        } else {
            try{
                TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
                Date date = new Date(); 
                List <Training> allTraining = trainingMapper.getAllTrainingAfterValidate(date);				
                request.setAttribute("allTraining", allTraining);
            }finally{
                sqlSession.close();
            }
            request.getRequestDispatcher("/WEB-INF/JSP/training/ListTrainingComing.jsp").forward(request, response);
        }
    }
}
