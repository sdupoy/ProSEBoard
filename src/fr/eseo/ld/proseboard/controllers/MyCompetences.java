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

import fr.eseo.ld.proseboard.models.Expertise;
import fr.eseo.ld.proseboard.models.ExpertiseArea;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ExpertiseMapper;

/**
 * Servlet implementation class MyCompetences
 */
@WebServlet("/MyCompetences")
public class MyCompetences extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCompetences() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();

		long id = ((User)session.getAttribute("user")).getId().longValue();
		try{
			ExpertiseMapper expertiseMapper = sqlSession.getMapper(ExpertiseMapper.class);
			List<Expertise> expertise = expertiseMapper.getByIdUser2(id);
			List<ExpertiseArea> expertiseArea = null;
			if(!expertise.isEmpty()){
				expertiseArea = expertiseMapper.getAllByExp(expertise);
			}
			request.setAttribute("expertises", expertiseArea);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/MyCompetences.jsp").forward(request, response);
	}


}
