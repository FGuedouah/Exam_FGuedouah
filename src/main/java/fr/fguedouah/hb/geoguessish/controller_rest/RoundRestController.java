package fr.fguedouah.hb.geoguessish.controller_rest;

import fr.fguedouah.hb.geoguessish.dto.MapCreateDTO;
import fr.fguedouah.hb.geoguessish.dto.RoundCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Game;
import fr.fguedouah.hb.geoguessish.entity.Map;
import fr.fguedouah.hb.geoguessish.entity.Round;
import fr.fguedouah.hb.geoguessish.service.RoundService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/round")
public class RoundRestController {

    RoundService roundService;

    @PostMapping
    public Round create(@RequestBody RoundCreateDTO dto) {
        return roundService.create(dto);
    }

}
