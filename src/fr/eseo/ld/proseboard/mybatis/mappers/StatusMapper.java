package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Status;
import fr.eseo.ld.proseboard.models.User;

public interface StatusMapper {
	public Status getById(long id);
	public List<Status> getAll();
	public List<Status> getAllForCreate();
	public void bindUserToStatuses(@Param("user") User user, @Param("statuses") List<Status> statuses);
	public void delete(@Param("idUser") Long idUser, @Param("idStatus") Long idStatus);
}