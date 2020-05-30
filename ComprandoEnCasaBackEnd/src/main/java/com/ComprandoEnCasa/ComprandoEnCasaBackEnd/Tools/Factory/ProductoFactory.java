package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory;


import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;

public class ProductoFactory {

    public static Producto anyProducto(){
        String nombreProducto = "Sin Nombre";
        String marca = "Sin Marca";
        int stock= 1;
        int precio= 0;
        String imagen ="URL no disponible";
        String categoria ="Sin Categoria";
        long id = 0;
        return new Producto(nombreProducto,marca,stock,precio,imagen,categoria,id);
    }

    private static Producto create (String nombre,String marca, int stock, int precio, String imagen,String categoria, long id){
        return new Producto(nombre,marca,stock,precio,imagen,categoria, id);
    }

    public static Producto createWithNombre (String name){
        return create (name,"Sin Marca",1,0,"URL no disponible","Sin Categoria", 1);
    }

    public static Producto createWithNombreAndMarca (String name, String mark){
        return create(name,mark,1,0,"URL no disponible","Sin Categoria", 2);
    }

    public static Producto createWithPrecio(int price) {
        return create("Sin Nombre","Sin Marca",1,price,"URL no disponible","Sin Catedoria", 3);
    }

    public static Producto createWithPrecioAndCategoria(int price, String categoria) {
        return create("Sin Nombre", "Sin Marca", 1,price,"URL no disponible",categoria, 4);
    }

    public static Producto createWithId(long id){
        return create("Sin nombre", "Sin marca", 1, 0, "URL no disponible", "Sin Categoria", id);
    }


    public static Producto createWithMarca(String marca) {
        return create("Sin Nombre",marca,1,0,"URL no disponible","Sin Categoria",1);
    }

    public static Producto createWithNombreMarcaStockAndPrecio(String name, String mark, int stock, int price) {
        return create(name,mark,stock,price,"URL no disponible","Sin Categoria",1);
    }

    public static Producto createWithCategoria(String categoria) {
        return create("Sin Nombre", "Sin Marca", 1,0,"URL no disponible",categoria,1);
    }
}
