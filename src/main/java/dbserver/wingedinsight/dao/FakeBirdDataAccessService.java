package dbserver.wingedinsight.dao;

import dbserver.wingedinsight.model.Bird;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//@Component is the same
@Repository("fakeDao")
public class FakeBirdDataAccessService implements BirdDao{

    private static List<Bird> DB = new ArrayList<>();
    @Override
    public int insertBird(UUID id, Bird bird) {
        DB.add(new Bird(id, bird.getName()));
        return 1;
    }

    @Override
    public List<Bird> selectAllBirds() {
        return DB;
    }

    @Override
    public Optional<Bird> selectBirdById(UUID id) {
        return DB.stream()
                .filter(bird -> bird.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBirdById(UUID id) {
        Optional<Bird> birdMaybe = selectBirdById(id);
        if(birdMaybe.isEmpty()){
            return 0;
        }
        DB.remove(birdMaybe.get());
        return 1;
    }

    @Override
    public int updateBirdById(UUID id, Bird update) {
        return selectBirdById(id)
                .map(bird -> {
                    int indexOfBirdToUpdate = DB.indexOf(bird);
                    if (indexOfBirdToUpdate >= 0){
                        DB.set(indexOfBirdToUpdate, new Bird(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
