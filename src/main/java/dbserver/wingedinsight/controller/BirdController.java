package dbserver.wingedinsight.controller;

import dbserver.wingedinsight.model.dto.BirdDto;
import dbserver.wingedinsight.service.BirdService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin("*")
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

    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s).")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aves listadas com sucesso."),
            @ApiResponse(code = 500, message = "Houve um erro ao listar as aves cadastradas.")
    })
    @GetMapping
    public ResponseEntity<List<BirdDto>> findAllBirds(){
        log.info("Listando todas as aves cadastradas");
        return ResponseEntity.ok().body(
                birdService.findAllBirds()
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }
    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s) por parte do nome da espécie (nome em latim).")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave(s) listada(s) com sucesso.")
    })
    @GetMapping("/find-by-species/{species}")
    public ResponseEntity<List<BirdDto>> findBySpeciesContainingIgnoreCase(@PathVariable("species") String species){
        log.info("Listando a(s) ave(s) contendo parte da espécie (nome em latim) com o valor digitado '[{}]'", species);
        return ResponseEntity.ok().body(
                birdService.findBySpeciesContainingIgnoreCase(species)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }


    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s) por parte do nome da em português.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave(s) listada(s) com sucesso.")
    })
    @GetMapping("/find-by-name-ptbr/{namePtBr}")
    public ResponseEntity<List<BirdDto>> findByNamePtBrContainingIgnoreCase(@PathVariable("namePtBr") String namePtBr){
        log.info("Listando a(s) ave(s) contendo parte do nome em português com o valor digitado '[{}]'", namePtBr);
        return ResponseEntity.ok().body(
                birdService.findByNamePtBrContainingIgnoreCase(namePtBr)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }



    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s) por parte do nome da em inglês.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave(s) listada(s) com sucesso.")
    })
    @GetMapping("/find-by-name-eng/{nameEng}")
    public ResponseEntity<List<BirdDto>> findByNameEngContainingIgnoreCase(@PathVariable("nameEng") String nameEng){
        log.info("Listando a(s) ave(s) contendo parte do nome em inglês com o valor digitado '[{}]'", nameEng);
        return ResponseEntity.ok().body(
                birdService.findByNameEngContainingIgnoreCase(nameEng)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }

    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s) pela cor primária contendo o valor digitado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave(s) listada(s) com sucesso.")
    })
    @GetMapping("/find-by-color/{color}")
    public ResponseEntity<List<BirdDto>> findByColorContainingIgnoreCase(@PathVariable("color") String color){
        log.info("Listando a(s) ave(s) cadastrada(s) pela cor primária contendo o valor '[{}]' digitado", color);
        return ResponseEntity.ok().body(
                birdService.findByColorContainingIgnoreCase(color)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }



    @ApiOperation(value = "Listando a(s) ave(s) cadastrada(s) pelo habitat contendo o valor digitado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave(s) listada(s) com sucesso.")
    })
    @GetMapping("/find-by-habitat/{habitat}")
    public ResponseEntity<List<BirdDto>> findByHabitatContainingIgnoreCase(@PathVariable("habitat") String habitat){
        log.info("Listando a(s) ave(s) cadastrada(s) pela cor primária contendo o valor '[{}]' digitado", habitat);
        return ResponseEntity.ok().body(
                birdService.findByHabitatContainingIgnoreCase(habitat)
                        .stream()
                        .map(x -> mapper.map(x, BirdDto.class))
                        .collect(Collectors.toList())
        );
    }


    @ApiOperation(value = "Buscando uma ave pelo id informado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ave encontrada com sucesso."),
            @ApiResponse(code = 404, message = "Ave NÃO encontrada, por favor, verifique o ID e tente novamente.")
    })
    @GetMapping(value = "{id}")
    public ResponseEntity<BirdDto> findById(@PathVariable("id") Integer id){
        log.info("Listando a ave com o id [{}]", id);

        return ResponseEntity.ok().body(mapper.map(birdService.findById(id), BirdDto.class));
    }

    @ApiOperation(value = "Adicionando uma nova ave no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Nova ave adicionada com sucesso."),
            @ApiResponse(code = 400, message = "Espécie de ave já registrada no sistema. Verifique o nome da espécie e tente novamente.")
    })
    @PostMapping
    public  ResponseEntity<BirdDto> create(@RequestBody BirdDto obj){
        log.info("Adicionando uma nova ave com as informações [{}]", obj);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path(ID)
                .buildAndExpand(birdService.create(obj).getId())
                .toUri();

        return ResponseEntity.created(uri).build(); // Will return 201 status
    }

    @ApiOperation(value = "Atualizando uma nova ave no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ave atualizada com sucesso."),
            @ApiResponse(code = 400, message = "Espécie de ave já registrada no sistema com outro ID. Verifique o nome da espécie OU id e tente novamente.")
    })
    @PutMapping(value = ID)
    public ResponseEntity<BirdDto> update(@PathVariable Integer id, @RequestBody BirdDto obj){
        obj.setId(id);
        log.info("Atualizando a ave com ID [{}] com as novas informações: [{}]", id, obj);
        return ResponseEntity.ok()
                .body(mapper.map(birdService.update(obj), BirdDto.class));
    }
    @ApiOperation(value = "Excluindo uma ave pelo id informado.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Ave excluída com sucesso."),
            @ApiResponse(code = 404, message = "Ave NÃO encontrada, por favor, verifique o ID e tente novamente.")
    })
    @DeleteMapping(value = ID)
    public ResponseEntity<BirdDto> delete(@PathVariable Integer id){
        birdService.delete(id);
        log.info("Excluindo a ave com ID [{}] informada", id);
        return ResponseEntity.noContent().build();

    }
}
