package AppTest;


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

public class AppTest2 extends TestCase {

    //private Cliente gaston;
    //private Encargado oscar;
    //private Producto polenta;
    //private Producto pepsi;
    //private App app;
    private AppBuilder appBuilder = new AppBuilder();


    @Test
    public void testCantidadClientes() {
        App app = appBuilder.build();
        Cliente gaston = ClienteFactory.createWithNombreAndApp("Gaston",app);
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

    /*

    public void setUp(){

        oscar = new Encargado("oscar", "20-30656734-5", "oscar@gmail.com");
        app = new App("alimentos/bebidas", "alberdi 333", "lunes a viernes de 10 a 20 hs", "efectivo, debito", 3, oscar);
        gaston = new Cliente("gaston", "gaston@gmail.com", app, "alberdi 330");
        polenta = new Producto("polenta", "presto pronta", 15, 80, "alguna imagen", "alimento");
        pepsi = new Producto("gaseosa pepsi", "pepsi", 30, 120, "otra imagen", "bebida sin alcohol");


    }

*/

}
