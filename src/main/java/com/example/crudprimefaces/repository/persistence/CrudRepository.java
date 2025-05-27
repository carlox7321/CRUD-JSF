package com.example.crudprimefaces.repository.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public abstract class CrudRepository<T> implements Repository<T> {

    private final Class<T> entityClass;

    public CrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "PU_Practica")
    protected EntityManager em;

    protected abstract EntityManager getEntityManager();

    @Override
    public List<T> findAll() {
        CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public T findById(Object entityId) {
        return getEntityManager().find(entityClass, entityId);
    }


    @Override
    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

}
