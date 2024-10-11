package fr.fguedouah.hb.geoguessish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.json.JSONArray;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.GameListView.class)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String avatar ;

    @Column(nullable = false)
    private LocalDate birthedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonView(JsonViews.GameListView.class)
    private Integer level;

    @Column(nullable = false)
    private String roles;


    @OneToMany(mappedBy = "user")
    private List<Game> games = new ArrayList<>();


    public Boolean isAdmin(){
        return this.roles.contains("ADMIN_ROLE");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        JSONArray roles = new JSONArray(this.roles);
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        });
        return authorities;
    }
}