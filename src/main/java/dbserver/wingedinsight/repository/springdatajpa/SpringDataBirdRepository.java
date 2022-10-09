package dbserver.wingedinsight.repository.springdatajpa;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.repository.BirdRepository;
import dbserver.wingedinsight.repository.BirdRepositoryOverride;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@Profile("spring-data-jpa")
public interface SpringDataBirdRepository extends BirdRepository, Repository<Bird, Integer>, BirdRepositoryOverride {

    @Query("SELECT bname FROM Bird bname order by bname.popularName")
    List<Bird> findBirds() throws DataAccessException;
}
