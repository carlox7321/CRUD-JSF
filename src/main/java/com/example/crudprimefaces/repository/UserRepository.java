package com.example.crudprimefaces.repository;

import com.example.crudprimefaces.model.User;
import com.example.crudprimefaces.repository.persistence.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.Optional;

@Stateless
public class UserRepository extends CrudRepository<User> {
    public UserRepository() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Optional<User> findByUserName(String userName) {
        try {
            User result = getEntityManager()
                    .createQuery("SELECT e FROM User e WHERE e.username = :username", User.class)
                    .setParameter("username", userName)
                    .getSingleResult();
            return Optional.of(result);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
