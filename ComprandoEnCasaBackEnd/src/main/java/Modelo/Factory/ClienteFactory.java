package Modelo.Factory;

import Modelo.App;
import Modelo.Cliente;
import Modelo.ListaDeCompras;
import Modelo.Producto;

public class ClienteFactory {

    public static Cliente anyCliente(App any){
        String direccion = "sin direccion";
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        int montoGastado = 0;
        int montoDeCompra = 0;
        int montoAcumuladoEnAlimentos= 0;

        return new Cliente("Sin Nombre","Sin email",any,"Sin Direccion");
    }

    private static Cliente create (String nombre,String email, App app, String direccion){
        return new Cliente(nombre,email,app,direccion);
    }

    public static Cliente createWithNombreAndApp (String name, App app){
        return create (name,"Sin email",app,"Sin Direccion");
    }

}
