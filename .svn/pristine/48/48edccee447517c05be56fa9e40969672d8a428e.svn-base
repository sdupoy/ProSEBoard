package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;

/**
 * Servlet implementation class ToggleSession
 */
@WebServlet({ "/session/ouvrir", "/session/fermer" })
public class ToggleSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToggleSession() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long sessionId = Long.valueOf(request.getParameter("id"));
        HttpSession httpSession = request.getSession();
        User user = (User)httpSession.getAttribute("user");
        if(!user.hasStatus("admin")){
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
            return;
        }
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
            Session session = sessionMapper.getSessionById(sessionId);
            sessionMapper.close();
            if(session.isOpen() == false){
                sessionMapper.open(sessionId);
            }
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ManageSessions"));
    }

}
