package dbserver.wingedinsight.service;

import dbserver.wingedinsight.dao.BirdDataAccessService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BirdServiceTest {

    @Mock
    private BirdDataAccessService birdDataAccessService;
    private BirdService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BirdService(birdDataAccessService);
    }

    @Test
    void canGetAllBirds() {
        //when
        underTest.getAllBirds();
        //then
        verify(birdDataAccessService).selectAllBirds();
    }

    @Test
    @Disabled
    void getBirdById() {
    }

    @Test
    @Disabled
    void canAddBird() {

    }

    @Test
    @Disabled
    void updateBird() {
    }

    @Test
    @Disabled
    void deleteBird() {
    }
}