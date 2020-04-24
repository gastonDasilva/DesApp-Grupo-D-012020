package appTest;


import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

public class ClienteTest extends TestCase {

     private Encargado encargado;
     private Cliente cliente;
     private App app;
     private Producto fernet;
     private Producto birra;


     @Before
     public void setUp() throws Exception {
         encargado = new Encargado("pedro", "20-32546894-6", "pedro@gmail.com");
         app = new App("alimentos/bebidas", "calle falsa 123", "lunes a sabados de 9 a 21 hs", "efectivo", 5, encargado);
         cliente = new Cliente("cacho","cacho@gmail.com", app,"calle falsa 110");
         fernet = new Producto("fernet branca", "branca", 20, 250, "una imagen");
         birra = new Producto("cerveza", "quilmes", 30, 65, "otra imagen");
     }

     @Test
     public void testDomicilio(){ assertTrue(cliente.getDireccion() == "calle falsa 110");}

     @Test
     public void testRegistrarme(){
         cliente.registrarme(app);
         assertTrue(app.cantidadDeClientes() == 1);
         assertTrue(cliente.getListaDeCompras().getMontoAcumulado() == 0);
     }

     @Test
     public void testAgregarProducto(){
         //cliente.agregarProducto(fernet);    --> Primero debe registrarse!
         cliente.registrarme(app);
         cliente.agregarProducto(fernet);
         assertTrue(cliente.getListaDeCompras().cantidadDeProductosEnLista() == 1);
     }

     @Test
     public void testRealizarCompra(){
         cliente.registrarme(app);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 0);
         cliente.agregarProducto(fernet);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 250);
         cliente.agregarProducto(birra);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 315);
     }

     @Test
     public void testMontoGastado(){
         /*
         El sistema va calculando el monto gastado mientras el comprador ingresa productos en su lista de compra.
         */
         cliente.registrarme(app);
         cliente.agregarProducto(fernet);
         assertTrue(cliente.getMontoGastado() == 250);
         cliente.agregarProducto(birra);
         assertTrue(cliente.getMontoGastado() == 315);
     }
}
