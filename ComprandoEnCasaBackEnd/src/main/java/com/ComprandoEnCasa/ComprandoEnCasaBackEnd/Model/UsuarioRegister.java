package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioRegister {

    @Size(min = 5, max = 10, message = "El número de caracteres no es permitido, debe estar entre 5 y 10")
    @NotEmpty(message = "El campo username no debe ser vacio")
    private String username;
    @Email(message = "No es una direccion de correo bien formada")
    private String email;
    private String password;
    @NotEmpty(message = "El campo address no debe ser vacio")
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public UsuarioRegister(String username, String email, String password, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
