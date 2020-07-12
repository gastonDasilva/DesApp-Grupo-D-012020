package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import org.uqbar.commons.model.UserException;

public class App {

    private Logger log = Logger.getLogger(this.getClass());

    private List<Comercio> comercios;
    private List<Cliente> clientes;

    public List<Comercio> getComercios() { return comercios; }

    public void setComercios(List<Comercio> comercios) { this.comercios = comercios; }

    public List<Cliente> getClientes() { return clientes; }

    public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }


    public App(List<Comercio> comercios, List<Cliente> clientes){
        this.setComercios(comercios);
        this.setClientes(clientes);
    }

    public void agregarCliente(Cliente cliente){
        this.getClientes().add(cliente);
    }

    public int cantidadDeClientes(){
        return this.getClientes().size();
    }

    public void agregarComercio(Comercio comercio){ this.getComercios().add(comercio);}

    public int cantidadDeComercios(){ return this.getComercios().size();}

    public Cliente comprar(Cliente cliente){
        for (Producto p: cliente.getListaDeCompras().getProductosAcumulados()){
            if (p.getStock() == 0){
                throw new UserException("No hay Stock!");
            }else{
                p.setStock(p.getStock() - 1);
            }
        }
        ListaDeCompras listaNueva = new ListaDeCompras();
        cliente.setListaDeCompras(listaNueva);
        return cliente;
    }

    public Producto buscarProductoPorCodigo(Long cod){
        Producto prod = null;
        for (Comercio c: this.comercios){
            prod = c.buscarProductoPorCodigo(cod);
        }
        if(prod == null){
            log.trace("No se encontro el producto con id: " + cod);
            return prod;
        }
        return prod;
    }

    public List<Producto> buscarProductosComercio(String nombreComercio){
        List<Producto> productos = new ArrayList<Producto>();
        for(Comercio c: this.comercios){
            if(c.getNombreComercio() == nombreComercio){
                productos = c.getProductos();
            }
        }
        return productos;
    }

    public List<Producto> buscarProductosEnComercioPorTextoIngresado(String nombreComercio, String txt){
        List<Producto> productos = this.buscarProductosComercio(nombreComercio);
        if(txt == ""){
           return productos;
        } else{
            List<Producto> resultado = new ArrayList<Producto>();
            for(Producto p: productos){
                if(p.getNombreProducto().contains(txt)){
                    resultado.add(p);
                }
            }
            return resultado;
        }
    }

}
