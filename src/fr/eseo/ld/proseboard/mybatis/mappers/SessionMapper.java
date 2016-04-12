package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.Session;

public interface SessionMapper {

    public List<Session> getAllSession();
    public List<Session> getAll();
    public List<Session> getAllAdmin();
    public List<Session> getAllSaufEnd();
    public Session getLastSession();
    public void insertSession(Session session);
    public void insertTest();
    public Session getSessionById(Long id);
    public void deleteSessionById(Long id);
    public void incrementNbTeamById(Long id);
    public void decrementNbTeamById(Long id);
    public Long getOpenedSession();
    public void open(Long id);
    public void close();
    public void update(Session session);
}


