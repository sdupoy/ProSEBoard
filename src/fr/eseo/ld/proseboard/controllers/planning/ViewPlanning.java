package fr.eseo.ld.proseboard.controllers.planning;

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
import fr.eseo.ld.proseboard.models.RedmineEvent;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtilRedmine;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.RedmineEventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class View
 */
@WebServlet("/planning")
public class ViewPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPlanning() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		SqlSession redmineSqlSession = MyBatisUtilRedmine.getSqlSessionFactory().openSession();
		Long idUser = null;
		try{
			idUser = Long.valueOf(request.getParameter("user"));
		}catch(NumberFormatException e){
			idUser = null;
		}
		User user = null, loggedUser = (User)session.getAttribute("user");
		if(idUser == null){
			user = loggedUser;
		}else{
			if(!loggedUser.hasPermission("see_team_planning")){
				session.setAttribute("errorMessage", "Vous ne pouvez pas consulter le planning des autres utilisateurs.");
				response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
				return;
			}
			Team team = (Team)session.getAttribute("team");
			user = new User();
			user.setId(idUser);
			if(!team.hasUser(user)){
				session.setAttribute("errorMessage", "Vous n'avez pas le droit de consulter le planning de cet utilisateur.");
				response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
			}
		}
		try{
			if(user != loggedUser){
				user = sqlSession.getMapper(UserMapper.class).getById(user.getId());
			}
			List<RedmineEvent> redmineEvents = redmineSqlSession.getMapper(RedmineEventMapper.class).getAllForUser(user);
			List<Event> events = sqlSession.getMapper(EventMapper.class).getAllForUser(user);
			request.setAttribute("events", events);
			request.setAttribute("redmineEvents", redmineEvents);
			request.setAttribute("owner", user);
			request.getRequestDispatcher("/WEB-INF/JSP/planning/viewplanning.jsp").forward(request, response);
		}finally{
			sqlSession.close();
			redmineSqlSession.close();
		}
	}
}
