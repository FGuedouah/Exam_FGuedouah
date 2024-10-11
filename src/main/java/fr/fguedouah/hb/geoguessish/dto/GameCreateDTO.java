package fr.fguedouah.hb.geoguessish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameCreateDTO {

    private Boolean hasPan;

    private Boolean hasZoom;

    private Boolean hasMove;

    private int maximumTime;

    private String userId;

    private Long mapId;

    private int nbRound;
}
