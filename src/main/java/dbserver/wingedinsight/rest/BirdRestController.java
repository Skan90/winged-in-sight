package dbserver.wingedinsight.rest;

import dbserver.wingedinsight.model.Bird;
import dbserver.wingedinsight.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/wingedinsight/birds")
public class BirdRestController {

    @Autowired
    protected BirdService birdService;

    @RequestMapping(value = "/{birdId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bird> getBird(@PathVariable("birdId") int birdId) {
        Bird bird = this.birdService.findBirdById(birdId);
        if (bird == null) {
            return new ResponseEntity<Bird>(bird, HttpStatus.OK);
        }

        return new ResponseEntity<Bird>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Bird>> getBirds(){
        Collection<Bird> bird = this.birdService.findAllBirds();
        if(bird.isEmpty()){
            return new ResponseEntity<Collection<Bird>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<Bird>>(bird, HttpStatus.OK);
    }
}