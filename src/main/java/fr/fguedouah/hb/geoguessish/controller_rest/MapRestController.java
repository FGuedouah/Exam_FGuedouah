package fr.fguedouah.hb.geoguessish.controller_rest;

import fr.fguedouah.hb.geoguessish.dto.GameCreateDTO;
import fr.fguedouah.hb.geoguessish.dto.MapCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Game;
import fr.fguedouah.hb.geoguessish.entity.Map;
import fr.fguedouah.hb.geoguessish.service.MapService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/map")
public class MapRestController {

    MapService mapService;

    @PostMapping
    public Map create(@RequestBody MapCreateDTO dto) {
        return mapService.create(dto);
    }

    @GetMapping
    public List<Map> list(){
        return mapService.list();
    }

    @GetMapping("/{id}")
    public Map show(@RequestParam Long id){
        return mapService.findOneById(id);
    }

    @PutMapping("/{id}")
    public Map update(@RequestBody MapCreateDTO dto, @PathVariable Long id) {
        return mapService.update(dto, id);
    }



}
