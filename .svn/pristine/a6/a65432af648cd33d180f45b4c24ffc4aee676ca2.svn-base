package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Expertise;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ExpertiseMapper;

/**
 * Servlet implementation class NewCompetences
 */
@WebServlet("/NewCompetences")
public class NewCompetences extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCompetences() {
        super();

    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/JSP/NewCompetences.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		long id = Integer.parseInt(request.getParameter("id"));
		String competence = request.getParameter("comp");
		
		try{
			
			ExpertiseMapper expertiseMapper = sqlSession.getMapper(ExpertiseMapper.class);
			
			Expertise expertise = new Expertise();
			expertise.setName(competence);
			expertise.setIdUser(id);
			
			expertiseMapper.insert(expertise);
			Long idExp = expertiseMapper.getIdExpByNameExp(competence);
			expertise.setIdExp(idExp);
			expertiseMapper.insert2(expertise);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Nouvelle compétence ajoutée");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/Competences"));
		
		
	}

}
