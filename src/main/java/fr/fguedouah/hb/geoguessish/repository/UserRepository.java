package fr.fguedouah.hb.geoguessish.repository;

import jakarta.persistence.*;
import fr.fguedouah.hb.geoguessish.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}