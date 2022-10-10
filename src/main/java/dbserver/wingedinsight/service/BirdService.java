package dbserver.wingedinsight.service;

import dbserver.wingedinsight.dao.BirdDao;
import dbserver.wingedinsight.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BirdService {

    private final BirdDao birdDao;

    @Autowired
    public BirdService(@Qualifier("postgres") BirdDao birdDao) {
        this.birdDao = birdDao;
    }

    public int addBird(Bird bird) {
        return birdDao.insertBird(bird);
    }

    public List<Bird> getAllBirds(){
        return birdDao.selectAllBirds();
    }

    public Optional<Bird> getBirdById(UUID id){
        return birdDao.selectBirdById(id);
    }

    public int deleteBird(UUID id){
        return birdDao.deleteBirdById(id);
    }

    public int updateBird(UUID id, Bird newBird) {
        return birdDao.updateBirdById(id, newBird);
    }
}
