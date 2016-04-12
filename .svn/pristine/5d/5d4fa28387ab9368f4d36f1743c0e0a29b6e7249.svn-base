package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Status;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.StatusMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;

@WebServlet("/ManageMembers")
public class ManageMembers extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ManageMembers() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        Long idTeam = Long.valueOf(request.getParameter("idTeam"));

        try{
            Team team = teamMapper.getTeamById(new Long(idTeam));
            
            List<User> studentsAvailable = userMapper.getUsersWithoutTeamForCurrentSession(team.getIdSession());
    
            request.setAttribute("editTeam", team);
            request.setAttribute("students",studentsAvailable);
            request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageMembers.jsp").forward(request, response);
        }finally{
            sqlSession.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        
        TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
        TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
        StatusMapper statusMapper = sqlSession.getMapper(StatusMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User member = userMapper.getById(Long.valueOf(request.getParameter("idMember")));
        Team team = teamMapper.getTeamById(Long.valueOf(request.getParameter("idTeam")));
        Long idSession = Long.valueOf(request.getParameter("idSession"));
        if(member == null || team == null){
            request.setAttribute("errorMessage", "Paramètres manquants.");
            response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/"));
            return;
        }
        
        try{
            if(request.getParameter("delete") == null) {
                // On demande l'ajout d'un membre
                List<Status> statuses = new ArrayList<Status>();
                Status teamMember = new Status();
                teamMember.setIdSession(idSession);
                teamMember.setId(new Long(5));
                statuses.add(teamMember);
                statusMapper.bindUserToStatuses(member, statuses);
                TeamUser teamUser = new TeamUser(member.getId(), team.getId());
                teamUserMapper.insertTeamUser(teamUser);
                statusMapper.delete(member.getId(), new Long(4));
            }else{
                if(member.getId() == team.getIdTeamLeader()){
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "Vous ne pouvez pas retirer le chef d'équipe.");
                    response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ManageMembers?idTeam="+request.getParameter("idTeam")));
                    return;
                }
                // On demande la suppression du membre précisé par l'idMember
                Status student = new Status();
                student.setId(new Long(4));
                teamUserMapper.deleteTeamUser(member.getId(), team.getId());
                List<Status> statuses = new ArrayList<Status>();
                statuses.add(student);
                statusMapper.bindUserToStatuses(member, statuses);
            }
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
        response.sendRedirect(request.getContextPath() + response.encodeRedirectURL("/ManageMembers?idTeam="+request.getParameter("idTeam")));
    }
}
