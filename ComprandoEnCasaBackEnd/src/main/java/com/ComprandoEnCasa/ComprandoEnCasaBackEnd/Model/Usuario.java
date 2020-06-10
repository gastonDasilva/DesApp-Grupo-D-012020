package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BSUsuario")
public  class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nombreUsuario;
    private String email;
    private String password;
    private String imagenPerfil;

    protected String Calle ;
    protected String localidad ;
    protected String provincia ;
    protected String pais ;
    protected int codigoPostal;

    private int montoGastado;
    private int montoDeCompra;
    private int montoAcumuladoEnAlimentos;
    private int montoAcumuladoEnBebidasAlcoholicas;
    @OneToOne
    private ListaDeCompras listaDeCompras; /*Vendria a hacer la tarea de carrito de compras.*/

    @OneToMany(targetEntity = ListaDeCompras.class)
    @JoinColumn(name="ldc_fk",referencedColumnName = "id")
    private List<ListaDeCompras> historialDeCompras;

    @OneToOne
    private Geo coordenadas;


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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public int getMontoAcumuladoEnAlimentos() {
        return montoAcumuladoEnAlimentos;
    }

    public void setMontoAcumuladoEnAlimentos(int montoAcumuladoEnAlimentos) {
        this.montoAcumuladoEnAlimentos = montoAcumuladoEnAlimentos;
    }

    public int getMontoAcumuladoEnBebidasAlcoholicas() {
        return montoAcumuladoEnBebidasAlcoholicas;
    }

    public void setMontoAcumuladoEnBebidasAlcoholicas(int montoAcumuladoEnBebidasAlcoholicas) {
        this.montoAcumuladoEnBebidasAlcoholicas = montoAcumuladoEnBebidasAlcoholicas;
    }

    public int getMontoDeCompra() {
        return montoDeCompra;
    }

    public void setMontoDeCompra(int montoDeCompra) {
        this.montoDeCompra = montoDeCompra;
    }

    public int getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(int montoGastado) {
        this.montoGastado = montoGastado;
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