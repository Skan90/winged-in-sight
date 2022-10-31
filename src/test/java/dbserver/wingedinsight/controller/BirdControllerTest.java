package dbserver.wingedinsight.controller;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.service.impl.BirdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class BirdControllerTest {

    public static final Integer ID = 4242;
    public static final String NAME_PT_BR = "joão-grande";
    public static final String NAME_ENG = "maguari Stork";
    public static final String SPECIES = "ciconia maguari";
    public static final String FAMILY = "Ciconiidae";
    public static final Integer SIZE = 85;
    public static final String GENDER = "Fêmea";
    public static final String COLOR = "branca";
    public static final String HABITAT = "banhado com espelho d'água, campo alagado, campo úmido, várzeas alagadas";
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
    @Disabled
    void findAllBirds() {

    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(bird);
        when(mapper.map(any(), any())).thenReturn(birdDto);

        ResponseEntity<BirdDto> response = controller.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(BirdDto.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME_ENG, response.getBody().getNameEng());
        assertEquals(NAME_PT_BR, response.getBody().getNamePtBr());
        assertEquals(SPECIES, response.getBody().getSpecies());
        assertEquals(FAMILY, response.getBody().getFamily());
        assertEquals(SIZE, response.getBody().getSize());
        assertEquals(GENDER, response.getBody().getGender());
        assertEquals(COLOR, response.getBody().getColor());
        assertEquals(HABITAT, response.getBody().getHabitat());
        assertEquals(PHOTO, response.getBody().getPhoto());
    }


    @Test
    void findBySpeciesContainingIgnoreCase() {
    }

    @Test
    void findByNamePtBrContainingIgnoreCase() {
    }

    @Test
    void findByNameEngContainingIgnoreCase() {
    }

    @Test
    void findByColorContainingIgnoreCase() {
    }

    @Test
    void findByHabitatContainingIgnoreCase() {
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
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