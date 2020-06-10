package model;


import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.AppBuilder;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.ComercioBuilder;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory.ClienteFactory;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory.ProductoFactory;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.*;
import junit.framework.TestCase;
import org.junit.Test;


public class ClienteTest extends TestCase {

     private ComercioBuilder comercioBuilder = new ComercioBuilder();
     private Comercio comercio = comercioBuilder.build();
     private AppBuilder appBuilder = new AppBuilder();
     private App app = appBuilder.build();


     @Test
     public void testDomicilio(){
         Cliente cliente = ClienteFactory.createWithDireccion("Calle falsa 110");
         assertEquals(cliente.getCalle(),"Calle falsa 110");
     }

     @Test
     public void testRegistrarme(){
         Cliente cliente = ClienteFactory.anyCliente();
         cliente.registrarme(app);
         assertEquals(app.cantidadDeClientes(),1);
         assertEquals(cliente.getListaDeCompras().getMontoAcumulado(),0);
     }

     @Test
     public void testAgregarProducto(){
         Cliente cliente = ClienteFactory.anyCliente();
         cliente.registrarme(app);
         cliente.agregarProducto(ProductoFactory.createWithNombre("Fernet"), comercio);
         assertTrue(cliente.getListaDeCompras().cantidadDeProductosEnLista()==1);
     }


     @Test
     public void testRealizarCompra(){
         Cliente cliente = ClienteFactory.anyCliente();
         cliente.registrarme(app);
         Producto fernet = ProductoFactory.createWithPrecio(250);
         Producto birra = ProductoFactory.createWithPrecio(65);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 0);
         cliente.agregarProducto(fernet, comercio);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 250);
         cliente.agregarProducto(birra, comercio);
         cliente.realizarCompra();
         assertTrue(cliente.getMontoDeCompra() == 315);
     }



     @Test
     public void testVerificarHistorialDeCompras(){
         Cliente cliente = ClienteFactory.anyCliente();
         cliente.registrarme(app);
         Producto fernet = ProductoFactory.createWithPrecio(250);
         Producto birra = ProductoFactory.createWithPrecio(65);
         cliente.realizarCompra();
         cliente.agregarProducto(fernet, comercio);
         cliente.realizarCompra();
         cliente.agregarProducto(birra, comercio);
         cliente.realizarCompra();
         assertEquals(cliente.getHistorialDeCompras().size(), 2);
         for(ListaDeCompras l: cliente.getHistorialDeCompras()){
             System.out.println("el historial es: " + l.cantidadDeProductosEnLista()) ;
         }
     }




    @Test
    public void testMontoGastado(){
        Producto fernet = ProductoFactory.createWithPrecio(250);
        Producto birra = ProductoFactory.createWithPrecio(65);
        Cliente cliente = ClienteFactory.anyCliente();
        cliente.registrarme(app);
        cliente.agregarProducto(fernet, comercio);
        cliente.agregarProducto(birra, comercio);
        assertEquals(cliente.getMontoGastado(),315);

    }


    /*
     @Test
    public void testAgregarProductosYVerificarMontoMaximoPorCategoria(){
         /*
         El sistema va acumulando el monto gastado por el cliente en cada producto dependiendo de la
         categoria a la cual pertenece, y notifica si excedió el monto máximo a la categoria de determinado
         producto.
          *//*
         comercio.setMontoMaximoCategoriaAlimentos(200);
         // Para la categoria de alimentos, el monto maximo a gastar es de $200.
         cliente.registrarme(comercio);
         cliente.agregarProducto(fideos, comercio);
         assertTrue(cliente.getMontoGastado() == 80);
         cliente.agregarProducto(salsaDeTomate, comercio);
         assertTrue(cliente.getMontoGastado() == 140);
         cliente.agregarProducto(queso, comercio);
         assertTrue(cliente.getMontoGastado() == 140);
     }
     */
    @Test
    public void testVerificarMontoMaximoPorCategoria(){
        Producto fideos = ProductoFactory.createWithPrecioAndCategoria(80,"Alimento");
        Producto salsaDeTomate = ProductoFactory.createWithPrecioAndCategoria(60,"Alimento");
        Producto queso = ProductoFactory.createWithPrecioAndCategoria(90,"Alimento");
        Producto birra = ProductoFactory.createWithPrecioAndCategoria(120, "Bebida alcoholica");
        Producto fernet = ProductoFactory.createWithPrecioAndCategoria(290, "Bebida alcoholica");
        comercio.setMontoMaximoCategoriaAlimentos(200);
        comercio.setMontoMaximoCategoriaBebidasAlcoholicas(400);
        Cliente cliente = ClienteFactory.anyCliente(app);
        cliente.registrarme(app);
        cliente.agregarProducto(fideos, comercio);
        cliente.agregarProducto(salsaDeTomate, comercio);
        cliente.agregarProducto(queso, comercio);
        cliente.agregarProducto(fernet, comercio);
        cliente.agregarProducto(birra, comercio);
        assertFalse(cliente.getMontoGastado()>500);
        assertTrue(cliente.getMontoGastado()==430);
        assertEquals(cliente.getListaDeCompras().cantidadDeProductosEnLista(),3);
    }


    @Test
    public void testDistanciaHastaDireccionDelComercio(){
        Geo geo1 = new Geo(-33.58542, -52.832423, "Bernal");
        Cliente cliente = ClienteFactory.createWithCoord(geo1);
        GeoCalculator geoCalculator = new GeoCalculator();
        assertTrue(geoCalculator.distance(cliente.getCoordenadas(), comercio.getCoordenadas()) < 5.0);
        //La distancia entre el cliente y el comercio es menor a 5 kilometros.
    }

    @Test
    public void testVerificarComercioMasCercano(){
        Geo geoCliente = new Geo(-33.558356, -52.864750, "Quilmes");
        Geo geoComercio1 = new Geo(-32.56764, -50.384827, "La Plata");
        Cliente cliente = ClienteFactory.createWithCoord(geoCliente);
        Comercio comercio1 = comercioBuilder.build();
        Comercio comercio2 = comercioBuilder.build();
        comercio1.setCoordenadas(geoComercio1);
        comercio2.setNombreComercio("Chino de la esquina");
        app.agregarComercio(comercio1);
        app.agregarComercio(comercio2);
        cliente.registrarme(app);
        Comercio comercioRes = cliente.verificarComercioMasCercano(app.getComercios());
        assertEquals(comercioRes.getNombreComercio(), "Chino de la esquina");
    }

}
