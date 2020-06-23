package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

public class UsuarioSimpleLogin {

    private Long id;
    private String username;
    private String email;
    private boolean esComercio;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEsComercio() {
        return esComercio;
    }

    public void setEsComercio(boolean esComercio) {
        this.esComercio = esComercio;
    }

    public UsuarioSimpleLogin(Long id, String username, String email, boolean esComercio) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.esComercio = esComercio;
    }
}
