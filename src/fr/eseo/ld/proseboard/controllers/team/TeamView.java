package fr.eseo.ld.proseboard.controllers.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.AccountHistory;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountHistoryMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;

/**
 * Servlet implementation class TeamView
 */
@WebServlet("/team")
public class TeamView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamView() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loggedUser = (User)session.getAttribute("user");
		String[] statuses = {"team_leader", "team_member"};

		Long id = ((User) session.getAttribute("user")).getId();
		Account account;
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
            
			AccountMapper accountTeamMapper = sqlSession.getMapper(AccountMapper.class);
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			Long idAccount = teamMapper.getIdAccountByIdTL(id);
			account = accountTeamMapper.getById(idAccount);
			request.setAttribute("account", account);
			
			AccountHistoryMapper accountHistoryMapper = sqlSession.getMapper(AccountHistoryMapper.class);
			List<AccountHistory> accountHistorys = accountHistoryMapper.getByIdHistory(idAccount);
			request.setAttribute("accountHistorys", accountHistorys);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
			
		
		if(loggedUser.hasStatus(statuses)){
			request.getRequestDispatcher("/WEB-INF/JSP/team/teamview.jsp").forward(request, response);			
		}else{
			session.setAttribute("errorMessage", "Vous n'êtes pas membre d'une équipe.");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));			
		}
		
	}
}
