package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import fr.eseo.ld.proseboard.models.Event;
import fr.eseo.ld.proseboard.models.Team;
import fr.eseo.ld.proseboard.models.Training;
import fr.eseo.ld.proseboard.models.TrainingUser;
import fr.eseo.ld.proseboard.models.User;

public interface TrainingMapper {
	public void insertTrainingPartial(Training training);
	public void insertTrainingComplete(Training training);
	public List<Training> getAllTrainingAfter(Date start);
	public List<Training> getAllTrainingAfterValidate(Date start);
	public List<Training> getAllWithUsers();
	public Event getEvent(Long idEvent);
	public List<Training> searchTrain(@Param("idUsr") Long idUsr);
	public void chargeTeam(Training chargeTrain);
	public int getNbAttenders(Training chargeTrain);
	public void creditTrainer(Training chargeTrain);
	public void setTrainingToCharged(Training chargeTrain);
	public Training getByEventId(Long idEvent);
	public void updateRessourcesAndHourCost(@Param("idEvent")Long idEvent,@Param("ressources") String ressources,@Param("hourCost") Float hourCost);
	public User getEducator(Long idEducator);
	public void modifyTraining(@Param("idTraining")Long idTraining, @Param("subject")String subject,@Param("hourCost")Float hourCost,@Param("ressources")String ressources);
	public List<Training> getByEducator(long idEducator);
	public List<User> getAttenders(Training training);
	public List<User> getAttendersWithAbsence(Long idTraining);
	public List<User> getAttendersFromTeam(@Param("idEvent") Long idEvent, @Param("idTeam") List<Team> list);
	public Training getById(Long id);
	public List<Training> getByTrainerForReport(Long id);
	public List<User> getEveryEventAttender();
	public void updateReport(Training trainingReport);
	public List<Training> getAll();
	public List<Training> getAllBis();
	public List<Training> getTrainByIdTeam(@Param("list") List<TrainingUser> trainingUser);
	public List<Training> getTrainByIdEvent(@Param("list") List<Event> event);
}
