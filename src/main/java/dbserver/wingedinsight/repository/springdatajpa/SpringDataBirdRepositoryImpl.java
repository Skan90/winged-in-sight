package dbserver.wingedinsight.repository.springdatajpa;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.repository.BirdRepositoryOverride;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Profile("spring-data-jpa")
public class SpringDataBirdRepositoryImpl implements BirdRepositoryOverride {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void delete (Bird bird){
        String birdId = bird.getId().toString();
        this.em.createQuery("DELETE FROM Bird bird WHERE id=" + birdId).executeUpdate();
    }
}
