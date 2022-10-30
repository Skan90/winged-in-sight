package dbserver.wingedinsight.service.impl;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.repository.BirdRepository;
import dbserver.wingedinsight.service.exceptions.DuplicatedKeyViolationException;
import dbserver.wingedinsight.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BirdServiceImplTest {

    public static final Integer ID = 4242;
    public static final String NAME_PT_BR = "joão-grande";
    public static final String NAME_ENG = "maguari stork";
    public static final String SPECIES = "ciconia maguari";
    public static final String FAMILY = "ciconiidae";
    public static final Integer SIZE = 85;
    public static final String GENDER = "Fêmea";
    public static final String COLOR = "branca";
    public static final String HABITAT = "banhado com espelho d'água, ccmdampo alagado, campo úmido, várzeas alagadas";
    public static final String PHOTO = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Maguari_Stork_%28Ciconia_maguari%29.jpg/420px-Maguari_Stork_%28Ciconia_maguari%29.jpg";
    public static final String LOCALIZATION = "Sul e extremo norte do Brasil";
    public static final String BIRD_SPECIES_ALREADY_REGISTERED = "Bird species already registered in the system. Please, try adding a new bird species";
    public static final String BIRD_NOT_FOUND_BY_THE_ID = "Bird not found by the ID number given. Please, try another ID.";
    public static final int INDEX = 0;


    @InjectMocks // Instead of @Mock, because we need a real instance for testing methods
    private BirdServiceImpl service;

    @Mock
    private BirdRepository birdRepository;

    @Mock
    private ModelMapper mapper;


    private Bird bird;
    private Bird birdTwo;
    private BirdDto birdDto;
    private List<Bird> birdList;
    private Optional<Bird> birdOptional;

    BirdServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBird();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(birdRepository.findById(anyInt())).thenReturn(birdOptional);

        Bird response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Bird.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(SPECIES, response.getSpecies());
        assertEquals(NAME_ENG, response.getNameEng());
    }
    @Test
    void whenFindByIdReturnsAnObjectNotFoundException(){
        when(birdRepository.findById(anyInt()))
                .thenThrow(new ObjectNotFoundException(BIRD_NOT_FOUND_BY_THE_ID));

        try{
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(BIRD_NOT_FOUND_BY_THE_ID, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfBirds() {
        when(birdRepository.findAll()).thenReturn(List.of((bird)));

        List<Bird> response = service.findAllBirds();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_ENG, response.get(INDEX).getNameEng());
    }


    @Test
    void whenFindBySpeciesContainingPartOfSomeStringIgnoringCaseSensitiveThenReturnAnListOfBirds() {

        when(birdRepository.findBySpeciesContainingIgnoreCase(anyString())).thenReturn(List.of(bird));


        List<Bird> response = service.findBySpeciesContainingIgnoreCase(SPECIES);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_ENG, response.get(INDEX).getNameEng());
    }

    @Test
    void whenFindByNamePtBrContainingPartOfSomeStringIgnoringCaseSensitiveThenReturnAnListOfBirds() {
        when(birdRepository.findByNamePtBrContainingIgnoreCase(anyString())).thenReturn(List.of((bird)));

        List<Bird> response = service.findByNamePtBrContainingIgnoreCase(NAME_PT_BR);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_PT_BR, response.get(INDEX).getNamePtBr());
    }



    @Test
    void whenFindByNameEngContainingPartOfSomeStringIgnoringCaseSensitiveThenReturnAnListOfBirds() {
        when(birdRepository.findByNameEngContainingIgnoreCase(anyString())).thenReturn(List.of((bird)));

        List<Bird> response = service.findByNameEngContainingIgnoreCase(NAME_ENG);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_ENG, response.get(INDEX).getNameEng());
    }




    @Test
    void whenFindByColorEngContainingPartOfSomeStringIgnoringCaseSensitiveThenReturnAnListOfBirds() {
        when(birdRepository.findByColorContainingIgnoreCase(anyString())).thenReturn(List.of((bird)));

        List<Bird> response = service.findByColorContainingIgnoreCase(COLOR);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_ENG, response.get(INDEX).getNameEng());
        assertEquals(COLOR, response.get(INDEX).getColor());
    }

    @Test
    void whenFindByHabitatContainingPartOfSomeStringIgnoringCaseSensitiveThenReturnAnListOfBirds() {
        when(birdRepository.findByHabitatContainingIgnoreCase(anyString())).thenReturn(List.of((bird)));

        List<Bird> response = service.findByHabitatContainingIgnoreCase(HABITAT);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Bird.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(SPECIES, response.get(INDEX).getSpecies());
        assertEquals(NAME_ENG, response.get(INDEX).getNameEng());
        assertEquals(HABITAT, response.get(INDEX).getHabitat());
    }

    @Test
    void whenCreateBirdThenReturnSuccess() {
        // given
        when(birdRepository.save(any())).thenReturn(bird);
        // when
        Bird response = service.create(birdDto);
        // then
        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(SPECIES, response.getSpecies());
        assertEquals(NAME_ENG, response.getNameEng());

    }

    @Test
    void whenCreateBirdThenReturnAnDuplicatedKeyViolationException() {
        // given
        when(birdRepository.findBySpecies(anyString())).thenReturn(birdOptional);
        // when

        try{
            birdOptional.get().setId(2);
            service.create(birdDto);
        } catch (Exception ex){
            assertEquals(DuplicatedKeyViolationException.class, ex.getClass());
            assertEquals(BIRD_SPECIES_ALREADY_REGISTERED, ex.getMessage());
        }
    }

    @Test
    void whenUpdateBirdThenReturnSuccess() {
        // given
        when(birdRepository.save(any())).thenReturn(bird);
        // when
        Bird response = service.update(birdDto);
        // then
        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(SPECIES, response.getSpecies());
        assertEquals(NAME_ENG, response.getNameEng());

    }

    @Test
    void whenUpdateBirdThenReturnAnDuplicatedKeyViolationException() {
        // given
        when(birdRepository.findBySpecies(anyString())).thenReturn(birdOptional);
        // when

        try{
            birdOptional.get().setId(2);
            service.update(birdDto);
        } catch (Exception ex){
            assertEquals(DuplicatedKeyViolationException.class, ex.getClass());
            assertEquals(BIRD_SPECIES_ALREADY_REGISTERED, ex.getMessage());
        }
    }


    @Test
    void deleteBirdWithSuccess() {
        when(birdRepository.findById(anyInt())).thenReturn(birdOptional);
        doNothing().when(birdRepository).deleteById(anyInt());
        service.delete(ID);
        verify(birdRepository, times(1)).deleteById(anyInt());
    }

    @Test
    void deleteBirdWithObjectNotFoundException() {
        when((birdRepository.findById(anyInt())))
                .thenThrow(new ObjectNotFoundException(BIRD_NOT_FOUND_BY_THE_ID));

        try {
            service.delete(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(BIRD_NOT_FOUND_BY_THE_ID, ex.getMessage());
        }
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

        birdOptional = Optional.of(new Bird(
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
                LOCALIZATION));
    }

}