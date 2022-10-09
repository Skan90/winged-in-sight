package dbserver.wingedinsight.repository;

import dbserver.wingedinsight.model.Bird;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Profile("spring-data-jpa")
public interface BirdRepositoryOverride {

    public void delete(Bird bird);

}
