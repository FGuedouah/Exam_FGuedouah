package fr.fguedouah.hb.geoguessish.service.interfaces;

import java.util.List;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id);

    T findOneById(L id);

}
