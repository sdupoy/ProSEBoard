package fr.eseo.ld.proseboard.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet Filter implementation class TeamPopulate
 */
@WebFilter(filterName= "team", urlPatterns = "/*")
public class TeamPopulate implements Filter {

    /**
     * Default constructor. 
     */
    public TeamPopulate() {
    }

	/**
	 * @see Filter#destroy()
	 */
        @Override
	public void destroy() {
	    //Nothing to do because the filter does not create any useless data 
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		User loggedUser = (User)session.getAttribute("user");
		Team team = null;
		String[] statuses = {"team_leader", "team_member"};
		if(loggedUser != null && (loggedUser.hasStatus(statuses))){
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			try{
				TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
				team = teamMapper.getUserTeam(loggedUser);
			}finally{
				sqlSession.close();
			}
			session.setAttribute("team", team);
		}
		if(team != null){
			org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TeamPopulate.class);
			logger.debug(team.getTeamName());			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	    //No configuration necessary
	}

}
