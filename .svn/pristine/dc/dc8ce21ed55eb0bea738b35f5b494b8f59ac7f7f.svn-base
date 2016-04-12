package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fr.eseo.ld.proseboard.models.Expertise;
import fr.eseo.ld.proseboard.models.ExpertiseArea;
import fr.eseo.ld.proseboard.models.User;

public interface ExpertiseMapper {
    public Expertise getById(long id);
    public List<Expertise> getAll();
    public List<Expertise> getAll2();
    public List<Expertise> getByIdUser(User user);
    public Long getIdUserByIdExpMapper(long id);
    public void insert(Expertise expertise);
    public void insert2(Expertise expertise);
    public Long getIdExpByNameExp(String name);
    public List<Expertise> getByIdUser2(long id);
    public List<ExpertiseArea> getAllByExp(@Param("list") List<Expertise> expertiseListe);
}
