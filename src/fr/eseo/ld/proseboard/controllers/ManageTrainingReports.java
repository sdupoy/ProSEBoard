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

import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class ManageTrainingReports
 */
@WebServlet("/training/manager")
public class ManageTrainingReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageTrainingReports() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()+response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			try {
				TrainingMapper trainingReportMapper = sqlSession.getMapper(TrainingMapper.class);
				List<Training> trainings = trainingReportMapper.getAllBis(); //allwithusers?
				request.setAttribute("training", trainings);				
			} finally {
				sqlSession.close();
			}
			request.setAttribute("id", ((User) session.getAttribute("user")).getId());				
			request.getRequestDispatcher("/WEB-INF/JSP/training/manageTrainingReports.jsp").forward(request, response);
		
		}
	}


}
