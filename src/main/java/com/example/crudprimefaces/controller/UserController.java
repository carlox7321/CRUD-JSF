package com.example.crudprimefaces.controller;

import com.example.crudprimefaces.model.User;
import com.example.crudprimefaces.service.IUserService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named(value = "userBean")
@ViewScoped
@Getter
@Setter
public class UserController implements Serializable {

    @EJB
    private IUserService userService;

    private User user;

    private List<User> users;


    @PostConstruct
    public void init() {
        System.out.println("Init UserController - userService is null? " + (userService == null));
        users = userService.findAllUsers();
    }

    public void nuevoUsuario() {
        user = new User();
    }

    public void guardarUsuario() {
        if (user.getId() == null) {
            userService.guardar(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario agregado."));
        } else {
            userService.editar(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario modificado."));
        }
        nuevoUsuario(); // Limpia el formulario
        users = userService.findAllUsers();
        PrimeFaces.current().executeScript("PF('dlgUsuarioRegistro').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");
    }

    public void eliminar() {
        userService.eliminar(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario eliminado."));
        users =  userService.findAllUsers(); // Recarga lista

        //Forma de ejeuctar acciones en front desde back
        PrimeFaces.current().ajax().update("form:messages", "form:table-user");
    }

}
