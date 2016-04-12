package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.Template;


public interface TemplateMapper {
	public void insert(Template template);
	public List<Template> getAll();
	public void delete(Long id);
	public Template getById(Long id);
}