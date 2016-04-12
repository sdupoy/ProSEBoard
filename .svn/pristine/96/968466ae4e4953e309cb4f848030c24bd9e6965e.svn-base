package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Message;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.MessageMapper;

/**
 * Servlet implementation class ResponseMessage
 */
@WebServlet("/ResponseMessage")
public class ResponseMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseMessage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message message = new Message();
		
		
		message.setIdMessage(Integer.parseInt(request.getParameter("id")));
		message.setIdEmetter(Integer.parseInt(request.getParameter("idE")));
		message.setIdReceiver(Integer.parseInt(request.getParameter("idR")));
		message.setMailEmetter(request.getParameter("idMailE"));
		message.setMailReceiver(request.getParameter("idMailR"));
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/JSP/ResponseMessage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Message message = new Message();
		
		message.setDate(new Date((Calendar.getInstance()).getTimeInMillis()));
		message.setContain(request.getParameter("content"));
		message.setIdReceiver(Integer.parseInt(request.getParameter("idE")));
		message.setIdEmetter(Integer.parseInt(request.getParameter("idR")));
		message.setMailEmetter(request.getParameter("idMailR"));
		message.setMailReceiver(request.getParameter("idMailE"));
	
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		try{
			
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
