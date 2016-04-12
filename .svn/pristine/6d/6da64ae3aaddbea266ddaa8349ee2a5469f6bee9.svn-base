package fr.eseo.ld.proseboard.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.Session;
import fr.eseo.ld.proseboard.models.Status;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;
import fr.eseo.ld.proseboard.mybatis.MyBatisUtil;
import fr.eseo.ld.proseboard.mybatis.mappers.AccountMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.SessionMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.StatusMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.TeamUserMapper;
import fr.eseo.ld.proseboard.mybatis.mappers.UserMapper;


@WebServlet("/CreateTeam")
public class CreateTeam extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CreateTeam() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSession = "idSession";
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        StatusMapper statusMapper = sqlSession.getMapper(StatusMapper.class);
        Long id1 = Long.valueOf(0), id2= Long.valueOf(0);
        List<Status> status = statusMapper.getAll();

        for(int i = 0; i < status.size(); i++){
            if("student".equals(status.get(i).getName())) {
                id1= status.get(i).getId().longValue();
            }
            if("client".equals(status.get(i).getName())) {
                id2= status.get(i).getId().longValue();
            }
        }

        List<User> studentsAvailable = userMapper.getAllUserByStatus(id1);
        List<User> clients = userMapper.getAllUserByStatus(id2);

        TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);
        List<TeamUser> studentsHavingTeam = teamUserMapper.getAll();

        for(int v = 0; v < studentsHavingTeam.size(); v++){
            for(int i = 0; i < studentsAvailable.size(); i++){
                if(studentsAvailable.get(i).getId()==studentsHavingTeam.get(v).getIdUser()) {
                    studentsAvailable.remove(i);
                }
            }
        }

        request.setAttribute(idSession,new Long(request.getParameter(idSession)));
        request.setAttribute("students",studentsAvailable);
        request.setAttribute("clients",clients);
        request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/CreateTeam.jsp").forward(request, response);
        sqlSession.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        String errMsg = "errorMsg";
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        String balance = request.getParameter("balance");
        String idTeamLeader = request.getParameter("idTeamLeader");
        String teamName = request.getParameter("teamName");
        String idSession = request.getParameter("idSession");
        String idClient = request.getParameter("idClient");

        if(!balance.isEmpty() && !idTeamLeader.isEmpty() && !teamName.isEmpty() && !idSession.isEmpty() && !idClient.isEmpty()){

            Float value = new Float(-1);

            if(isPriceFormat(balance)) {
                value = new Float(balance);
            }

            if(value >= 0){ 

                TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
                List<Team> checkList = teamMapper.getTeamsFromSession(new Long(request.getParameter("idSession")));
                boolean checkName = true;

                for(int i = 0; i < checkList.size(); i++){
                    if(checkList.get(i).getTeamName().equals(teamName)) {
                        checkName = false;
                    }
                }

                if(checkName){

                    SessionMapper sessionMapper = sqlSession.getMapper(SessionMapper.class);
                    AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
                    TeamUserMapper teamUserMapper = sqlSession.getMapper(TeamUserMapper.class);

                    Account account = new Account(value.floatValue());
                    accountMapper.insert(account);			

                    Team team = new Team(new Long(idTeamLeader),teamName,new String("Non renseigné"),new Long(idSession),account.getIdAccount(),new Long(idClient));
                    teamMapper.insert(team);	
                    Session session = sessionMapper.getSessionById(new Long(idSession));
                    sessionMapper.incrementNbTeamById(new Long(idSession));
                    List<Team> list = teamMapper.getTeamsFromSession(new Long(idSession));
                    teamUserMapper.insertTeamUser(new TeamUser(new Long(idTeamLeader),team.getId()));
                    sqlSession.commit();

                    request.setAttribute("sessionName",session.getName());
                    request.setAttribute("teams", list);
                    request.setAttribute("idSession",new Long(idSession));
                    request.getRequestDispatcher("/WEB-INF/JSP/admin/sessions/ManageTeams.jsp").forward(request, response);
                    sqlSession.close(); 

                }else{

                    request.setAttribute(errMsg, "Cette equipe existe deja, veuillez recommencer la saisie");
                    sqlSession.close(); 
                    doGet(request, response);		    		
                }
                
            }else{

                request.setAttribute(errMsg, "Montant du solde incorrect, veuillez recommencer la saisie");
                sqlSession.close(); 
                doGet(request, response);			
            }

        }else{		

            request.setAttribute(errMsg, "Champs vides, veuillez recommencer la saisie");
            sqlSession.close(); 
            doGet(request, response);			
        }		
    }

    private boolean isPriceFormat(String str) {
        try {
            Float.parseFloat(str);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
