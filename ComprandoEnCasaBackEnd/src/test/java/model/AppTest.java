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

    private AppBuilder appBuilder = new AppBuilder();

    @Test
    public void testAceptaMedioDePago(){
        App app1 = appBuilder.withMedioDePago("Efectivo").build();
        App app2 = appBuilder.withMedioDePago("Efectivo, Debito").build();
        App app3 = appBuilder.withMedioDePago("Credito, MercadoPago").build();
        assertTrue(app3.aceptaMedioDePago("Credito"));
        assertTrue(app2.aceptaMedioDePago("Debito"));
        assertFalse(app1.aceptaMedioDePago("Cheque"));
        assertEquals(app2.aceptaMedioDePago("Efectivo"),app1.aceptaMedioDePago("Efectivo"));
    }

    @Test
    public void testDentroDelAreaDeEntrega(){
        Float distanciaMaxima = new Float(33);
        App app = appBuilder.withDistanciaMaxima(distanciaMaxima).build();
        assertEquals(app.getDistanciaMaximaEnvio(),distanciaMaxima);
        assertTrue(app.dentroDelAreaDeEnvio(distanciaMaxima));
        assertTrue(app.dentroDelAreaDeEnvio(27));
        assertFalse(app.dentroDelAreaDeEnvio(100));
    }
/*
    @Test
    public void testDebeHaberAlgunEncargado(){
        Encargado oscar = new Encargado("Oscar");
        App app1 = appBuilder.withEncargado(oscar).build();
        App app2 = appBuilder.build();
        assertTrue(app1.debeHaberAlgunEncargado());
        assertFalse(app2.debeHaberAlgunEncargado());
    }
*/

    @Test
    public void testAgregarCliente() {
        App app = appBuilder.build();
        Cliente gaston = ClienteFactory.createWithNombre("Gaston");
        assertEquals(app.cantidadDeClientes() , 0);
        app.agregarCliente(gaston);
        assertEquals(app.cantidadDeClientes() , 1);
    }

    @Test
    public void testCantidadClientes(){
        Cliente gaston = ClienteFactory.anyCliente();
        Cliente alexander = ClienteFactory.anyCliente();
        Cliente tacanio = ClienteFactory.anyCliente();
        List<Cliente> filaPorCuarentena = new ArrayList<Cliente>();
        filaPorCuarentena.add(gaston);
        filaPorCuarentena.add(alexander);
        filaPorCuarentena.add(tacanio);
        App app = appBuilder.withClientes(filaPorCuarentena).build();
        assertEquals(app.cantidadDeClientes(),3);
    }

    @Test
    public void testAgregarProducto(){
        Producto cualquierCosa = ProductoFactory.anyProducto();
        App app = appBuilder.build();
        assertEquals(app.getProductos().size(),0);
        app.agregarProducto(cualquierCosa);
        assertEquals(app.getProductos().size(),1);
    }

    @Test
    public void testDisponibilidadDeUnProducto(){
        Producto polenta = ProductoFactory.createWithNombre("polenta");
        Producto pepsi = ProductoFactory.createWithNombreAndMarca("Gaseosa","Pepsi");
        App app = appBuilder.build();
        assertFalse(app.disponibilidadDeProducto(pepsi));
        app.agregarProducto(polenta);
        assertTrue(app.disponibilidadDeProducto(polenta));
        app.agregarProducto(pepsi);
        assertTrue(app.disponibilidadDeProducto(pepsi) );
        app.imprimirProductos();
    }

    @Test
    public void testVendeProductoNombre(){
        Producto cositoDeLaCosa = ProductoFactory.createWithNombre("Pituto");
        App fereteria = appBuilder.withDeterminadoProducto(cositoDeLaCosa).build();
        assertTrue(fereteria.vendeProductoConNombre("Pituto"));
    }

    @Test
    public void testVendeProductoConMarca(){
        Producto fideos = ProductoFactory.createWithMarca("Mattarazo");
        App app = appBuilder.withDeterminadoProducto(fideos).build();
        assertTrue(app.vendeProductoConMarca("Mattarazo"));
    }

    @Test
    public void testFiltrarProductosConNombre(){
        Producto deCalidad = ProductoFactory.createWithNombreAndMarca("Gaseosa","Pepsi");
        Producto maomemos = ProductoFactory.createWithNombreAndMarca("Gaseosa","Cunnington");
        Producto ysinoquedaotra = ProductoFactory.createWithNombreAndMarca("Gaseosa","Manaos");
        Producto cualquierOtro = ProductoFactory.anyProducto();
        List<Producto> gondola = new ArrayList<Producto>();
        gondola.add(deCalidad); gondola.add(maomemos); gondola.add(ysinoquedaotra);gondola.add(cualquierOtro);
        App app = appBuilder.withProductos(gondola).build();
        List<Producto> busquedaDelCliente = app.filtrarProductosConNombre("Gaseosa");
        assertEquals(busquedaDelCliente.size(),3);
    }

    public void testFiltrarProductosConMarca(){
        //esto es saberse la cancion de maroleo de memoria..
        Producto mate = ProductoFactory.createWithMarca("Maroleo");
        Producto cafe = ProductoFactory.createWithMarca("Maroleo");
        Producto harina = ProductoFactory.createWithMarca("Maroleo");
        Producto palmitos = ProductoFactory.createWithMarca("Maroleo");
        Producto yerba =ProductoFactory.createWithMarca("Maroleo");
        Producto mermelada = ProductoFactory.createWithMarca("Maroleo");
        Producto cacao = ProductoFactory.createWithMarca("Maroleo");
        Producto picadillo = ProductoFactory.createWithMarca("Maroleo");
        Producto unoCualquiera = ProductoFactory.anyProducto();
        Producto otroCualquiera = ProductoFactory.anyProducto();
        List <Producto> mercaderia = new ArrayList<Producto>();
        mercaderia.add(mate);mercaderia.add(cafe);mercaderia.add(harina);mercaderia.add(palmitos);
        mercaderia.add(yerba);mercaderia.add(mermelada);mercaderia.add(cacao); mercaderia.add(picadillo);
        mercaderia.add(unoCualquiera);mercaderia.add(otroCualquiera);
        App maxiconsumo = appBuilder.withProductos(mercaderia).build();
        List <Producto> shingle = maxiconsumo.filtrarProductosConMarca("Maroleo");
        assertEquals(shingle.size(),8);
    }

    /**
     *
     *
     *     public void imprimirProductos()
     *     //polenta = new Producto("polenta", "presto pronta", 15, 80, "alguna imagen", "alimento");
     *     //pepsi = new Producto("gaseosa pepsi", "pepsi", 30, 120, "otra imagen", "bebida sin alcohol");
     *
     *
     */


}
