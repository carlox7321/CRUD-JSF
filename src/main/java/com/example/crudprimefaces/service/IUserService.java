package com.example.crudprimefaces.service;

import com.example.crudprimefaces.model.User;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface IUserService {

    User guardar(User user);

    User editar(User user);

    void eliminar(User user);

    List<User> findAllUsers();

    Optional<User> buscarPorUserName(String userName);
}
