package fr.fguedouah.hb.geoguessish.controller_rest;

import fr.fguedouah.hb.geoguessish.dto.GameCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Game;
import fr.fguedouah.hb.geoguessish.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/game")
public class GameRestController {

    private final GameService gameService;

    @PostMapping
    public Game create(@RequestBody GameCreateDTO dto) {
        return gameService.create(dto);
    }

    @GetMapping
    public List<Game> list(){
        return gameService.list();
    }

    @GetMapping("/{id}")
    public Game show(@RequestParam String id){
        return gameService.findOneById(id);
    }

}
