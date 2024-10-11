package fr.fguedouah.hb.geoguessish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private Integer maximumTime;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private Boolean hasMove;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private Boolean hasPan;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private Boolean hasZoom;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonView(JsonViews.GameMinimalView.class)
    private Integer nbRounds;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "game")
    @JsonView(JsonViews.GameListView.class)
    private List<Round> rounds = new ArrayList<>();

    @ManyToOne
    private Map map;


/*    public int getTotalPoints(){
        int totalPoints = 0;
        this.rounds.forEach(round -> {
            totalPoints += round.getPoints();
        });
        return totalPoints;
    }*/

    public int getTotalPoints(){
        int totalPoints = this.rounds.stream().mapToInt(Round::getPoints).sum();
        return totalPoints;
    }

}