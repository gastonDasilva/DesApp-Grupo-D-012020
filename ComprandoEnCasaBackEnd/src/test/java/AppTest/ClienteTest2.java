package AppTest;


import Modelo.*;
import Modelo.Builder.AppBuilder;
import Modelo.Factory.ClienteFactory;
import Modelo.Factory.ProductoFactory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClienteTest2 extends TestCase {

     private AppBuilder appBuilder = new AppBuilder();
     private App app = appBuilder.build();

     /*
     private Encargado encargado;
     private Cliente cliente;

     private Producto fernet;
     private Producto birra;
     private Producto fideos;
     private Producto salsaDeTomate;
     private Producto queso;

      */



     /*
     @Before
     public void setUp() throws Exception {
         encargado = new Encargado("pedro", "20-32546894-6", "pedro@gmail.com");
         app = new App("alimentos/bebidas", "calle falsa 123", "lunes a sabados de 9 a 21 hs", "efectivo", 5, encargado);
         cliente = new Cliente("cacho","cacho@gmail.com", app,"calle falsa 110");
         fernet = new Producto("fernet branca", "branca", 20, 250, "una imagen", "bebida alcoholica");
         birra = new Producto("cerveza", "quilmes", 30, 65, "otra imagen", "bebida alcoholica");
         fideos = new Producto("fideo en tallarin","matarazzo", 20, 80, "imagen3", "alimento");
         salsaDeTomate = new Producto("salsa pal fideo", "molto", 25, 60, "imagen4", "alimento");
         queso = new Producto("queso cremoso", "sancor", 30, 90, "imagen5", "alimento");
     }
      */


     /*
     @Test
     public void testDomicilio(){ assertTrue(cliente.getDireccion() == "calle falsa 110");}
      */
     @Test
     public void testDomicilio(){
         Cliente cliente = ClienteFactory.createWithAppAndDireccion(app,"Calle falsa 110");
         assertEquals(cliente.getDireccion(),"Calle falsa 110");
     }


     /*
     @Test
     public void testRegistrarme(){
         cliente.registrarme(app);
         assertTrue(app.cantidadDeClientes() == 1);
         assertTrue(cliente.getListaDeCompras().getMontoAcumulado() == 0);
     }
      */

     @Test
     public void testRegistrarme(){
         Cliente cliente = ClienteFactory.anyCliente(app);
         cliente.registrarme(app);
         assertEquals(app.cantidadDeClientes(),1);
         assertEquals(cliente.getListaDeCompras().getMontoAcumulado(),0);
     }


     /*
     @Test
     public void testAgregarProducto(){
         //cliente.agregarProducto(fernet);    --> Primero debe registrarse!
         cliente.registrarme(app);
         cliente.agregarProducto(fernet, app);
         assertTrue(cliente.getListaDeCompras().cantidadDeProductosEnLista() == 1);
     }*/

     @Test
     public void testAgregarProducto(){
         Cliente cliente = ClienteFactory.anyCliente(app);
         cliente.registrarme(app);
         cliente.agregarProducto(ProductoFactory.createWithNombre("Fernet"),app);
         assertTrue(cliente.getListaDeCompras().cantidadDeProductosEnLista()==1);
     }

     /*
     @Test
     public void testRealizarCompra(){
         cliente.registrarme(app);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 0);
         cliente.agregarProducto(fernet, app);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 250);
         cliente.agregarProducto(birra, app);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 315);
     }

      */

     @Test
     public void testRealizarCompra(){
         Cliente cliente = ClienteFactory.anyCliente(app);
         cliente.registrarme(app);
         Producto fernet = ProductoFactory.createWithPrecio(250);
         Producto birra = ProductoFactory.createWithPrecio(65);
         cliente.realizarCompra();
         assertEquals(cliente.getMontoDeCompra(),0);
         cliente.agregarProducto(fernet,app);
         assertEquals(cliente.getMontoDeCompra(),250);
         cliente.agregarProducto(birra,app);
         assertEquals(cliente.getMontoDeCompra(),315);
     }



     /*
     @Test
     public void testMontoGastado(){
         /*
         El sistema va calculando el monto gastado mientras el comprador ingresa productos en su lista de compra.
         *//*
         cliente.registrarme(app);
         cliente.agregarProducto(fernet, app);
         assertTrue(cliente.getMontoGastado() == 250);
         cliente.agregarProducto(birra, app);
         assertTrue(cliente.getMontoGastado() == 315);
     }*/

    @Test
    public void testMontoGastado(){
        ListaDeCompras chango = new ListaDeCompras();
        Producto fernet = ProductoFactory.createWithPrecio(250);
        Producto birra = ProductoFactory.createWithPrecio(65);
        chango.agregarProducto(fernet); chango.agregarProducto(birra);
        Cliente cliente = ClienteFactory.createWithAppAndProductos(app,chango);
        assertTrue(cliente.getMontoGastado()==315);
    }


    /*
     @Test
    public void testAgregarProductosYVerificarMontoMaximoPorCategoria(){
         /*
         El sistema va acumulando el monto gastado por el cliente en cada producto dependiendo de la
         categoria a la cual pertenece, y notifica si excedió el monto máximo a la categoria de determinado
         producto.
          *//*
         app.setMontoMaximoCategoriaAlimentos(200);
         // Para la categoria de alimentos, el monto maximo a gastar es de $200.
         cliente.registrarme(app);
         cliente.agregarProducto(fideos, app);
         assertTrue(cliente.getMontoGastado() == 80);
         cliente.agregarProducto(salsaDeTomate, app);
         assertTrue(cliente.getMontoGastado() == 140);
         cliente.agregarProducto(queso, app);
         assertTrue(cliente.getMontoGastado() == 140);
     }
     */
    /*@Test
    public void testAgregarProductosYVerificarMontoMaximoPorCategoria(){

    }

     */

}
