package com.example.vinayak.WebApp.Converter;


import java.util.Collection;

public interface Converter<E, M> {

    E convertModelToEntity(M model);

    M convertEntityToModel(E entity);

    Collection<E> convertModelToEntity(Collection<M> modelList);

    Collection<M> convertEntityToModel(Collection<E> entityList);

}
