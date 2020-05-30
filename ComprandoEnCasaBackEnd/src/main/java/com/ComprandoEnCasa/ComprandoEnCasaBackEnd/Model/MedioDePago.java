package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

public class MedioDePago {
    private String nombre;
    private String imagen;

    public MedioDePago(String nombre, String imagen){
        this.imagen = imagen;
        this.nombre = nombre;
    };

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esElMismoMedioDePago(MedioDePago otro){

        return this.getNombre().contains(otro.getNombre());
    }
}
