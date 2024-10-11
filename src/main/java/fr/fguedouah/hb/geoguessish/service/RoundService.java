package fr.fguedouah.hb.geoguessish.service;

import fr.fguedouah.hb.geoguessish.dto.RoundCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Coordinate;
import fr.fguedouah.hb.geoguessish.entity.Round;
import fr.fguedouah.hb.geoguessish.repository.CoordinateRepository;
import fr.fguedouah.hb.geoguessish.repository.RoundRepository;
import fr.fguedouah.hb.geoguessish.service.interfaces.RoundServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class RoundService implements RoundServiceInterface<Round, RoundCreateDTO> {

    private RoundRepository roundRepository;
    private CoordinateRepository coordinateRepository;
    private GameService gameService;

    @Override
    public Round create(RoundCreateDTO o) {
        Random random = new Random();
        List<Coordinate> coordinates = coordinateRepository.findAll();
        Coordinate coordinate = coordinates.get(random.nextInt(0, (coordinates.size() - 1)));

        Round round  = new Round();
        round.setGame(gameService.findOneById(o.getGameId()));
        round.setCreatedAt(LocalDateTime.now());
        round.setOrigin(coordinate);
        return roundRepository.saveAndFlush(round);
    }




}