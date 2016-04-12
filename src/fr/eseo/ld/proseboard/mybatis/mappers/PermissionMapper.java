package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.Permission;

public interface PermissionMapper {
    public Permission getById(Integer userId);
    public List<Permission> getAll();
    public List<Permission> getPermissionsByStatus(Integer statusId);
}

