package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Categorias;

public abstract class Categoria {
    String denominacion;
    boolean oferta2x1 = false;
    boolean segundoConDescuento = false;
    boolean descuentoPorUnidad = false;
    int porcentajeDeDescuento = 0;
    int acumulablePorCategoria; //por ej 2 x 1

    public boolean estaDeOferta() {
        return (oferta2x1 || segundoConDescuento || descuentoPorUnidad);
    }

    public abstract void setDenominacion();

    public boolean esIgualCategoria(Categoria cat) {
        return this.denominacion.contains(cat.denominacion);
    }

    public int getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }

    public void setPorcentajeDeDescuento(int unPorcentaje) {
        porcentajeDeDescuento = unPorcentaje;
    }

    public int getAcumulablePorCategoria() {
        return acumulablePorCategoria;
    }

    public void setAcumulablePorCategoria(int cuantos) {
        acumulablePorCategoria = cuantos;
    }

    public void establecerOferta2x1() {
        this.oferta2x1 = true;
    }

    public void desestablecerOferta2x1() {
        this.oferta2x1 = false;
    }

    public void establecerSegudoConDescuento() {
        this.segundoConDescuento = true;
    }

    public void desestablecerSegundoConDescuento() {
        this.segundoConDescuento = false;
    }

    public void establecerDescuentoPorUnidad() {
        this.descuentoPorUnidad =true;
    }
    public void desestablecerDescuentoPorUnidad(){
        this.descuentoPorUnidad = false;
    }


}
