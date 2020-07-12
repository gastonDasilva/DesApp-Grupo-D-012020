package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Geo;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {
    private String nombreUsuario = "";
    private String email = "";
    private String password = "";
    private String imagenPerfil = "";
    private ListaDeCompras listaDeCompras = null; /*Vendria a hacer la tarea de carrito de compras.*/
    private List<ListaDeCompras> historialDeCompras = new ArrayList<ListaDeCompras>();
    private Geo coordenadas = null;
    private String direccionCalle = "";
    private String localidad = "";
    private String pais = "";
    private String provincia = "";
    private String horarioYDIaAtencion;
    private  int codigoPostal = 0;

    public Usuario build() {
        Usuario user = new Usuario(nombreUsuario,email,password);
        user.setImagenPerfil(imagenPerfil);
        user.setCoordenadas(coordenadas);
        user.setHistorialDeCompras(historialDeCompras);
        user.setListaDeCompras(listaDeCompras);
        user.setCalle(direccionCalle);
        user.setCodigoPostal(codigoPostal);
        user.setLocalidad(localidad);
        user.setPais(pais);
        user.setProvincia(provincia);
        return user;
    }

    public UsuarioBuilder withNombreUsuario(String name){
        this.nombreUsuario = name;
        return this;
    }
    public UsuarioBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public UsuarioBuilder withPassword(String password){
        this.password = password;
        return this;
    }
    public UsuarioBuilder withImagenPerfil(String imagenPerfil){
        this.imagenPerfil = imagenPerfil;
        return this;
    }
    public UsuarioBuilder withListaDeCompras(ListaDeCompras listaDeCompras){
        this.listaDeCompras = listaDeCompras;
        return this;
    }

    public UsuarioBuilder withHistorialDeCompras(List<ListaDeCompras> historialDeCompras){
        this.historialDeCompras = historialDeCompras;
        return this;
    }

    public UsuarioBuilder withCoordenadas(Geo coordenadas){
        this.coordenadas = coordenadas;
        return this;
    }

    public UsuarioBuilder withDireccionCalle(String calle){
        this.direccionCalle = calle;
        return this;
    }
}
