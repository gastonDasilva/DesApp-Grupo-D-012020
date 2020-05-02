package model;


import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import org.junit.Test;
import junit.framework.TestCase;
import Modelo.*;

public class AppTest extends TestCase {

    private Cliente gaston;
    private Encargado oscar;
    private Producto polenta;
    private Producto pepsi;
    private App app;

    public void setUp(){

        oscar = new Encargado("oscar", "20-30656734-5", "oscar@gmail.com");
        app = new App("alimentos/bebidas", "alberdi 333", "lunes a viernes de 10 a 20 hs", "efectivo, debito", 3, oscar);
        gaston = new Cliente("gaston", "gaston@gmail.com", app, "alberdi 330");
        polenta = new Producto("polenta", "presto pronta", 15, 80, "alguna imagen", "alimento");
        pepsi = new Producto("gaseosa pepsi", "pepsi", 30, 120, "otra imagen", "bebida sin alcohol");


    }

    @Test
    public void testCantidadClientes() {
        assertTrue(app.cantidadDeClientes() == 0);
        app.agregarCliente(gaston);
        assertTrue(app.cantidadDeClientes() == 1);
    }

    @Test
    public void testDisponibilidadDeUnProducto(){
        assertTrue(app.disponibilidadDeProducto(pepsi) == false);
        app.agregarProducto(polenta);
        assertTrue(app.disponibilidadDeProducto(polenta) == true);
        app.agregarProducto(pepsi);
        assertTrue(app.disponibilidadDeProducto(pepsi) == true);
        app.imprimirProductos();
    }


}
