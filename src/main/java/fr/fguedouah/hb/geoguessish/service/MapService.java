package fr.fguedouah.hb.geoguessish.service;

import fr.fguedouah.hb.geoguessish.dto.MapCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.Map;
import fr.fguedouah.hb.geoguessish.repository.MapRepository;
import fr.fguedouah.hb.geoguessish.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class MapService implements ServiceListInterface<Map, Long, MapCreateDTO, MapCreateDTO> {

    private MapRepository mapRepository;

    @Override
    public Map create(MapCreateDTO o) {
        Map map = new Map();
        map.setCreatedAt(LocalDateTime.now());
        map.setName(o.getName());
        return mapRepository.saveAndFlush(map);

    }

    @Override
    public Map update(MapCreateDTO o, Long id) {
        Map map = findOneById(id);
        map.setName(o.getName());
        return mapRepository.saveAndFlush(map);
    }

    @Override
    public Map findOneById(Long id) {
        return mapRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Map not found"));
    }


    @Override
    public List<Map> list() {
        return mapRepository.findAll();
    }
}