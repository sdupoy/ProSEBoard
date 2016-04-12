package fr.eseo.ld.proseboard.controllers;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Status;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.StatusMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/utilisateur/creer")
public class CreateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUser.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            List<Status> statuses = sqlSession.getMapper(StatusMapper.class).getAllForCreate();
            request.setAttribute("statuses", statuses);
            request.getRequestDispatcher("/WEB-INF/JSP/admin/users/create.jsp").forward(request, response);
        }finally{
            sqlSession.close();
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean validationFailed = false;
        //La validation du mot de passe
        if(!request.getParameter("user_password_bis").equals(request.getParameter("user_password"))){
            validationFailed = true;
            session.setAttribute("errorPassword", "Les mots de passe ne correspondent pas.");
        }
        if(request.getParameter("user_password").length() < 8){
            validationFailed = true;
            session.setAttribute("errorPassword", "Le mot de passe doit faire au moins 8 caractères.");
        }
        //La validation du mail
        if(!Pattern.compile("^.+@.+\\..+$").matcher(request.getParameter("user_mail")).matches()){
            validationFailed = true;
            session.setAttribute("errorMail", "Adresse email invalide.");
        }
        //La redirection en cas d'échec
        if(validationFailed){
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/utilisateur/creer"));
            return;
        }


        //La validation passe, on se prépare à enregistrer en base de données
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        // Préparation de l'objet à stocker
        User user = new User();
        user.setLastName(request.getParameter("user_name"));
        user.setFirstName(request.getParameter("user_first_name"));
        user.setMail(request.getParameter("user_mail"));
        user.setPassword(request.getParameter("user_password"));
        boolean redmine = false;
        try {
            redmine = user.createOnRedmine();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage());
        }
        if(redmine){
            session.setAttribute("successMessage", "Utilisateur créé avec succès.");
        }else{
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/utilisateur/creer"));
            return;
        }
        user.setPassword(BCrypt.hashpw(request.getParameter("user_password"),BCrypt.gensalt()));
        Account account = new Account();
        Session proseSession = null;
        try{
            SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
            proseSession = sessionMapper.getLastSession();
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.insert(account);
            
            user.setAccount(account);
            //Enregistrement du nouvel utilisateur
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insert(user);

            //Récupération et association du status choisi
            StatusMapper statusMapper = sqlSession.getMapper(StatusMapper.class);
            String[] statusesId = request.getParameterValues("statuses");
            List<Status> statuses = new ArrayList<Status>();
            for(String statusId : statusesId){
                Status tempStatus = new Status();
                tempStatus.setIdSession(proseSession.getId());
                tempStatus.setId(Long.valueOf(statusId));
                statuses.add(tempStatus);
            }

            statusMapper.bindUserToStatuses(user, statuses);

            sqlSession.commit();
        }finally{
            sqlSession.close();
        }

        //Redirection vers la gestion 
        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/utilisateur/gerer"));
    }
}