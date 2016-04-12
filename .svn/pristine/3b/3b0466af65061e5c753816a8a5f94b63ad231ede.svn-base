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

import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class SeeTeamInfos
 */
@WebServlet("/SeeTeamInfos")
public class SeeTeamInfos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeTeamInfos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Team teamInfos = new Team();
		teamInfos.setIdClient(((User) session.getAttribute("user")).getId());
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Team> teamsToKnowAbout = null;
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			teamsToKnowAbout = teamMapper.getTeamsByClient(teamInfos.getIdClient());		
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		if(teamsToKnowAbout.isEmpty()){
			session.setAttribute("errorMessage", "Erreur, aucune équipe n'a été trouvée.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
		}else{
			request.setAttribute("teams", teamsToKnowAbout);
			request.getRequestDispatcher("/WEB-INF/JSP/seeTeamInfos.jsp").forward(request, response);
		}
		
		
	}


}
