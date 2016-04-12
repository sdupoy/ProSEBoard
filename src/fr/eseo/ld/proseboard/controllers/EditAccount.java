package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;


/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccountTeam")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long id = ((User) session.getAttribute("user")).getId();
		Account account;
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
            
			AccountMapper accountTeamMapper = sqlSession.getMapper(AccountMapper.class);
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			Long idAccount = teamMapper.getIdAccountByIdTL(id);
			account = accountTeamMapper.getById(idAccount);
			request.setAttribute("account", account);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
			request.getRequestDispatcher("/WEB-INF/JSP/EditAccountTeam.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		int balance = Integer.parseInt(request.getParameter("balance"));
		Long id = ((User) session.getAttribute("user")).getId();
		
		
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			Long idAccount = teamMapper.getIdAccountByIdTL(id);
		
			Account account = new Account(balance,idAccount);
			
			AccountMapper accountTeamMapper = sqlSession.getMapper(AccountMapper.class);
			accountTeamMapper.update(account);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		session.setAttribute("successMessage", "Modification du compte effectuée");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/EditAccountTeam"));
		}
		
}
