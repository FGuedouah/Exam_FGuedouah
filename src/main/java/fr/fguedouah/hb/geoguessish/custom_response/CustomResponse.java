package fr.fguedouah.hb.geoguessish.custom_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse {

    private int status;

    private String field;

    private Object value;

    private String entity;

}
