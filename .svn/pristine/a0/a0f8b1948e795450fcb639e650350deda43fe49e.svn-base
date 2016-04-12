package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionPlanning
 */
@WebServlet("/session/planning")
public class SessionPlanning extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionPlanning() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idSession = new Long(request.getParameter("idSession"));
        request.setAttribute("idSession",idSession);
        request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/SessionPlanning.jsp").forward(request, response);
    }


}
