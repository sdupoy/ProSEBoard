package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class ManageUsers
 */
@WebServlet("/utilisateur/gerer")
public class ManageUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUsers() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/login"));
        }else{
            SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            try{
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                request.setAttribute("users", userMapper.getAllWithPermissions());
                request.getRequestDispatcher("/WEB-INF/JSP/admin/users/manage.jsp").forward(request, response);
            }finally{
                sqlSession.close();
            }
        }
    }
}
