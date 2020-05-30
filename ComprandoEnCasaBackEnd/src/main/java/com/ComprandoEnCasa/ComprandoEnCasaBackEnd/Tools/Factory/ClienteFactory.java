package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Cliente;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Geo;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.App;

public class ClienteFactory {

    public static Cliente anyCliente(App any){
        String direccion = "sin direccion";
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        int montoGastado = 0;
        int montoDeCompra = 0;
        int montoAcumuladoEnAlimentos= 0;
        int montoAcumuladoEnBebidasAlcoholicas = 0;
        Geo coord = new Geo(-0.0, -0.2, "Sin nombre");

        return new Cliente("Sin Nombre","Sin email",any,"Sin Direccion", coord);
    }

    public static Cliente anyCliente(){
        String direccion = "sin direccion";
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        int montoGastado = 0;
        int montoDeCompra = 0;
        int montoAcumuladoEnAlimentos= 0;
        int montoAcumuladoEnBebidasAlcoholicas = 0;
        Geo coord = new Geo(-0.1, -0.4, "Sin nombre");

        return new Cliente("Sin Nombre","Sin email","Sin Direccion", coord);
    }

    private static Cliente create (String nombre,String email,  String direccion, Geo geo){
        return new Cliente(nombre,email,direccion, geo);
    }

    public static Cliente createWithNombre (String name){
        return create (name,"Sin email","Sin Direccion", new Geo(-0.3, -0.4, "sin nombre"));
    }

    public static Cliente createWithDireccion( String address){
        return create("Sin Nombre","Sin email",address, new Geo(-0.1, -0.5, "sin nombre"));
    }

    public static Cliente createWithCoord(Geo geo){
        return create("Sin Nombre", "Sin email", "Sin direccion", geo);
    }

}
