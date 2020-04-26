package AppTest;

import Modelo.Encargado;
import Modelo.MedioDePago;
import Modelo.Producto;
import Tools.EncargadoBuilder;
import Tools.ProductoBuilder;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import java.util.ArrayList;


public class EncargadoTest {
    private EncargadoBuilder aEncargadoBuilder;
    private Encargado encargado;
    @Before
    public void setUp()  {
        aEncargadoBuilder =  EncargadoBuilder.aEncargado().withName("EncargadoComerceTest")
                .withEmail("ELEncargadoCOmecioTEST@gmail.com.ar")
                .withTelefono(43555676)
                .withDomicilio("Calchaqui 465");
        encargado = aEncargadoBuilder.build();
    }
    @Test
    public void darDeAltaUnNUevoEncargadoTest(){
        TestCase.assertEquals(encargado.getDomicilio(), "Calchaqui 465");
        TestCase.assertEquals(encargado.getEmail(), "ELEncargadoCOmecioTEST@gmail.com.ar");
        TestCase.assertEquals(encargado.getTelefono(), 43555676);
        TestCase.assertEquals(encargado.getNombreUsuario(), "EncargadoComerceTest");
    }

    @Test
    public void darDeAltaUnEncargadoCon2MediosDePagoTest(){

        Encargado encargado = aEncargadoBuilder.build();
        TestCase.assertEquals(encargado.getMediosDePago().size(), 0);
        MedioDePago medioDePago = new MedioDePago("PagoFacil","imagentest");
        encargado.agregarMedioDePago(medioDePago);
        TestCase.assertEquals(encargado.getMediosDePago().size(), 1);
    }

    @Test
    public  void unEncargadoAgregaUnNuevoProductoAVenderTest(){
        Producto newProducto = ProductoBuilder.aProducto().withNombreProducto("AXE Africa 2.0")
                                .withStock(2)
                                .withImagen("iamgen.laslgapsg")
                                .withMarca("AXE")
                                .withCategoria("Limpieza")
                                .withPrecio(200)
                                .build();
        TestCase.assertEquals(encargado.getProductosAVender().size(), 0);

        encargado.darDeAltaUnProducto(newProducto);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 1);
    }

}
