package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys;

import Modelo.Categoria;
import Modelo.Factory.CategoriaFactory;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BSProducto")
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombreProducto;

    private String marca;
    private int stock;
    private int precio;
    private String imagen;
    private String categoria;

    private Categoria clasificacion;

    // campos de oferta
    public String tipoDeDescuento;
    public int cantidadLlevada;
    public int porcentaje;
    public LocalDate desde;
    public LocalDate hasta;


    public Producto() {}

    public Producto(String nombre){
        this.setNombreProducto(nombre);
    }

    public Producto(String nombre, String marca, int stock, int precio, String imagen, String categoria){

        this.setNombreProducto(nombre);
        this.setMarca(marca);
        this.setStock(stock);
        this.setPrecio(precio);
        this.setImagen(imagen);
        this.setCategoria(categoria);
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio - this.aplicarDescuento();
    }

    public String getImagen() {
        return imagen;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        this.clasificacion = CategoriaFactory.getCategoria(categoria);
    }

    public void imprimirEnPantalla() {
        System.out.print("[");
        System.out.print("Nombre del producto: "+ this.getNombreProducto());
        System.out.print(" ,Marca: "+ this.getMarca());
        System.out.print(" ,stock: "+this.getStock());
        System.out.println(" ,precio:"+ this.getPrecio());
        System.out.println("]");
    }


    public void establecerOferta(String tipoDescuento, LocalDate aPartir, LocalDate finaliza){
        desde = aPartir;
        hasta = finaliza;
        tipoDeDescuento = tipoDescuento;
    }

    public boolean ofertaVigente(){
        return LocalDate.now().isAfter(this.desde) && LocalDate.now().isBefore(hasta);
    }

    private int aplicarDescuento() {
        int monto = 0;
        int precioAnterior = this.precio;
        if (ofertaVigente()){
            switch (tipoDeDescuento){
                case "Descuento por Unidad":
                    monto = precioAnterior * this.porcentaje /100;
                    break;
                case "2x1":
                    if ((cantidadLlevada % 2 )== 0){
                        monto = precioAnterior * 50 / 100;
                    }
                    break;
                default:
                    throw new IllegalStateException("No se encuentra oferta");

            }
        }
        return monto;
    }


}