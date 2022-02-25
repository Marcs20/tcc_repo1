package com.teste.app1.service;

import java.util.List;

public interface ServiceInterface<T>{
    T create(T obj);
    T findById(Long id);
    List<T> findAll();
    T update(T obj);
    boolean delete(Long id);
}
