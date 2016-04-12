package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Template;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;

/**
 * Servlet implementation class CreateSessionWithTemplate
 */
@WebServlet("/session/create/template")
public class CreateSessionWithTemplate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionWithTemplate() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
        try{
            Session session = sessionMapper.getSessionById(Long.valueOf(request.getParameter("idSession")));
            if(session == null){
                response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
                return;
            }
            request.setAttribute("session", session);
            request.setAttribute("templates", sqlSession.getMapper(TemplateMapper.class).getAll());
            request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ChoseTemplate.jsp").forward(request, response);
        }finally{
            sqlSession.close();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
        try{
            Session session = sessionMapper.getSessionById(Long.valueOf(request.getParameter("idSession")));
            Template template = sqlSession.getMapper(TemplateMapper.class).getById(Long.valueOf(request.getParameter("idTemplate"))); 
            session.setIdTemplate(template.getTemplateId());
            sessionMapper.update(session);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ManageSessions"));
    }

}
