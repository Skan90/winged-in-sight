package dbserver.wingedinsight.controller;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.service.impl.BirdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BirdControllerTest {

    public static final Integer ID = 4242;
    public static final String NAME_PT_BR = "João-grande";
    public static final String NAME_ENG = "Maguari Stork";
    public static final String SPECIES = "Ciconia maguari";
    public static final String FAMILY = "Ciconiidae";
    public static final Integer SIZE = 85;
    public static final String GENDER = "Fêmea";
    public static final String COLOR = "Branca";
    public static final String HABITAT = "Banhado com espelho d'água | Campo alagado, campo úmido, várzeas alagadas";
    public static final String PHOTO = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Maguari_Stork_%28Ciconia_maguari%29.jpg/420px-Maguari_Stork_%28Ciconia_maguari%29.jpg";
    public static final String LOCALIZATION = "South and Extreme North of Brazil";
    public static final String BIRD_SPECIES_ALREADY_REGISTERED = "Bird species already registered in the system. Please, try adding a new bird species";
    public static final String BIRD_NOT_FOUND_BY_THE_ID = "Bird not found by the ID number given. Please, try another ID.";
    public static final int INDEX = 0;

    @InjectMocks
    private BirdController controller;

    @Mock
    private BirdServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private Bird bird;
    private BirdDto birdDto;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBird();
    }

    @Test
    void findAllBirds() {
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startBird() {
        bird = new Bird(
                ID,
                NAME_PT_BR,
                NAME_ENG,
                SPECIES,
                FAMILY,
                SIZE,
                GENDER,
                COLOR,
                HABITAT,
                PHOTO,
                LOCALIZATION);

        birdDto = new BirdDto(
                ID,
                NAME_PT_BR,
                NAME_ENG,
                SPECIES,
                FAMILY,
                SIZE,
                GENDER,
                COLOR,
                HABITAT,
                PHOTO,
                LOCALIZATION);

    }
}