package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class NewAvailable
 */
@WebServlet("/NewAvailable")
public class NewAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAvailable() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/JSP/NewAvailable.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			boolean validateFailed = false;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			
			
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			User user = (User) session.getAttribute("user");
			Date start = null, end = null;
			String messageError = "errorMessage";
			try {
				start = sdf.parse(request.getParameter("start"));
				end = sdf.parse(request.getParameter("end"));
			} catch (ParseException e1) {
				request.setAttribute(messageError,
						"La date n'est pas au format voulu.");
				validateFailed = true;
			}	
			if (start.after(end) || start.equals(end)) {
				request.setAttribute(messageError,
						"La date de fin est avant la date de debut.");
				validateFailed = true;
			}
			if (validateFailed) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/NewAvailable.jsp").forward(request, response);
				return;
			}
			
			try {
				AvailableUser availableUser = new AvailableUser();
				availableUser.setIdUser(user.getId());
				availableUser.setDateStart(start);
				availableUser.setDateEnd(end);
				userMapper.insertAvailable(availableUser);
				
				sqlSession.commit();
			} finally {
				sqlSession.close();
			}		

			session.setAttribute("successMessage", "Nouvelle disponibilité ajoutée");
			response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/Available"));
	}

}
