package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import org.eclipse.xtext.xbase.lib.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Encargado extends Usuario {

    private String cuil;
    private Map<Date,String> horariosYDias = new HashMap<Date, String>();
    private int telefono;
    private String domicilio;
    private ArrayList<MedioDePago> mediosDePago = new ArrayList<MedioDePago>();
    private ArrayList<Producto> productosAVender = new ArrayList<Producto>();
    private ArrayList<Pair<Producto, Producto>> productosEnOfertaPor2 = new ArrayList<Pair<Producto,Producto>>();

    public Encargado(String nombre){
        this.setNombreUsuario(nombre);
    }

    public Encargado(String nombre, String cuil, String email) {
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        this.setCuil(cuil);
    }

    public Map<Date, String> getHorariosYDias() {
        return horariosYDias;
    }

    public void setHorariosYDias(Map<Date, String> horariosYDias) {
        this.horariosYDias = horariosYDias;
    }
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }

    public void setMediosDePago(ArrayList<MedioDePago> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    public ArrayList<Producto> getProductosAVender() {
        return productosAVender;
    }

    public void setProductosAVender(ArrayList<Producto> productosAVender) {
        this.productosAVender = productosAVender;
    }

    public ArrayList<Pair<Producto, Producto>> getProductosEnOfertaPor2() {
        return productosEnOfertaPor2;
    }

    public void setProductosEnOfertaPor2(ArrayList<Pair<Producto, Producto>> productosEnOfertaPor2) {
        this.productosEnOfertaPor2 = productosEnOfertaPor2;
    }

    public void agregarMedioDePago(MedioDePago me){
        /*Agrego un nuevo  medio de pago*/
        getMediosDePago().add(me);
    }

    public void darDeAltaUnProducto(Producto pr){
        /*Doy de alta un nuevo producto para un comercio*/
        getProductosAVender().add(pr);
    }

    public void darDeAltaDosProductosEnOferta(Producto p1, Producto p2){
        /* Doy de alta una combinación de 2 productos en oferta para un comercio */
        Pair<Producto, Producto> oferta = new Pair<Producto, Producto>(p1, p2);
        getProductosEnOfertaPor2().add(oferta);
    }

    public int sumatoriaDeTodosLosPrecios(){
        int result = 0;
        for(Producto p: this.getProductosAVender()){
            result +=  p.getPrecio();
        }
        return result;
    }

    public int sumatoriaDeTodosLosProductosEnOfertaPor2(){
        int result = 0;
        for(Pair <Producto, Producto> p : this.getProductosEnOfertaPor2()){
            result = result + p.getKey().getPrecio() + p.getValue().getPrecio();
        }
        return result;
    }

    public int aplicarDescuento(int importe, int descuento){
        int descuentoAplicado = (importe * descuento) / 100;
        return (importe - descuentoAplicado);
    }

    public void crearOfertaPorCategoria(int descuento, String categoria){
        for(Producto p: this.getProductosAVender()){
            if(p.getCategoria() == categoria){
                p.setPrecio(this.aplicarDescuento(p.getPrecio(), descuento));
            }
        }
    }

    public void crearOfertaPorCombinacionDe2Productos(int descuento){
        /*
         Se aplica el descuento a cada producto de las tuplas de productos (oferta por combinación
         de 2 productos).
         */
        for(Pair <Producto, Producto> p : this.getProductosEnOfertaPor2()){
            p.getKey().setPrecio(this.aplicarDescuento(p.getKey().getPrecio(), descuento));
            p.getValue().setPrecio(this.aplicarDescuento(p.getValue().getPrecio(), descuento));
        }
    }

    public void crearOferetaPorProducto(Producto producto, int descuento){
        for(Producto p: this.getProductosAVender()){
            if(p.equals(producto)){
                p.setPrecio(this.aplicarDescuento(p.getPrecio(), descuento));
            }
        }
    }

    public void modificarDatosDeProducto(Producto product,long id, String name, String marca, int stock, int price, String image, String categoria){
        product.setId(id);
        product.setNombreProducto(name);
        product.setMarca(marca);
        product.setStock(stock);
        product.setPrecio(price);
        product.setImagen(image);
        product.setCategoria(categoria);
    }

}