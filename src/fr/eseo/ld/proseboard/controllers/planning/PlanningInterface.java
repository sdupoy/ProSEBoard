package fr.eseo.ld.proseboard.controllers.planning;

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

import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.EventMapper;

/**
 * Servlet implementation class TestPlanning
 */
@WebServlet("/planning/test")
public class PlanningInterface extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanningInterface() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext()
        .getRequestDispatcher("/WEB-INF/JSP/planning/testplanning.jsp")
        .forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String errMsg = "errorMsg";
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        boolean validateFailed = false;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Préparation de l'objet à stocker
        User user = (User) session.getAttribute("user");

        Date start = null, end = null;
        try {
            start = sdf.parse(request.getParameter("start"));
            end = sdf.parse(request.getParameter("end"));
        } catch (ParseException e1) {
            request.setAttribute(errMsg,
                    "La date n'est pas au format voulu.");
            validateFailed = true;
        }
        if (!user.isAvailable(start, end)) {
            request.setAttribute(
                    errMsg,
                    "L'utilisateur "
                            + user.getFirstName()
                            + " "
                            + user.getLastName()
                            + " n'est pas disponible sur cette tranche horaire.");
            validateFailed = true;
        }
        if (start.after(end)) {
            request.setAttribute(errMsg,
                    "La date de fin est avant la date de début.");
            validateFailed = true;
        }

        if (validateFailed) {
            this.getServletContext()
            .getRequestDispatcher("/WEB-INF/JSP/planning/testplanning.jsp")
            .forward(request, response);
            return;
        }

        Event event = new Event();
        event.setName(request.getParameter("name"));
        event.setDescription(request.getParameter("description"));
        System.err.println(event.getName());
        System.err.println(event.getDescription());
        event.setStartDate(start);
        event.setEndDate(end);
        event.setIdCreator(user.getId());

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
                .openSession();

        EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);

        try {
            eventMapper.insertEvent(event);
            eventMapper.bindEventToUser(event, user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

        response.sendRedirect(request.getContextPath()
                + response.encodeRedirectURL("/planning"));
    }

}
