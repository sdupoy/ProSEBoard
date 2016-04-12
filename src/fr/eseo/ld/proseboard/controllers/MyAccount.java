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

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.AccountHistory;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountHistoryMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;

/**
 * Servlet implementation class MyAccount
 */
@WebServlet("/MyAccount")
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccount() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Long id = ((User) session.getAttribute("user")).getId();
		try{
			AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
			
			Long idAccount = accountMapper.getIdByIdUser(id);
			Account account = accountMapper.getById(idAccount);
			request.setAttribute("account", account);
		
			
			AccountHistoryMapper accountHistoryMapper = sqlSession.getMapper(AccountHistoryMapper.class);
			List<AccountHistory> accountHistorys = accountHistoryMapper.getByIdHistory(idAccount);
			request.setAttribute("accountHistorys", accountHistorys);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/MyAccount.jsp").forward(request, response);
		
		
		
		
	}



}
