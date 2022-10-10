package dbserver.wingedinsight.dao;

import dbserver.wingedinsight.model.Bird;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BirdDataAccessService implements BirdDao{
    @Override
    public int insertBird(UUID id, Bird bird) {
        return 0;
    }

    @Override
    public List<Bird> selectAllBirds() {
        return List.of(new Bird(UUID.randomUUID(), "FROM POSTGRESS DB"));
    }

    @Override
    public Optional<Bird> selectBirdById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteBirdById(UUID id) {
        return 0;
    }

    @Override
    public int updateBirdById(UUID id, Bird bird) {
        return 0;
    }
}
