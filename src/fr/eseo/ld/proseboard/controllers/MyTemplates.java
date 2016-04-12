package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Template;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.TemplateMapper;

/**
 * Servlet implementation class MyTemplates
 */
@WebServlet("/Templates")
public class MyTemplates extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTemplates() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);
            List<Template> templates = templateMapper.getAll();
            request.setAttribute("templates", templates);            
        }finally{
            sqlSession.close();
        }
        request.getRequestDispatcher("/WEB-INF/JSP/MyTemplates.jsp").forward(request, response);
    }


}
