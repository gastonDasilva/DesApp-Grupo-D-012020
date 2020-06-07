package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;


import javax.persistence.*;

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
        System.out.print("[");
        System.out.print("Nombre del producto: "+ this.getNombreProducto());
        System.out.print(" ,Marca: "+ this.getMarca());
        System.out.print(" ,stock: "+this.getStock());
        System.out.println(" ,precio:"+ this.getPrecio());
        System.out.println("]");
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }
}