package model;


import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Comercio;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.ComercioBuilder;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory.ProductoFactory;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComercioTest extends TestCase {

    private ComercioBuilder comercioBuilder = new ComercioBuilder();

    @Test
    public void testAceptaMedioDePago(){
        Comercio comercio1 = comercioBuilder.withMedioDePago("Efectivo").build();
        Comercio comercio2 = comercioBuilder.withMedioDePago("Efectivo, Debito").build();
        Comercio comercio3 = comercioBuilder.withMedioDePago("Credito, MercadoPago").build();
        assertTrue(comercio3.aceptaMedioDePago("Credito"));
        assertTrue(comercio2.aceptaMedioDePago("Debito"));
        assertFalse(comercio1.aceptaMedioDePago("Cheque"));
        assertEquals(comercio2.aceptaMedioDePago("Efectivo"), comercio1.aceptaMedioDePago("Efectivo"));
    }

    @Test
    public void testDentroDelAreaDeEntrega(){
        Float distanciaMaxima = new Float(33);
        Comercio comercio = comercioBuilder.withDistanciaMaxima(distanciaMaxima).build();
        assertEquals(comercio.getDistanciaMaximaEnvio(),distanciaMaxima);
        assertTrue(comercio.dentroDelAreaDeEnvio(distanciaMaxima));
        assertTrue(comercio.dentroDelAreaDeEnvio(27));
        assertFalse(comercio.dentroDelAreaDeEnvio(100));
    }


    @Test
    public void testAgregarProducto(){
        Producto cualquierCosa = ProductoFactory.anyProducto();
        Comercio comercio = comercioBuilder.build();
        assertEquals(comercio.getProductos().size(),0);
        comercio.agregarProducto(cualquierCosa);
        assertEquals(comercio.getProductos().size(),1);
    }

    @Test
    public void testDisponibilidadDeUnProducto(){
        Producto polenta = ProductoFactory.createWithNombreMarcaStockAndPrecio("polenta", "Presto Pronta", 15, 80);
        Producto pepsi = ProductoFactory.createWithNombreMarcaStockAndPrecio("Gaseosa","Pepsi",30,120);
        Comercio comercio = comercioBuilder.build();
        assertFalse(comercio.disponibilidadDeProducto(pepsi));
        comercio.agregarProducto(polenta);
        assertTrue(comercio.disponibilidadDeProducto(polenta));
        comercio.agregarProducto(pepsi);
        assertTrue(comercio.disponibilidadDeProducto(pepsi) );
        comercio.imprimirProductos();
    }

    @Test
    public void testVendeProductoNombre(){
        Producto cositoDeLaCosa = ProductoFactory.createWithNombre("Pituto");
        Comercio fereteria = comercioBuilder.withDeterminadoProducto(cositoDeLaCosa).build();
        assertTrue(fereteria.vendeProductoConNombre("Pituto"));
    }

    @Test
    public void testVendeProductoConMarca(){
        Producto fideos = ProductoFactory.createWithMarca("Mattarazo");
        Comercio comercio = comercioBuilder.withDeterminadoProducto(fideos).build();
        assertTrue(comercio.vendeProductoConMarca("Mattarazo"));
    }

    @Test
    public void testFiltrarProductosConNombre(){
        Producto deCalidad = ProductoFactory.createWithNombreAndMarca("Gaseosa","Pepsi");
        Producto maomemos = ProductoFactory.createWithNombreAndMarca("Gaseosa","Cunnington");
        Producto ysinoquedaotra = ProductoFactory.createWithNombreAndMarca("Gaseosa","Manaos");
        Producto cualquierOtro = ProductoFactory.anyProducto();
        List<Producto> gondola = new ArrayList<Producto>();
        gondola.add(deCalidad); gondola.add(maomemos); gondola.add(ysinoquedaotra);gondola.add(cualquierOtro);
        Comercio comercio = comercioBuilder.withProductos(gondola).build();
        List<Producto> busquedaDelCliente = comercio.filtrarProductosConNombre("Gaseosa");
        assertEquals(busquedaDelCliente.size(),3);
    }

    public void testFiltrarProductosConMarca() {
        //esto es saberse la cancion de maroleo de memoria..
        Producto mate = ProductoFactory.createWithMarca("Maroleo");
        Producto cafe = ProductoFactory.createWithMarca("Maroleo");
        Producto harina = ProductoFactory.createWithMarca("Maroleo");
        Producto palmitos = ProductoFactory.createWithMarca("Maroleo");
        Producto yerba = ProductoFactory.createWithMarca("Maroleo");
        Producto mermelada = ProductoFactory.createWithMarca("Maroleo");
        Producto cacao = ProductoFactory.createWithMarca("Maroleo");
        Producto picadillo = ProductoFactory.createWithMarca("Maroleo");
        Producto unoCualquiera = ProductoFactory.anyProducto();
        Producto otroCualquiera = ProductoFactory.anyProducto();
        List<Producto> mercaderia = new ArrayList<Producto>();
        mercaderia.add(mate);
        mercaderia.add(cafe);
        mercaderia.add(harina);
        mercaderia.add(palmitos);
        mercaderia.add(yerba);
        mercaderia.add(mermelada);
        mercaderia.add(cacao);
        mercaderia.add(picadillo);
        mercaderia.add(unoCualquiera);
        mercaderia.add(otroCualquiera);
        Comercio maxiconsumo = comercioBuilder.withProductos(mercaderia).build();
        List<Producto> shingle = maxiconsumo.filtrarProductosConMarca("Maroleo");
        assertEquals(shingle.size(), 8);
    }

        @Test
    public void testBuscarProductoPorCodigo(){
        long idFind = 1;
        Producto arroz = ProductoFactory.createWithId(0);
        Producto vino = ProductoFactory.createWithId(1);
        Comercio comercio = comercioBuilder.build();
        comercio.agregarProducto(arroz);
        comercio.agregarProducto(vino);
        assertEquals(comercio.buscarProductoPorCodigo(idFind), vino);
    }

    @Test
    public void testBuscarProductosPorTextoIngresado(){
        Producto birra = ProductoFactory.createWithNombre("cerveza");
        Producto fideos = ProductoFactory.createWithNombre("fideos");
        Producto yerba = ProductoFactory.createWithNombre("yerba");
        Comercio comercio = comercioBuilder.build();
        comercio.agregarProducto(birra);
        comercio.agregarProducto(fideos);
        comercio.agregarProducto(yerba);
        List<Producto> result = comercio.buscarProductosPorTextoIngresado("a");
        assertEquals(result.size(), 2);
        List<Producto> result2 = comercio.buscarProductosPorTextoIngresado("fid");
        assertEquals(result2.size(), 1);
        }

    @Test
    public void testEncargadoModificaDatosDeUnProducto(){
        Producto birra = ProductoFactory.createWithNombre("cerveza");
        Producto fernet = ProductoFactory.createWithNombre("fernet");
        Producto arroz = ProductoFactory.createWithNombre("arroz");
        Comercio comercio = comercioBuilder.build();
        comercio.agregarProducto(birra);
        comercio.agregarProducto(fernet);
        comercio.agregarProducto(arroz);
        comercio.modificarDatosDelProducto(1, "cerveza", "Quilmes", 40, 130, "imagen de birra", "Bebida con alcohol", 5);
        Producto prod = comercio.buscarProductoPorCodigo(5);
        assertEquals(prod.getNombreProducto(), "cerveza");
        assertFalse(prod.getMarca() == "Sin Marca");
        assertTrue(prod.getPrecio() == 130);
        assertTrue(prod.getStock() == 40);
    }

}
