package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Notification;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.NotificationMapper;

/**
 * Servlet implementation class ReservationConsultation
 */
@WebServlet("/AcceptConsultationOrTraining")
public class AcceptConsultationOrTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptConsultationOrTraining() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));
		if (session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath()
					+ response.encodeRedirectURL("/login"));
		} else {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
					.openSession();
			EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);				
			
			session.setAttribute("idEvent", id);
			try {
				String name = (String)request.getParameter("name");
				name=name.intern();
				if(name=="accept"){
					eventMapper.acceptById(id);
				} else if(name=="refuse"){
					eventMapper.refuseById(id);
				}
				
				NotificationMapper notificationMapper = sqlSession.getMapper(NotificationMapper.class);	
				Notification notification = new Notification();
				Event event = new Event();
				event = eventMapper.getAllForIdEvent(id);
				int type = event.getType().compareTo("consulting");
				if(type ==0){
					notification.setType("consulting_application");
					notification.setIdUser(event.getIdCreator());
					notification.setSaw(false);
					notification.setIdObject(id);
					notificationMapper.addNotification(notification);
					System.out.println("C");
				}else{
					notification.setType("training_application");
					notification.setIdUser(event.getIdCreator());
					notification.setSaw(false);
					notification.setIdObject(id);
					notificationMapper.addNotification(notification);
					System.out.println("T");
				}
				sqlSession.commit();
				request.setAttribute("id", id);
				if(request.getParameter("name").intern()=="accept"){
					if(type==0){
						session.setAttribute("successMessage", "Bien ajouté, envoi de la notification au chef d'équipe conserné");
						response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
					}else{
						session.setAttribute("successMessage", "Bien ajouté, envoi de la notification au chef d'équipe conserné");
						response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/training/UpdateTraining"));
					}
						
				}else{
					session.setAttribute("errorMessage", "Demande refusée");
				response.sendRedirect(request.getContextPath()
						+ response.encodeRedirectURL("/"));
				}
			} finally {
				sqlSession.close();
			}
		}
		
	}
}