package dbserver.wingedinsight.controller;

import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.service.BirdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/bird")
public class BirdController {
    public static final String ID = "/{id}";

    private BirdService birdService;
    private ModelMapper mapper;

    @Autowired
    public BirdController(BirdService birdService, ModelMapper mapper) {
        this.birdService = birdService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<BirdDto>> findAllBirds(){
        return ResponseEntity.ok().body(
                birdService.findAllBirds()
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/find-by-species/{species}")
    public ResponseEntity<List<BirdDto>> findBySpeciesContaining(@PathVariable("species") String species){
        return ResponseEntity.ok().body(
                birdService.findBySpeciesContaining(species)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BirdDto> findById(@PathVariable("id") Integer id){
        //return ResponseEntity.ok().body(new Bird( 1,"Bald eagle",  "Accipitriformes and Falconiformes", "Accipitridae", "Haliaeetus", "Haliaeetus leucocephalus", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/About_to_Launch_%2826075320352%29.jpg/420px-About_to_Launch_%2826075320352%29.jpg","North America"));
        return ResponseEntity.ok().body(mapper.map(birdService.findById(id), BirdDto.class));
    }

    @PostMapping
    public  ResponseEntity<BirdDto> create(@RequestBody BirdDto obj){
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path(ID)
                .buildAndExpand(birdService.create(obj).getId())
                .toUri();

        return ResponseEntity.created(uri).build(); // Will return 201 status
    }

    @PutMapping(value = ID)
    public ResponseEntity<BirdDto> update(@PathVariable Integer id, @RequestBody BirdDto obj){
        obj.setId(id);
        return ResponseEntity.ok()
                .body(mapper.map(birdService.update(obj), BirdDto.class));
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<BirdDto> delete(@PathVariable Integer id){
        birdService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
