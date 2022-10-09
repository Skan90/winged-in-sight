package dbserver.wingedinsight.service;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;


import java.util.Collection;
@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepository birdRepository;

    @Autowired
    public BirdServiceImpl (BirdRepository birdRepository){
        this.birdRepository = birdRepository;
    }

    @Override
    public Bird findBirdById(int birdId) {
        Bird bird = null;
        try{
            bird = birdRepository.findById(birdId);
        } catch (ObjectRetrievalFailureException| EmptyResultDataAccessException e){
            return null;
        }
        return bird;
    }

    @Override
    public Collection<Bird> findAllBirds() throws DataAccessException {
        return birdRepository.findAll();
    }

    @Override
    public void saveBird(Bird bird) throws DataAccessException {
        birdRepository.save(bird);
    }

    @Override
    public void deleteBird(Bird bird) throws DataAccessException {
        birdRepository.delete(bird);
    }

}
