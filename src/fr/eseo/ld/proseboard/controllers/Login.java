package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;

import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;


/**
 * Servlet implementation class LogServ.
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //On récupère la session
        HttpSession session = request.getSession();

        //Sinon...
        User user = new User();

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getByMailWithPermissions(request.getParameter("login"));
        }finally{
            sqlSession.close();
        }

        //On vérifie que le mot de passe crypté correspond au mot de passe donné
        if(user != null && BCrypt.checkpw(request.getParameter("password"), user.getPassword())){

            //Si oui, on stock les infos de l'utilisateur dans la session
            user.setPassword(null);
            session.setAttribute("user", user);

            //On redirige vers l'accueil
            String from = (String) session.getAttribute("from");
            if(from == null || "".equals(from)){
                response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
            }else{
                response.sendRedirect(request.getContextPath() + response.encodeRedirectURL(from));
            }
            return;
        }else{
            //Sinon, on renvoi vers le login avec un message d'erreur
            request.setAttribute("loginError", "Nom d'utilisateur ou mot de passe incorrect.");
            request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
        }		
    }
}
