package fr.eseo.ld.proseboard.mybatis.mappers;
import java.util.List;

import fr.eseo.ld.proseboard.models.TemplateTimeslot;

public interface TemplateTimeslotMapper {
	public void insert(TemplateTimeslot templateTimeslot);
	public List<TemplateTimeslot> getAll();
	public void delete(Long templateTimeslotId);
	public void deleteByIdTemplate(Long id);
	public List<TemplateTimeslot> getForTemplate(Long id);
}
