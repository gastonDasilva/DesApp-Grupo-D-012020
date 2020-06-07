package model;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Encargado;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.MedioDePago;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.EncargadoBuilder;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.ProductoBuilder;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import java.util.ArrayList;


public class EncargadoTest {
    private EncargadoBuilder aEncargadoBuilder;
    private Encargado encargado;
    private ProductoBuilder productoBuilder;


    @Before
    public void setUp()  {
        productoBuilder = new ProductoBuilder();
        aEncargadoBuilder = new EncargadoBuilder();
    }


    @Test
    public void testEmailValidoDelEncargado(){
        encargado = aEncargadoBuilder.withEmail("ELEncargadoCOmecioTEST@gmail.com.ar").build();
        TestCase.assertTrue(encargado.getEmail().contains("@"));
        TestCase.assertTrue(encargado.getEmail().contains("."));
        TestCase.assertFalse(encargado.getEmail().isEmpty());
    }

    @Test
    public void testNombreDeUsuarioValido(){
        encargado = aEncargadoBuilder.withName("EncargadoComerceTest").build();
        TestCase.assertFalse(encargado.getNombreUsuario().isEmpty());
    }




    @Test
    public void testDarDeAltaUnEncargadoCon2MediosDePago(){
        Encargado encargadoSinMediosDePago = aEncargadoBuilder.build();
        MedioDePago medioDePago = new MedioDePago("PagoFacil","imagentest");
        MedioDePago otroMedioDePago = new MedioDePago("Mercado Pago","codoacodo.jpg");
        ArrayList <MedioDePago> seAceptan = new ArrayList<>();
        seAceptan.add(medioDePago);seAceptan.add(otroMedioDePago);
        Encargado encargadoCon1MedioDePago = aEncargadoBuilder.withMedioDePago(medioDePago).build();
        Encargado encargadoCon2MediosDePago = aEncargadoBuilder.withMediosDePago(seAceptan).build();
        //TestCase.assertTrue(encargadoSinMediosDePago.getMediosDePago().isEmpty());
        //encargado.agregarMedioDePago(medioDePago);
        TestCase.assertEquals(encargadoCon1MedioDePago.getMediosDePago().size(), 1);
        //ojo con el nombre y lo que testeamos
        TestCase.assertEquals(encargadoCon2MediosDePago.getMediosDePago().size(),2);
    }

    @Test
    public  void testUnEncargadoAgregaUnNuevoProductoAVender(){
        encargado = aEncargadoBuilder.build();//un encargado cualquiera
        Producto newProducto = productoBuilder.build();
        TestCase.assertEquals(encargado.getProductosAVender().size(), 0);

        encargado.darDeAltaUnProducto(newProducto);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 1);
    }


    @Test
    public void testUnEncargadoCreaOfertaParaCategoria(){
        encargado = aEncargadoBuilder.build();//un encargado con valores por defecto
        Producto arroz = productoBuilder.withNombreProducto("Arroz pal guiso")
                .withMarca("ALA")
                .withCategoria("Alimento")
                .withPrecio(80)
                .build();

        Producto fideos = productoBuilder.withNombreProducto("Fideos Matarazzo")
                .withMarca("Matarazzo")
                .withCategoria("Alimento")
                .withPrecio(90)
                .build();

        Producto chisitos = productoBuilder.withNombreProducto("Chisitos pehuamar")
                .withMarca("Pehuamar")
                .withCategoria("Golosina")
                .withPrecio(150)
                .build();

        encargado.darDeAltaUnProducto(arroz);
        encargado.darDeAltaUnProducto(fideos);
        encargado.darDeAltaUnProducto(chisitos);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 3);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 320);

        encargado.crearOfertaPorCategoria(10, "Alimento");
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 303);
    }

    @Test
    public void testUnEncargadoCreaOfertasPorCombinacionDe2Productos(){
        encargado = aEncargadoBuilder.build();
        Producto fernet = productoBuilder.withNombreProducto("fernet vittone")
                .withMarca("Vittone")
                .withPrecio(250)
                .build();

        Producto coca = productoBuilder.withNombreProducto("Coca cola")
                .withMarca("Coca cola")
                .withPrecio(120)
                .build();

        Producto detergente = productoBuilder.withNombreProducto("Detergente magistral")
                .withMarca("Magistral")
                .withPrecio(160)
                .build();

        Producto esponja = productoBuilder.withNombreProducto("esponja amarilla")
                .withMarca("Patitol")
                .withPrecio(30)
                .build();

        encargado.darDeAltaDosProductosEnOferta(fernet, coca);
        encargado.darDeAltaDosProductosEnOferta(detergente, esponja);
        TestCase.assertEquals(encargado.getProductosEnOfertaPor2().size(), 2);

        encargado.crearOfertaPorCombinacionDe2Productos(10);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosProductosEnOfertaPor2(), 504);
    }

    @Test
    public void testUnEncargadoCreaOfertaPorProducto(){
        encargado = aEncargadoBuilder.build();
        Producto aceitunas = productoBuilder.withNombreProducto("aceitunas con carozo")
                .withPrecio(60)
                .build();

        Producto prepizza = productoBuilder.withNombreProducto("Prepizza")
                .withPrecio(120)
                .build();

        Producto salsaDeTomate = productoBuilder.withNombreProducto("Salsa de tomate")
                .withPrecio(80)
                .build();


        Producto detergente = productoBuilder.withNombreProducto("Detergente magistral")
                .withPrecio(160)
                .build();

        encargado.darDeAltaUnProducto(prepizza);
        encargado.darDeAltaUnProducto(salsaDeTomate);
        encargado.darDeAltaUnProducto(aceitunas);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 3);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 260);

        encargado.crearOferetaPorProducto(detergente, 5);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 260);

        encargado.crearOferetaPorProducto(aceitunas, 5);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 257);
    }

    @Test
    public void testEncargadoModificaProducto(){
        Producto coca = productoBuilder.withNombreProducto("Coca cola")
                .withStock(10)
                .withImagen("iamgen.lgghfsfasfpsg")
                .withMarca("Coca cola")
                .withCategoria("Bebida sin alcohol")
                .withPrecio(120)
                .build();

        encargado = aEncargadoBuilder.build();
        encargado.modificarDatosDeProducto(coca, 1, "Coca zero", "Coca cola", 30, 110, "una imagen", "Bebida sin alcohol");
        TestCase.assertEquals(coca.getNombreProducto(), "Coca zero");
        TestCase.assertEquals(coca.getPrecio(), 110);

    }

}
