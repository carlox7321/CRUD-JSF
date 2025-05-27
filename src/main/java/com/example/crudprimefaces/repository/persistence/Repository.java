package com.example.crudprimefaces.repository.persistence;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface Repository<T> {

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    T findById(Object entityId);

    void delete(T entity);
}
