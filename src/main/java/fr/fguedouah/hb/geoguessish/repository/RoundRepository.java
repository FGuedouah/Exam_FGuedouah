package fr.fguedouah.hb.geoguessish.repository;

import jakarta.persistence.*;
import fr.fguedouah.hb.geoguessish.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}