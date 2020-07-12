package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;
import org.uqbar.commons.model.UserException;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;

public class Comercio extends Usuario {

    private Logger log = Logger.getLogger(this.getClass());

    private String nombreComercio;
    private String rubro;
    private String domicilio;
    private String horariosYDiasDeAtencion;
    private String mediosDePago;
    private float distanciaMaximaEnvio;
    private List<Producto> productos;
    private int montoMaximoCategoriaAlimentos;
    private int montoMaximoCategoriaBebidasAlcoholicas;
    private Geo coordenadas;
    private Encargado encargado;

    public String getNombreComercio() { return nombreComercio; }

    public void setNombreComercio(String nombreComercio) { this.nombreComercio = nombreComercio; }

    public String getRubro() {
        return rubro;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getHorariosYDiasDeAtencion() {
        return horariosYDiasDeAtencion;
    }

    public String getMediosDePago() {
        return mediosDePago;
    }

    public float getDistanciaMaximaEnvio() {
        return distanciaMaximaEnvio;
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setHorariosYDiasDeAtencion(String horariosYDiasDeAtencion) {
        this.horariosYDiasDeAtencion = horariosYDiasDeAtencion;
    }

    public void setMediosDePago(String mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    public void setDistanciaMaximaEnvio(float distanciaMaximaEnvio) {
        this.distanciaMaximaEnvio = distanciaMaximaEnvio;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getMontoMaximoCategoriaAlimentos() { return montoMaximoCategoriaAlimentos; }

    public void setMontoMaximoCategoriaAlimentos(int montoMaximoCategoriaAlimentos) { this.montoMaximoCategoriaAlimentos = montoMaximoCategoriaAlimentos; }

    public int getMontoMaximoCategoriaBebidasAlcoholicas() {
        return montoMaximoCategoriaBebidasAlcoholicas;
    }

    public void setMontoMaximoCategoriaBebidasAlcoholicas(int montoMaximoCategoriaBebidasAlcoholicas) {
        this.montoMaximoCategoriaBebidasAlcoholicas = montoMaximoCategoriaBebidasAlcoholicas;
    }

    public Geo getCoordenadas() { return coordenadas; }

    public void setCoordenadas(Geo coordenadas) { this.coordenadas = coordenadas; }

    public Encargado getEncargado() { return encargado; }

    public void setEncargado(Encargado encargado) { this.encargado = encargado; }

    public Comercio(String nombre, String rubro, String domicilio, String diasYHorariosDeAtencion, String mediosDePago, float distancia, Geo coordenadas, Encargado encargado){

        this.setNombreComercio(nombre);
        this.setRubro(rubro);
        this.setDomicilio(domicilio);
        this.setHorariosYDiasDeAtencion(diasYHorariosDeAtencion);
        this.setMediosDePago(mediosDePago);
        this.setDistanciaMaximaEnvio(distancia);
        this.setProductos(new ArrayList<Producto>());
        this.setMontoMaximoCategoriaAlimentos(0); // Este valor lo setea e cliente
        this.setMontoMaximoCategoriaBebidasAlcoholicas(0);
        this.setCoordenadas(coordenadas);
        this.setEncargado(encargado);
    }


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


    public boolean disponibilidadDeProducto(Producto producto){
        // Producto disponible o no en la lista de productos del comercio.
        return this.getProductos().contains(producto);
    }


    public void agregarProducto(Producto producto){
        this.getProductos().add(producto);
    }



    public Producto buscarProductoPorCodigo(long cod){
        Producto prod = null;
        for(Producto p: this.productos){
            if(p.getId() == cod){
                prod = p;
            }
        }
        if(prod == null){
            log.trace("No se encontro el producto con id: " + cod);
            return prod;
        }
        return prod;
    }

    public List<Producto> buscarProductosPorTextoIngresado(String txt){

        List<Producto> result = new ArrayList<Producto>();
        for(Producto p: this.productos){
            if(p.getNombreProducto().contains(txt)){
                result.add(p);
            }
        }
        if(txt.equals("")){
            result = this.productos;
        }
        return result;
    }


    public void imprimirProductos() {
        int contador= 0;
        String palabraProducto = "Producto nro ";
        String palabraImpresa;
        for(Producto p : productos) {
            contador++;
            palabraImpresa = palabraProducto.concat(Integer.toString(contador));
            log.trace(palabraImpresa);
            p.imprimirEnPantalla();
        }
        log.trace("Cantidad de productos listados: "+ Integer.toString(contador));
    }

    public boolean aceptaMedioDePago(String esteMedioDePago){
        return this.mediosDePago.contains(esteMedioDePago);
    }

    public boolean dentroDelAreaDeEnvio (float distanciaEntreElDomicilioYElLocal){
        return distanciaEntreElDomicilioYElLocal<= distanciaMaximaEnvio;
    }


    public boolean vendeProductoConNombre (String nombre){
        boolean encontro = false;
        for (Producto p: productos){
            if (p.getNombreProducto().contains(nombre)){
                encontro = true;
            }
        }
        return encontro;
    }

    public List<Producto> filtrarProductosConNombre(String nombre){
        List<Producto> filtro = new ArrayList<Producto>();
        for (Producto p: productos){
            if (p.getNombreProducto().contains(nombre)){
                filtro.add(p);
            }
        }
        return filtro;
    }

    public boolean vendeProductoConMarca (String marca){
        boolean encontro = false;
        for (Producto p: productos){
            if (p.getMarca().contains(marca)){
                encontro = true;
            }
        }
        return encontro;
    }

    public List<Producto> filtrarProductosConMarca(String marca) {
        List<Producto> filtro = new ArrayList<Producto>();
        for (Producto p : productos) {
            if (p.getMarca().contains(marca)) {
                filtro.add(p);
            }
        }
        return filtro;
    }

    public void modificarDatosDelProducto(long id, String name, String marca, int stock, int price, String image, String categoria, long newId){
        for(Producto p: this.getProductos()){
            if(p.getId() == id){
                this.getEncargado().modificarDatosDeProducto(p, newId, name, marca, stock, price, image, categoria);
            }
        }
    }


}
