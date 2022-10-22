package dbserver.wingedinsight.service.impl;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.repository.BirdRepository;
import dbserver.wingedinsight.service.exceptions.DuplicatedKeyViolationException;
import dbserver.wingedinsight.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdServiceImpl implements dbserver.wingedinsight.service.BirdService {

    private BirdRepository birdRepository;

    private ModelMapper mapper;
    @Autowired
    public BirdServiceImpl(@Qualifier("postgresql") BirdRepository birdRepository, ModelMapper mapper) {
        this.birdRepository = birdRepository;
        this.mapper = mapper;
    }

    @Override
    public Bird findById(Integer id) {
        Optional<Bird> obj = birdRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Bird not found by the ID number given. Please, try another ID."));
    }
    public List<Bird> findAllBirds() {

        return birdRepository.findAll();
    }

    @Override
    public Bird create(BirdDto obj) {
        findBySpecies(obj);
        return birdRepository.save(mapper.map(obj, Bird.class));
    }

    @Override
    public Bird update(BirdDto obj) {
        findBySpecies(obj);
        return birdRepository.save(mapper.map(obj, Bird.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        birdRepository.deleteById(id);
    }

    private void findBySpecies(BirdDto obj) {
        Optional<Bird> bird = birdRepository.findBySpecies(obj.getSpecies());
        if(bird.isPresent() && !bird.get().getId().equals(obj.getId())) {
            throw new DuplicatedKeyViolationException("Bird species already registered in the system. Please, try adding a new bird species");
        }
    }

    @Override
    public List<Bird> findBySpeciesContaining(String species) {
        List<Bird> results = birdRepository.findBySpeciesContaining(species);
        return results;

    }
}
