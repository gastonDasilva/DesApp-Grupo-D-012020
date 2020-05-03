package Modelo.Factory;

import Modelo.App;
import Modelo.Cliente;
import Modelo.ListaDeCompras;


import java.util.List;

public class ClienteFactory {

    public static Cliente anyCliente(App any){
        String direccion = "sin direccion";
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        int montoGastado = 0;
        int montoDeCompra = 0;
        int montoAcumuladoEnAlimentos= 0;

        return new Cliente("Sin Nombre","Sin email",any,"Sin Direccion");
    }

    public static Cliente anyCliente(){
        String direccion = "sin direccion";
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        int montoGastado = 0;
        int montoDeCompra = 0;
        int montoAcumuladoEnAlimentos= 0;

        return new Cliente("Sin Nombre","Sin email","Sin Direccion");
    }

    private static Cliente create (String nombre,String email,  String direccion){
        return new Cliente(nombre,email,direccion);
    }

    public static Cliente createWithNombre (String name){
        return create (name,"Sin email","Sin Direccion");
    }

    public static Cliente createWithDireccion( String address){
        return create("Sin Nombre","Sin email",address);
    }



}
