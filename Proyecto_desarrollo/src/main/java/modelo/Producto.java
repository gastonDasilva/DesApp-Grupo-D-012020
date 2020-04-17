package modelo;


public class Producto {

    private String nombreProducto;
    private String marca;
    private int stock;
    private int precio;
    private String imagen;

    public Producto() {}

    public Producto(String nombre, String marca, int stock, int precio, String imagen){

        this.setNombreProducto(nombre);
        this.setMarca(marca);
        this.setStock(stock);
        this.setPrecio(precio);
        this.setImagen(imagen);
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
}
