package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BSUsuario")
public  class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    protected String nombreUsuario;
    protected String email;
    protected String password;
    protected String imagenPerfil;
    @OneToOne
    public ListaDeCompras listaDeCompras; /*Vendria a hacer la tarea de carrito de compras.*/

    @OneToMany(targetEntity = ListaDeCompras.class)
    @JoinColumn(name="ldc_fk",referencedColumnName = "id")
    public List<ListaDeCompras> historialDeCompras;

    @OneToOne
    public Geo coordenadas;


    public Usuario(){};

    public Usuario(String name,String email, String pas, String image ){
        setNombreUsuario(name);
        setEmail(email);
        setPassword(pas);
        setImagenPerfil(image);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ListaDeCompras> getHistorialDeCompras() {
        return historialDeCompras;
    }

    public void setHistorialDeCompras(List<ListaDeCompras> historialDeCompras) {
        this.historialDeCompras = historialDeCompras;
    }

    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public Geo getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Geo coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
}