package dbserver.wingedinsight.service;

import dbserver.wingedinsight.model.Bird;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface BirdService {
    Bird findBirdById(int id) throws DataAccessException;
    Collection<Bird> findAllBirds() throws DataAccessException;
    void saveBird(Bird bird) throws DataAccessException;
    void deleteBird(Bird bird) throws DataAccessException;
}
