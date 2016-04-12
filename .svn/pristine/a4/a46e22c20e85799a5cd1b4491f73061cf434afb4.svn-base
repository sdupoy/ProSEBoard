package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Account;
import fr.eseo.ld.proseboard.models.AvailableUser;
import fr.eseo.ld.proseboard.models.StatusUser;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.TeamUser;
import fr.eseo.ld.proseboard.models.User;

public interface UserMapper {
    public Long getStudentBySession(Long id);
    public List<User> getAll();
    public List<User> getAll2();
    public User getById(Long id);
    public User getByAccount(Account account);
    public String getMail(int id);
    public User getByMail(String userMail);
    public List<User> getAllWithPermissions();
    public List<User> getAllUserByStatus(Long userId);
    public User getByIdWithPermissions(Long userId);
    public User getByMailWithPermissions(String userMail);
    public List<User> getAllUser();
    public List<User> getAllEtudiant();
    public Team getTeam(Long idUser);
    public List<Team> getTeamList(Long idUser);
    public void insert(User user);
    public void update(User user);
    public void delete(Long userId);
    public void insertAvailable(AvailableUser availableUser);
    public List<AvailableUser> getAvailableById(Long id);
    public List<User> getPotentialBillReceivers(Long idBillEmitter);
    public List<AvailableUser> getAllAvailable();
    public User selectExists(@Param("idUser") Long idUser, @Param("idStatus") int idStatus);
    public List<Long> getIdEventsAttended(Long id);
    public List<User> getAllByIdUsers(@Param("list") List<TeamUser> teamUserListe);
    public List<User> getAllByIdStatus(@Param("list") List<StatusUser> statusUser);
    public void setAbsence(@Param("idEvent") Long idEvent, @Param("idUser") Long idUser);
    public List<User> getUsersWithoutTeamForCurrentSession(Long id);
}

