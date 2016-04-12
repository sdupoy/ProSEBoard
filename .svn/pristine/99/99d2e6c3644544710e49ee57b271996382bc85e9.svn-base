package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.AvailableUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class SeeAvailable
 */
@WebServlet("/SeeAvailable")
public class SeeAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeAvailable() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			List <AvailableUser> availableUser;
			availableUser = userMapper.getAllAvailable();
			request.setAttribute("availables", availableUser);
			
			List <User> user;
			user = userMapper.getAll2();
			request.setAttribute("users", user);
			
			
			request.getRequestDispatcher("/WEB-INF/JSP/SeeAvailable.jsp").forward(request, response);
		} finally {
			sqlSession.close();
		}

	}



}
