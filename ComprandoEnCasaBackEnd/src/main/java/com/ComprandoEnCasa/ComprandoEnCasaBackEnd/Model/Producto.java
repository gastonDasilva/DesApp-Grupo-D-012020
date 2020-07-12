package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;


import javax.persistence.*;
import org.apache.log4j.Logger;

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
    private int cantidadAComprar = 1; /*Atributo que permite elegir al cliente cuanta cantidad de este producto quiere.*/

    //@ManyToOne(targetEntity = Categoria.class)



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

    public Producto(String nombre, String marca, int stock, int precio, String imagen, String categoria, Long id){

        this.setNombreProducto(nombre);
        this.setMarca(marca);
        this.setStock(stock);
        this.setPrecio(precio);
        this.setImagen(imagen);
        this.setCategoria(categoria);
        this.setId(id);
    }

    public int getCantidadAComprar() {
        return cantidadAComprar;
    }

    public void setCantidadAComprar(int cantidadAComprar) {
        this.cantidadAComprar = cantidadAComprar;
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
        return precio;
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
    }

    public void imprimirEnPantalla() {
        Logger log = Logger.getLogger(this.getClass());
        log.trace("[");
        log.trace("Nombre del producto: "+ this.getNombreProducto());
        log.trace(" ,Marca: "+ this.getMarca());
        log.trace(" ,stock: "+this.getStock());
        log.trace(" ,precio:"+ this.getPrecio());
        log.trace("]");
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }
}