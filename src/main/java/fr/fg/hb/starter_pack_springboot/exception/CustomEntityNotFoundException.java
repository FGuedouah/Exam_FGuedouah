package fr.fg.hb.starter_pack_springboot.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomEntityNotFoundException extends EntityNotFoundException {

    private String field;

    private Object value;

    private String entity;

}
