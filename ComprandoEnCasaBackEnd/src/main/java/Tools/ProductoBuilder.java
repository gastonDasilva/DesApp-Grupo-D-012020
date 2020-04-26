package Tools;

import Modelo.Encargado;
import Modelo.Producto;

public class ProductoBuilder {
    private String nombreProducto;
    private String marca;
    private int stock;
    private int precio;
    private String imagen;
    private String categoria;

    public static ProductoBuilder aProducto() {
        return new ProductoBuilder();
    }

    public Producto build() {

        Producto producto = new Producto(nombreProducto);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setImagen(imagen);
        producto.setMarca(marca);
        producto.setPrecio(precio);
        return producto;
    }
    public ProductoBuilder withNombreProducto(String aValue){
        nombreProducto = aValue;
        return this;
    }


    public ProductoBuilder withMarca(String aValue){
        marca = aValue;
        return this;
    }
    public ProductoBuilder withStock(int aValue){
        stock = aValue;
        return this;
    }

    public ProductoBuilder withPrecio(int aValue){
        precio = aValue;
        return this;
    }

    public ProductoBuilder withImagen(String aValue){
        imagen = aValue;
        return this;
    }
    public ProductoBuilder withCategoria(String aValue){
        categoria = aValue;
        return this;
    }




}
