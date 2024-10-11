package fr.fguedouah.hb.geoguessish.service;

import fr.fguedouah.hb.geoguessish.dto.user.UserCreateDTO;
import fr.fguedouah.hb.geoguessish.entity.User;
import fr.fguedouah.hb.geoguessish.repository.UserRepository;
import fr.fguedouah.hb.geoguessish.service.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements ServiceInterface<User, String, UserCreateDTO, User>, UserDetailsService {

    private UserRepository userRepository;


    @Override
    public User create(UserCreateDTO o) {
        return null;
    }

    @Override
    public User update(User object, String id) {
        object.setId(id);
        userRepository.flush();
        return object;
    }

    @Override
    public User findOneById(String id) {
        return null;
    }



    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Echec de la connexion"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()
        );
    }
}