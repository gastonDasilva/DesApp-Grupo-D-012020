package model;


import Modelo.App;
import Modelo.Builder.AppBuilder;
import Modelo.Cliente;
import Modelo.Encargado;
import Modelo.Factory.ClienteFactory;
import Modelo.Factory.ProductoFactory;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest extends TestCase {

    //private Cliente gaston;
    //private Encargado oscar;
    //private Producto polenta;
    //private Producto pepsi;
    //private App app;
    private AppBuilder appBuilder = new AppBuilder();


    @Test
    public void testCantidadClientes() {
        App app = appBuilder.build();
        Cliente gaston = ClienteFactory.createWithNombre("Gaston");
        assertEquals(app.cantidadDeClientes() , 0);
        app.agregarCliente(gaston);
        assertEquals(app.cantidadDeClientes() , 1);
    }

    @Test
    public void testDisponibilidadDeUnProducto(){
        //polenta = new Producto("polenta", "presto pronta", 15, 80, "alguna imagen", "alimento");
        Producto polenta = ProductoFactory.createWithNombre("polenta");
        //pepsi = new Producto("gaseosa pepsi", "pepsi", 30, 120, "otra imagen", "bebida sin alcohol");
        Producto pepsi = ProductoFactory.createWithNombreAndMarca("Gaseosa","Pepsi");
        App app = appBuilder.build();
        assertFalse(app.disponibilidadDeProducto(pepsi));
        app.agregarProducto(polenta);
        assertTrue(app.disponibilidadDeProducto(polenta));
        app.agregarProducto(pepsi);
        assertTrue(app.disponibilidadDeProducto(pepsi) );
        app.imprimirProductos();
    }

}
