package Modelo.Builder;

import Modelo.App;
import Modelo.Cliente;
import Modelo.Encargado;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;

import java.util.ArrayList;
import java.util.List;

public class AppBuilder {


    private String rubro = "alimentos/bebidas";
    private String domicilio = "alberdi 333";
    private String diasYHorariosDeAtencion = "lunes a viernes de 10 a 20 hs";
    private String mediosDePago = "efectivo, debito";
    private float distanciaMaximaEnvio = 3;
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private Encargado encargado;
    private List<Producto> productos = new ArrayList<Producto>();
    private int montoMaximoCategoriaAlimentos=0;

    private Encargado oscar = new Encargado("oscar", "20-30656734-5", "oscar@gmail.com");
    //private Cliente gaston = new Cliente("gaston", "gaston@gmail.com", app, "alberdi 330");
    private  Producto polenta = new Producto("polenta", "presto pronta", 15, 80, "alguna imagen", "alimento");
    private  Producto pepsi = new Producto("gaseosa pepsi", "pepsi", 30, 120, "otra imagen", "bebida sin alcohol");

    public App build(){
        App app = new App(rubro,domicilio,diasYHorariosDeAtencion,mediosDePago,distanciaMaximaEnvio,oscar);
        app.setClientes(clientes);//en principio una lista vacia
        app.setProductos(productos); //en principio una lista vacia
        app.setMontoMaximoCategoriaAlimentos(montoMaximoCategoriaAlimentos);
        return app;
    }

    public AppBuilder withRubro (final  String unRubro){
       rubro = unRubro;
       return this;
    }

    public AppBuilder withDomicilio (final  String unDomicilio){
        domicilio = unDomicilio;
        return this;
    }

    public AppBuilder withDiasYhorarios (final  String unHorario){
        diasYHorariosDeAtencion = unHorario;
        return this;
    }

    public AppBuilder withMedioDePago (final  String unMedioDePago){
        mediosDePago = unMedioDePago;
        return this;
    }

    public AppBuilder withDistanciaMaxima (final  float unaDistancia){
        distanciaMaximaEnvio = unaDistancia;
        return this;
    }

    public AppBuilder withEncargado (final  Encargado unEncargado){
        encargado = unEncargado;
        return this;
    }

    public AppBuilder withProductos (final List<Producto> unaLista){
        productos = unaLista;
        return this;
    }

    public AppBuilder withDeterminadoProducto (final Producto unProducto){
        productos.add(unProducto);
        return this;
    }

    public AppBuilder withClientes (final List<Cliente> unaLista){
        clientes = unaLista;
        return this;
    }

    public AppBuilder withDeterminadoCliente (final Cliente unCliente){
        clientes.add(unCliente);
        return this;
    }

}
