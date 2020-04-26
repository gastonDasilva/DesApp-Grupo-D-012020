package Modelo;

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
    private  ArrayList<Producto> productosAVender = new ArrayList<Producto>();

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

    public void agregarMedioDePago(MedioDePago me){
        /*Agrego un nuevo  medio de pago*/
        getMediosDePago().add(me);
    }

    public void darDeAltaUnProducto(Producto pr){
        /*Doy de alta un nuevo producto para un comercio*/
        getProductosAVender().add(pr);
    }

}