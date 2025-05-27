package com.example.crudprimefaces.service.impl;

import com.example.crudprimefaces.model.User;
import com.example.crudprimefaces.repository.UserRepository;
import com.example.crudprimefaces.service.IUserService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class UserServiceImpl implements IUserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User guardar(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editar(User user) {
        return userRepository.update(user);
    }

    @Override
    public void eliminar(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> buscarPorUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
