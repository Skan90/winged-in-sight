package dbserver.wingedinsight.repository;
import java.util.Collection;

import dbserver.wingedinsight.model.Bird;
import org.springframework.dao.DataAccessException;

public interface BirdRepository {

    Collection<Bird> findByPopularName(String popularName) throws DataAccessException;

    Bird findById(int id) throws DataAccessException;

    void save(Bird bird) throws DataAccessException;

    Collection<Bird> findAll() throws DataAccessException;

    void delete(Bird bird) throws DataAccessException;
}
