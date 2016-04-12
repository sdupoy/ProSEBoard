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

import fr.eseo.ld.proseboard.models.Notification;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.NotificationMapper;

/**
 * Servlet implementation class ViewNotifications
 */
@WebServlet("/notifications")
public class ViewNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNotifications() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Notification> notifications = null;
	    HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
	    SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	    try{
	        NotificationMapper notifMapper = sqlSession.getMapper(NotificationMapper.class);
	        notifications = notifMapper.getAllForUser(user);
	        notifMapper.markAsRead(user);
	        sqlSession.commit();
	        session.setAttribute("notifCount", notifMapper.getUsersCount(user));
	    }finally{
	        sqlSession.close();
	    }
	    request.setAttribute("notifications", notifications);
	    request.getRequestDispatcher("/WEB-INF/JSP/notifications.jsp").forward(request, response);
	}

}
