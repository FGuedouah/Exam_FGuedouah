package fr.fguedouah.hb.geoguessish.controller_rest;


import com.fasterxml.jackson.annotation.JsonView;
import fr.fguedouah.hb.geoguessish.entity.User;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import fr.fguedouah.hb.geoguessish.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    UserService userService;

    @GetMapping("/me")
    @JsonView(JsonViews.UserShowView.class)
    public User show(Principal principal) {
        return userService.show(principal);
    }

}
