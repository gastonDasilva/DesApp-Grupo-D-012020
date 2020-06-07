package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Comercio;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Encargado;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Geo;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ComercioBuilder {


    private String nombre = "oktubre";
    private String rubro = "alimentos/bebidas";
    private String domicilio = "alberdi 333";
    private String diasYHorariosDeAtencion = "lunes a viernes de 10 a 20 hs";
    private String mediosDePago = "efectivo, debito";
    private float distanciaMaximaEnvio = 3;
    private List<Producto> productos = new ArrayList<Producto>();
    private int montoMaximoCategoriaAlimentos=0;
    private long id0 = 0;
    private long id1 = 1;

    private Geo coord = new Geo(-33.562397, -52.873047, "Quilmes");
    private Encargado oscar = new Encargado("oscar", "20-30656734-5", "oscar@gmail.com");

    public Comercio build(){
        Comercio comercio = new Comercio(nombre,rubro,domicilio,diasYHorariosDeAtencion,mediosDePago,distanciaMaximaEnvio, coord, oscar);
        comercio.setProductos(productos); //en principio una lista vacia
        comercio.setMontoMaximoCategoriaAlimentos(montoMaximoCategoriaAlimentos);
        return comercio;
    }

    public ComercioBuilder withRubro (final  String unRubro){
       rubro = unRubro;
       return this;
    }

    public ComercioBuilder withDomicilio (final  String unDomicilio){
        domicilio = unDomicilio;
        return this;
    }

    public ComercioBuilder withDiasYhorarios (final  String unHorario){
        diasYHorariosDeAtencion = unHorario;
        return this;
    }

    public ComercioBuilder withMedioDePago (final  String unMedioDePago){
        mediosDePago = unMedioDePago;
        return this;
    }

    public ComercioBuilder withDistanciaMaxima (final  float unaDistancia){
        distanciaMaximaEnvio = unaDistancia;
        return this;
    }


    public ComercioBuilder withProductos (final List<Producto> unaLista){
        productos = unaLista;
        return this;
    }

    public ComercioBuilder withDeterminadoProducto (final Producto unProducto){
        productos.add(unProducto);
        return this;
    }
}
