package fr.fguedouah.hb.geoguessish.controller_rest;

import com.fasterxml.jackson.annotation.JsonView;
import fr.fguedouah.hb.geoguessish.dto.GameCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Game;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import fr.fguedouah.hb.geoguessish.service.GameService;
import io.swagger.v3.core.util.Json;
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
    @JsonView(JsonViews.GameMinimalView.class)
    public List<Game> list(){
        return gameService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.GameListView.class)
    public Game show(@RequestParam String id){
        return gameService.findOneById(id);
    }

}
