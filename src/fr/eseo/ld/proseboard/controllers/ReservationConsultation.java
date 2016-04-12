package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Expertise;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.ConsultingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.ExpertiseMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TrainingMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class ReservationConsultation
 */
@WebServlet("/TeamLeader/ReservationConsultation")
public class ReservationConsultation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationConsultation() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath()
                    + response.encodeRedirectURL("/login"));
        } else {
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                    .openSession();
            try {
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                ExpertiseMapper expertiseMapper = sqlSession
                        .getMapper(ExpertiseMapper.class);
                List<Expertise> expertiseAll = expertiseMapper.getAll();
                request.setAttribute("expertiseAll", expertiseAll);
                List<Expertise> expertiseUser = expertiseMapper.getAll2();
                request.setAttribute("expertiseUser", expertiseUser);

                List<User> users = userMapper.getAll2();
                request.setAttribute("users", users);
                List<User> userTeacher = userMapper.getAllUserByStatus(Long
                        .valueOf(3));
                request.setAttribute("userTeacher", userTeacher);
                List<User> userConsultant = userMapper.getAllUserByStatus(Long
                        .valueOf(7));
                request.setAttribute("userConsultant", userConsultant);
                request.getRequestDispatcher(
                        "/WEB-INF/JSP/TeamLeader/ReservationConsultation.jsp")
                        .forward(request, response);
            } finally {
                sqlSession.close();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean validateFailed = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        ConsultingMapper consultingMapper = sqlSession.getMapper(ConsultingMapper.class);
        EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
        TrainingMapper trainingMapper = sqlSession.getMapper(TrainingMapper.class);
        SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
        
        
        // PrÃ©paration de l'objet Ã  stocker
        User user = (User) session.getAttribute("user");
        Long idUser = Long.valueOf(request.getParameter("idUser"));
        User teacher = userMapper.getById(idUser);
        Long idSession = sessionMapper.getOpenedSession();
        
        String description = new String();
        String eventType = new String();
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
        if (!user.isAvailable(start, end)) {
            request.setAttribute(
                    messageError,
                    "L'utilisateur "
                            + user.getFirstName()
                            + " "
                            + user.getLastName()
                            + " n'est pas disponible sur cette tranche horaire.");
            validateFailed = true;
        }
        if (start.after(end) || start.equals(end)) {
            request.setAttribute(messageError,
                    "La date de fin est avant la date de debut.");
            validateFailed = true;
        }
        if (validateFailed) {
            this.getServletContext()
            .getRequestDispatcher("/WEB-INF/JSP/team/teamview.jsp")
            .forward(request, response);
            return;
        }
        description = request.getParameter("description");
        eventType = (String) request.getParameter("eventType");
        eventType = eventType.intern();
        Event event = new Event();
        event.setStartDate(start);
        event.setEndDate(end);
        event.setIdCreator(user.getId());
        event.setDescription(description);
        if (eventType == "3") {
            event.setType("consulting");
            event.setName("Consultation");
        } else {
            event.setType("training");
            event.setName("Session d'entraînement");
        }

        try {
            Team team = teamMapper.getUserTeam(user);
            List<User> userTeam = team.getMembers();

            eventMapper.insertEvent(event);
            event.setIdSession(idSession);
            eventMapper.bindEventToUser(event, teacher);
            for (int i = 0; i < userTeam.size(); i++) {
                eventMapper.bindEventToUser(event, userTeam.get(i));
            }
            if (event.getType() == "training") {
                Training training = new Training();
                training.setIdEducator(teacher.getId());
                training.setSubject(description);
                training.setIdEvent(event.getId());
                training.setHourCost(0);
                trainingMapper.insertTrainingPartial(training);
            } else if (event.getType() == "consulting") {
                Consulting consulting = new Consulting();
                consulting.setIdConsultant(teacher.getId());
                consulting.setIdTeam(team.getId());
                consulting.setIdEvent(event.getId());
                consulting.setHourCost(0);
                consultingMapper.insertConsulting(consulting);
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

        session.setAttribute("successMessage",
                "Demande envoyé au chef d'équipe");
        response.sendRedirect(request.getContextPath()
                + response.encodeRedirectURL("/"));
    }
}