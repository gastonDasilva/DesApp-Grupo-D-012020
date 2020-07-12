package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


/*@Entity
@Table(name = "BSUsuarioCliente")*/
public class Cliente extends Usuario {

    private Logger log = Logger.getLogger(this.getClass());
    /*@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)*/
    private long ClienteID;


    public Cliente(){}

    public Cliente(String nombre, String email, App app, String calle, Geo coordenadas){
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        //this.setApp(app);
        setCalle(calle);
        this.setListaDeCompras(null);
        this.setMontoGastado(0);
        this.setMontoDeCompra(0);
        this.setHistorialDeCompras(new ArrayList<ListaDeCompras>());
        this.setCoordenadas(coordenadas);
    }
    //duplico para no romper ningun test anterior
    public Cliente(String nombre, String email, String calle, Geo coordenadas){
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        //this.setApp(app);
        this.setCalle(calle);
        this.setListaDeCompras(null);
        this.setMontoGastado(0);
        this.setMontoDeCompra(0);
        this.setHistorialDeCompras(new ArrayList<ListaDeCompras>());
        this.setCoordenadas(coordenadas);
    }

    public void registrarme(App app){
        /*
         * PROP: se crea una lista de compras nuevo, se le asigna dicha lista al cliente
         *       una vez registrado, y por último se agrega al cliente a la lista de clientes
         *       registrados a la aplicación pasada como parámetro.
         */
       // this.setApp(app);
        ListaDeCompras lista = new ListaDeCompras();
        this.setListaDeCompras(lista);
        app.agregarCliente(this);
    }




    public void asignarMontoMaximoEnCategoriaAlimentos(Comercio comercio, int monto){
        // El cliente notifica al sistema el monto máximo a gastar en la categoria alimentos.
        comercio.setMontoMaximoCategoriaAlimentos(monto);
    }



    public void agregarProducto(Producto producto, Comercio comercio){
    /* PROP: si el cliente no tiene asignado una lista de compras, es porque no está registrado y,
             por ende, no puede adquirir determinado producto. Si tiene asignado una lista de compras,
             entonces está registrado, y puede adquirir dicho producto.

    */
    if(this.getListaDeCompras() == null){
        log.trace("tenes que registrarte!");
    }
    else{
        this.verificarUmbralDeProducto(producto, comercio);
     }
    }

    public void verificarUmbralDeProducto(Producto producto, Comercio comercio) {

        switch (producto.getCategoria()) {
            case "Alimento":
                if (this.getMontoAcumuladoEnAlimentos() + producto.getPrecio() > comercio.getMontoMaximoCategoriaAlimentos()) {
                    log.trace("AVISO: superaste el monto maximo de compra en categorias de alimento");
                } else {
                    this.getListaDeCompras().agregarProducto(producto);
                    this.setMontoGastado(this.getMontoGastado() + producto.getPrecio());
                    this.setMontoAcumuladoEnAlimentos(this.getMontoAcumuladoEnAlimentos() + producto.getPrecio());

                }
                break;
            case "Bebida alcoholica":
                if (this.getMontoAcumuladoEnBebidasAlcoholicas() + producto.getPrecio() > comercio.getMontoMaximoCategoriaBebidasAlcoholicas()) {
                    log.trace("AVISO: superaste el monto maximo de compra en categorias de bebidas alcoholicas");
                } else {
                    this.getListaDeCompras().agregarProducto(producto);
                    this.setMontoGastado(this.getMontoGastado() + producto.getPrecio());
                    this.setMontoAcumuladoEnBebidasAlcoholicas(this.getMontoAcumuladoEnBebidasAlcoholicas() + producto.getPrecio());

                }
                break;
            default:
                this.getListaDeCompras().agregarProducto(producto);
                this.setMontoGastado(this.getMontoGastado() + producto.getPrecio());
        }
    }

    public void realizarCompra() {
        if (this.getListaDeCompras().cantidadDeProductosEnLista() == 0) {
            setMontoDeCompra(getMontoGastado()) ;
        } else {
            getHistorialDeCompras().add(getListaDeCompras());
            setMontoDeCompra(getMontoGastado());
            this.setListaDeCompras(new ListaDeCompras());
        }
    }

    public Double distanciaEntreUnaCoordenadaYOtra(Geo geo1, Geo geo2){
        GeoCalculator geoCalculator = new GeoCalculator();
        return geoCalculator.distance(geo1, geo2);
    }

    public Comercio verificarComercioMasCercano(List<Comercio> comercios){
        Comercio comercioRes = comercios.get(0);
        for(Comercio c: comercios){
            if(distanciaEntreUnaCoordenadaYOtra(this.getCoordenadas(), c.getCoordenadas())
                    < distanciaEntreUnaCoordenadaYOtra(this.getCoordenadas(), comercioRes.getCoordenadas())){
                comercioRes = c;
            }
        }
        return comercioRes;
    }
}
