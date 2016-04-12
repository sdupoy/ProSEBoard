package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Message;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.MessageMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class ServletNouveauMessage
 */
@WebServlet("/ServletNouveauMessage")
public class ServletNouveauMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouveauMessage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			List<User> users = sqlSession.getMapper(UserMapper.class).getAllUser();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/WEB-INF/JSP/NouveauMessage.jsp").forward(request, response);
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Message message = new Message();
		
		message.setDate(new Date((Calendar.getInstance()).getTimeInMillis()));
		message.setContain(request.getParameter("content"));
		message.setIdReceiver(Integer.parseInt(request.getParameter("user")));
		message.setIdEmetter(((User)session.getAttribute("user")).getId().intValue());
		message.setMailEmetter(((User)session.getAttribute("user")).getMail());
	
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			message.setMailReceiver(userMapper.getMail(Integer.parseInt(request.getParameter("user"))));
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			messageMapper.insert(message);
			sqlSession.commit();
		
		}finally{
			sqlSession.close();
		}
		
		session.setAttribute("successMessage", "Message Envoyé");
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));

	}

}
