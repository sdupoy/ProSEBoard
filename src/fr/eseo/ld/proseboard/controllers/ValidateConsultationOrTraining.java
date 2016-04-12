package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.Notification;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.NotificationMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;

/**
 * Servlet implementation class ValidateConsultationOrTraining
 */
@WebServlet("/TeamLeader/ValidateConsultationOrTraining")
public class ValidateConsultationOrTraining extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateConsultationOrTraining() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) request.getParameter("name");
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath()
                    + response.encodeRedirectURL("/login"));
        } else {
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                    .openSession();
            EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
            TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
            ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
            NotificationMapper notificationMapper = sqlSession.getMapper(NotificationMapper.class);

            try{
                Long id = Long.parseLong(request.getParameter("id"));
                name = name.intern();
                if (name == "accept") {
                    eventMapper.validateById(id);
                    sqlSession.commit();
                } else if (name == "refuse") {
                    eventMapper.refuseById(id);
                    sqlSession.commit();
                }
    
                Notification notification = new Notification();
                Notification notification2 = new Notification();
    
                // récupérer le training ou le consulting 
                // pouvoir récupérer le destinataire de la notification (prof)
                Training training = trainingMapper.getByEventId(id);
                if(training != null){
                    notification.setIdUser(training.getIdEducator());
                    notification.setSaw(false);
                    notification.setIdObject(id);
                    notification.setType("training_application");
                    notificationMapper.addNotification(notification);
                    sqlSession.commit();
                }
            
                Consulting consulting = consultingMapper.getByEventId(id);
               
                if(consulting != null){
                    notification2.setIdUser(consulting.getIdConsultant());
                    notification2.setSaw(false);
                    notification2.setIdObject(id);
                    notification2.setType("consulting_application");
                    notificationMapper.addNotification(notification2);
                    sqlSession.commit();
                }
            }finally{
                sqlSession.close();
            }
        }
        if (name == "accept") {
            session.setAttribute("successMessage", "Demande envoyée à la personne concernée, vous recevrez une notification pour l'acceptation");
        }else{
            session.setAttribute("errorMessage", "Demande refusée");
        }
        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
    }
}
