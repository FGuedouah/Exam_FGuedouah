package fr.fguedouah.hb.geoguessish.controller_rest;

import fr.fguedouah.hb.geoguessish.dto.CoordinateCreateDTO;
import fr.fguedouah.hb.geoguessish.dto.RoundCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Coordinate;
import fr.fguedouah.hb.geoguessish.entity.Round;
import fr.fguedouah.hb.geoguessish.service.CoordinateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coordinate")
public class CoordinateRestController {

    CoordinateService coordinateService;

    @PostMapping
    public Coordinate create(@RequestBody CoordinateCreateDTO dto) {
        return coordinateService.create(dto);
    }
}
