package fr.fguedouah.hb.geoguessish.service.interfaces;

import java.util.List;

public interface ServiceListInterface<T, L, C, U> extends ServiceInterface<T, L, C, U>  {

    List<?> list();

}
