package Modelo.Factory;

import Modelo.Producto;

public class ProductoFactory {

    public static Producto anyProducto(){
        String nombreProducto = "Sin Nombre";
        String marca = "Sin Marca";
        int stock= 0;
        int precio= 0;
        String imagen ="URL no disponible";
        String categoria ="Sin Categoria";
        return new Producto(nombreProducto,marca,stock,precio,imagen,categoria);
    }

    private static Producto create (String nombre,String marca, int stock, int precio, String imagen,String categoria){
        return new Producto(nombre,marca,stock,precio,imagen,categoria);
    }

    public static Producto createWithNombre (String name){
        return create (name,"Sin Marca",0,0,"URL no disponible","Sin Categoria");
    }

    public static Producto createWithNombreAndMarca (String name, String mark){
        return create(name,mark,0,0,"URL no disponible","Sin Categoria");
    }

}
