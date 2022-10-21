package dbserver.wingedinsight.service.impl;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.repository.BirdRepository;
import dbserver.wingedinsight.service.exceptions.DuplicatedKeyViolationException;
import dbserver.wingedinsight.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BirdServiceImplTest {

    public static final int ID =              4242;
    public static final String COMMON_NAME = "Bald eagle";
    public static final String BIRD_ORDER =  "Accipitriformes and Falconiformes";
    public static final String FAMILY =      "Accipitridae";
    public static final String SPECIES =      "H. leucocephalus";
    public static final int INDEX =            0;
    public static final String BIRD_SPECIES_ALREADY_REGISTERED = "Bird species already registered in the system. Please, try adding a new bird species";

    @InjectMocks // Instead of @Mock, because we need a real instance for testing methods
    private BirdServiceImpl service;

    @Mock
    private BirdRepository birdRepository;

    @Mock
    private ModelMapper mapper;


    private Bird bird;
    private BirdDto birdDto;
    private Optional<Bird> birdOptional;

    BirdServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapper = mock(ModelMapper.class);
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
        assertEquals(COMMON_NAME, response.getCommonName());
    }
    @Test
    void whenFindByIdReturnsAnObjectNotFoundException(){
        when(birdRepository.findById(anyInt()))
                .thenThrow(new ObjectNotFoundException("Bird not found by the ID number given. " +
                        "Please, try another ID."));

        try{
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Bird not found by the ID number given. Please, try another ID.", ex.getMessage());
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
        assertEquals(COMMON_NAME, response.get(INDEX).getCommonName());
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
        assertEquals(COMMON_NAME, response.getCommonName());

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
        assertEquals(COMMON_NAME, response.getCommonName());

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
    void delete() {
    }

    private void startBird() {
        bird = new Bird( ID,
                COMMON_NAME,
                BIRD_ORDER,
                FAMILY,
                "Haliaeetus",
                SPECIES,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/About_to_Launch_%2826075320352%29.jpg/420px-About_to_Launch_%2826075320352%29.jpg",
                "North America");

        birdDto = new BirdDto( ID,
                COMMON_NAME,
                BIRD_ORDER,
                FAMILY,
                "Haliaeetus",
                SPECIES,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/About_to_Launch_%2826075320352%29.jpg/420px-About_to_Launch_%2826075320352%29.jpg",
                "North America");

        birdOptional = Optional.of(new Bird( ID,
                COMMON_NAME,
                BIRD_ORDER,
                FAMILY,
                "Haliaeetus",
                SPECIES,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/About_to_Launch_%2826075320352%29.jpg/420px-About_to_Launch_%2826075320352%29.jpg",
                "North America"));
    }
}