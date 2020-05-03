package model;

import Modelo.Factory.ProductoFactory;
import Modelo.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ListaDeComprasTest2 extends TestCase {

    private ListaDeCompras listaDeCompras;


    @Before
    public void setUp() throws Exception {

        listaDeCompras = new ListaDeCompras();
    }

    @Test
    public void testCantidadDeProductosEnLista() {
        assertTrue(listaDeCompras.cantidadDeProductosEnLista() == 0);
        Producto jamon = ProductoFactory.anyProducto();
        Producto atun = ProductoFactory.anyProducto();
        listaDeCompras.agregarProducto(jamon);
        listaDeCompras.agregarProducto(atun);
        assertEquals(listaDeCompras.cantidadDeProductosEnLista(),2);
    }


    @Test
    public void testMontoAcumuladoEnLista() {
        assertTrue(listaDeCompras.getMontoAcumulado() == 0);
        Producto pancho = ProductoFactory.createWithPrecio(50);
        Producto pepsi = ProductoFactory.createWithPrecio(25);
        listaDeCompras.agregarProducto(pancho);
        listaDeCompras.agregarProducto(pepsi);
        assertEquals(listaDeCompras.getMontoAcumulado(),75);
    }


    public void testProductosAcumulados(){
        Producto lavandina = ProductoFactory.anyProducto();
        Producto trapoDePiso = ProductoFactory.anyProducto();
        Producto guantes = ProductoFactory.anyProducto();
        ListaDeCompras laMismaLista = new ListaDeCompras();
        ArrayList<Producto> chango = new ArrayList<Producto>();
        listaDeCompras.agregarProducto(lavandina);
        listaDeCompras.agregarProducto(trapoDePiso);
        listaDeCompras.agregarProducto(guantes);
        chango.add(trapoDePiso);
        chango.add(guantes);
        chango.add(lavandina);
        laMismaLista.setProductosAcumulados(chango);
        assertTrue(listaDeCompras.getProductosAcumulados().size()==3);
        assertEquals(laMismaLista.getProductosAcumulados().size(),3);
    }

    public void testAgregarProducto(Producto producto){
        assertEquals(listaDeCompras.cantidadDeProductosEnLista(),0);
        listaDeCompras.agregarProducto(producto);
        assertEquals(listaDeCompras,1);
    }

}
