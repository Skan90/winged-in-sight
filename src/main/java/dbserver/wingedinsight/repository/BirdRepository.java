package dbserver.wingedinsight.repository;

import dbserver.wingedinsight.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("postgresql")
public interface BirdRepository extends JpaRepository<Bird, Integer> {

    Optional<Bird> findBySpecies(String species);
}
