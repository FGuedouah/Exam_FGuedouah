package fr.fguedouah.hb.geoguessish.service;

import fr.fguedouah.hb.geoguessish.dto.CoordinateCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Coordinate;
import fr.fguedouah.hb.geoguessish.repository.CoordinateRepository;
import fr.fguedouah.hb.geoguessish.service.interfaces.RoundAndCoordinateServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CoordinateService implements RoundAndCoordinateServiceInterface<Coordinate, CoordinateCreateDTO> {

    private CoordinateRepository coordinateRepository;

    @Override
    public Coordinate create(CoordinateCreateDTO o) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(o.getLatitude());
        coordinate.setLongitude(o.getLongitude());
        return coordinateRepository.saveAndFlush(coordinate);

    }
}