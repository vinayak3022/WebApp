package com.example.vinayak.WebApp.Service;

import java.util.Collection;

public interface BaseService<M> {

    M createOrUpdate(M model);

    M findById(Integer id);

    Collection<M> list();

    Collection<M> list(Integer offset, Integer limit);
}
