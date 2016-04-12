package fr.eseo.ld.proseboard.controllers.team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.ld.proseboard.models.User;

/**
 * Servlet implementation class ManageTeams
 */
@WebServlet("/equipes")
public class ManageTeams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageTeams() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("user");
        if(loggedUser.hasPermission("manage_teams")){
            request.getRequestDispatcher("/WEB-INF/JSP/admin/team/manage.jsp").forward(request, response);
        }else{
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
