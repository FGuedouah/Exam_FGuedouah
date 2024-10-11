package fr.fguedouah.hb.geoguessish.service;

import fr.fguedouah.hb.geoguessish.dto.GameCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Game;
import fr.fguedouah.hb.geoguessish.repository.GameRepository;
import fr.fguedouah.hb.geoguessish.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameService implements ServiceListInterface<Game, String, GameCreateDTO, GameCreateDTO> {

    private GameRepository gameRepository;
    private MapService mapService;
//    private RoundService roundService;

    @Override
    public Game create(GameCreateDTO object) {
        Game game = new Game();
        game.setMaximumTime(object.getMaximumTime());
        game.setHasMove(object.getHasMove());
        game.setHasPan(object.getHasPan());
        game.setHasZoom(object.getHasZoom());
        game.setCreatedAt(LocalDateTime.now());
        game.setMap(mapService.findOneById(object.getMapId()));
        game.setNbRounds(object.getNbRound());
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public Game update(GameCreateDTO o, String id) {
        return null;
    }

    @Override
    public Game findOneById(String id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }

    @Override
    public List<Game> list() {
        return gameRepository.findAll();
    }
}