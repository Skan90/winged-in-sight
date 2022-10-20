package dbserver.wingedinsight.service;

import dbserver.wingedinsight.repository.BirdRepository;
import dbserver.wingedinsight.service.impl.BirdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BirdServiceTest {

    @Mock
    private BirdRepository birdRepository;
    private BirdServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new BirdServiceImpl(birdRepository);
    }


    @Test
    void whenFindAllThenReturnAnListOfBirds() {
    }
}