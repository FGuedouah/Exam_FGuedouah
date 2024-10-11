package fr.fguedouah.hb.geoguessish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordinateCreateDTO {

    private String latitude;

    private String longitude;
}
