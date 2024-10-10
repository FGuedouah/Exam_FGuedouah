package fr.fg.hb.starter_pack_springboot.service.interfaces;

public interface DTOMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);

}
