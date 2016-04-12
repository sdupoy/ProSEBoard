package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.Notification;
import fr.eseo.ld.proseboard.models.User;

public interface NotificationMapper {
    public Notification getById(long id);
    public List<Notification> getAllForUser(User user);
    public Integer getUsersCount(User user);
    public void markAsRead(User user);
    public void addNotification(Notification notification);
}
