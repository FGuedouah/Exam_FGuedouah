package fr.fguedouah.hb.geoguessish.controller_rest;

import com.fasterxml.jackson.annotation.JsonView;

import fr.fguedouah.hb.geoguessish.dto.user.UserCreateDTO;
import fr.fguedouah.hb.geoguessish.dto.user.UserLoginDTO;
import fr.fguedouah.hb.geoguessish.entity.User;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import fr.fguedouah.hb.geoguessish.response.JwtResponse;
import fr.fguedouah.hb.geoguessish.security.JwtAuthenticatorService;
import fr.fguedouah.hb.geoguessish.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityRestController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/api/register")
    @JsonView(JsonViews.UserShowView.class)
    public User register(@Valid @RequestBody UserCreateDTO user) {
        return userService.create(user);
    }

    @PostMapping("/api/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody UserLoginDTO user) {
        return jwtAuthenticatorService.authenticate(user);
    }

}