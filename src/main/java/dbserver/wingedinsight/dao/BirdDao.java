package dbserver.wingedinsight.dao;

import dbserver.wingedinsight.model.Bird;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// DAO = Data Access Object
public interface BirdDao {
    // mock a DB
    int insertBird(UUID id, Bird bird);

    default int insertBird(Bird bird){
        UUID id = UUID.randomUUID();
        return insertBird(id, bird);
    }

    List<Bird> selectAllBirds();

    Optional<Bird> selectBirdById(UUID id);

    Optional<Bird> selectBirdByName(String name);

    int deleteBirdById(UUID id);

    int updateBirdById(UUID id, Bird bird);
}
