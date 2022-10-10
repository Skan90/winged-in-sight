package dbserver.wingedinsight.dao;

import dbserver.wingedinsight.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BirdDataAccessService implements BirdDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BirdDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        return 0;
    }

    @Override
    public List<Bird> selectAllBirds() {
        final String sql = "SELECT id, name FROM bird";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Bird(id, name);
        });
    }

    @Override
    public Optional<Bird> selectBirdById(UUID id) {
        final String sql = "SELECT id, name FROM bird WHERE id = ?";
        Bird bird = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID birdId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Bird(birdId, name);
        });
        return Optional.ofNullable(bird);
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
