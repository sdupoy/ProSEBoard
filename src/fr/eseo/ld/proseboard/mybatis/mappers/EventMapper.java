package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Consulting;
import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.User;

public interface EventMapper {
	public Event getById(Long id);
	public List<Event> getById2(long id);
	public List<Event> getBetween(User user, Date start, Date stop);
	public int existsBetween(@Param("user") User user, @Param("start") Date date, @Param("end") Date date2);
	public List<Event> getAllForUser(User user);
	public List<Event> getAllForCreator(Long idCreator);	
	public void insertEvent(Event event);
	public void deleteEvent(Event event);
	public void deleteEventUser(Event event);
	public void bindEventToUser(@Param("event") Event event, @Param("user") User user);
	public void bindEventToSession(@Param("event") Event event, @Param("idSession") Long idSession);
	public List<User> getAttenders(Long idEvent);
	public List<Event> getAllByCreator(Long id);
	public List<Event> getAllValidateByUser(User user);
	public void validateById(Long id);
	public void acceptById(Long id);
	public void refuseById(Long id);
	public Event getAllForIdEvent(Long id);
	public void updateByEducator(Event event);
	public List<Long> selectUserIdForEventId(Long id);
	public Long getLastId();
	public List<Event> getEventByIdConsultings(@Param("list") List<Consulting> consultings);
	public List<Event> getEventByIdTrainings(@Param("list") List<Training> trainings);
	public List<Event> getAllEventByIdEventUser(Long id);
	public List<Event> getAllEventByIdEventUser2(Long id);
}
