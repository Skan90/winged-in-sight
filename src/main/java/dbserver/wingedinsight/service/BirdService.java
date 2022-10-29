package dbserver.wingedinsight.service;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;

import java.util.List;

public interface BirdService {
    Bird findById(Integer id);

    List<Bird> findAllBirds();

    List<Bird> findBySpeciesContaining(String species);

    List<Bird> findByNamePtBrContaining(String namePtBr);

    Bird create(BirdDto obj);
    
    Bird update(BirdDto obj);

    void delete(Integer id);
}
