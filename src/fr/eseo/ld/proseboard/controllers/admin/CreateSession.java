package fr.eseo.ld.proseboard.controllers.admin;

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

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;


@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateSession.class);

    public CreateSession() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/CreateSession.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);		
            String name = request.getParameter("sessionName"); 	
            List<Session> checkList = sessionMapper.getAll();
            boolean checkName = true;
    
            for(int i = 0; i < checkList.size(); i++){
                if(checkList.get(i).getName().equals(name)) {
                    checkName = false;
                }
            }
    
            if(checkName){
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   	
                Date sd = new Date();
                Date ed = new Date(); 
    
                try{
                    sd = sdf.parse(startDate);
                    ed = sdf.parse(endDate);
                }catch(ParseException e){
                    LOGGER.error(e.getMessage());
                }	
    
                if(sd.compareTo(ed)<0){
                    Session session = new Session(name,new Long(0),sd,ed);
                    sessionMapper.insertSession(session);
                    sqlSession.commit();  			
                    response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/session/create/template?idSession="+session.getId()));
                }else{
                    request.setAttribute("errorMsg", "Ordre des dates incorrect, veuillez recommencer");
                    request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/CreateSession.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("errorMsg", "Cette session existe déjà, veuillez recommencer");
                request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/CreateSession.jsp").forward(request, response);
            }
        }finally{
            sqlSession.close(); 
        }
    }
}