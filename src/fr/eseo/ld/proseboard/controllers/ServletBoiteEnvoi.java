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

import fr.eseo.ld.proseboard.models.Message;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.MessageMapper;

/**
 * Servlet implementation class ServletBoiteEnvoi
 */
@WebServlet("/ServletBoiteEnvoi")
public class ServletBoiteEnvoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBoiteEnvoi() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		HttpSession session = request.getSession();
		
		int id = ((User)session.getAttribute("user")).getId().intValue();
		
		try{
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			List <Message> messages = messageMapper.getAllEmetter(id);
			request.setAttribute("messages", messages);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		request.getRequestDispatcher("/WEB-INF/JSP/BoiteEnvoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			MessageMapper message = sqlSession.getMapper(MessageMapper.class);
			message.supprimerEnvoi(id);
			message.supprimerBDD();
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ServletBoiteEnvoi"));
	}

}
