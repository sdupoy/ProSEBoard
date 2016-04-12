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

import fr.eseo.ld.proseboard.models.AvailableUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class MyAvailable
 */
@WebServlet("/MyAvailable")
public class MyAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAvailable() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
		
		User user = (User) session.getAttribute("user");
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try {
			List<AvailableUser> availables;
			availables = userMapper.getAvailableById(user.getId());
			
					
			request.setAttribute("availables", availables);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		

		request.getRequestDispatcher("/WEB-INF/JSP/MyAvailable.jsp").forward(request, response);
		
		
	}



}
