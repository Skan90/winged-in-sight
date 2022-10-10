package dbserver.wingedinsight.api;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/bird")
@RestController
public class BirdController {

    private final BirdService birdService;


    @Autowired
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    @GetMapping
    public List<Bird> getAllBirds(){
        return birdService.getAllBirds();
    }

    @GetMapping(path = "{id}")
    public Bird getBirdById(@PathVariable("id") UUID id){
        return birdService.getBirdById(id)
                .orElse(null); // Can be changed to a custom msg 404 user not found
    }

    @PostMapping
    public void addBird(@Valid @NonNull @RequestBody Bird bird) {
        birdService.addBird(bird);
    }


    @PutMapping(path = "{id}")
    public void updateBird(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Bird birdToUpdate){
        birdService.updateBird(id, birdToUpdate);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBirdById(@PathVariable("id") UUID id){
        birdService.deleteBird(id);
    }

}
