package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.RedmineEvent;
import fr.eseo.ld.proseboard.models.User;

public interface RedmineEventMapper {
        public List<RedmineEvent> getAllForUser(User user);
}
