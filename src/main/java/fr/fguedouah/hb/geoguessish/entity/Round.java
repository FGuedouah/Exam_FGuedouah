package fr.fguedouah.hb.geoguessish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.fguedouah.hb.geoguessish.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.GameListView.class)
    private Long id;

    @JsonView(JsonViews.GameListView.class)
    private Integer points;

    @JsonView(JsonViews.GameListView.class)
    private Integer time;

    private Long distance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Coordinate selected;

    @ManyToOne
    private Coordinate origin;
}