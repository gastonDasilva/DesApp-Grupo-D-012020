package Tools.Builder;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;

public class ProductoBuilder {
    private String nombreProducto = "sin nombre";
    private String marca = "sin marca";
    private int stock = 1;
    private int precio = 1;
    private String imagen = "url no asignada";
    private String categoria = "sin categoria";

    //no es necesario
   /* public static ProductoBuilder aProducto() {
        return new ProductoBuilder();
    }*/

    public Producto build() {

        /*Producto producto = new Producto(nombreProducto);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setImagen(imagen);
        producto.setMarca(marca);
        producto.setPrecio(precio);*/
        //es lo mismo que hacer
        // Producto(String nombre, String marca, int stock, int precio, String imagen, String categoria, Long id)
        long identificador = new Long(1);
        Producto producto = new Producto(nombreProducto,marca,stock,precio,imagen,categoria,identificador);
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
