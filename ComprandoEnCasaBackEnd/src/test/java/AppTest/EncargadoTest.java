package AppTest;

import Modelo.Encargado;
import Modelo.MedioDePago;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import Tools.EncargadoBuilder;
import Tools.ProductoBuilder;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;


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


    @Test
    public void unEncargadoCreaOfertaParaCategoriaDeAlimentos(){
        Producto arroz = ProductoBuilder.aProducto().withNombreProducto("Arroz pal guiso")
                .withStock(7)
                .withImagen("iamgen.laslgapsgsasaf")
                .withMarca("ALA")
                .withCategoria("alimento")
                .withPrecio(80)
                .build();

        Producto fideos = ProductoBuilder.aProducto().withNombreProducto("Fideos Matarazzo")
                .withStock(5)
                .withImagen("iamgen.lasfasfpsg")
                .withMarca("Matarazzo")
                .withCategoria("alimento")
                .withPrecio(90)
                .build();

        Producto chisitos = ProductoBuilder.aProducto().withNombreProducto("Chisitos pehuamar")
                .withStock(2)
                .withImagen("iamgen.fdsfgapsg")
                .withMarca("Pehuamar")
                .withCategoria("golosina")
                .withPrecio(150)
                .build();

        encargado.darDeAltaUnProducto(arroz);
        encargado.darDeAltaUnProducto(fideos);
        encargado.darDeAltaUnProducto(chisitos);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 3);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 320);

        encargado.crearOfertaPorCategoriaDeAlimentos(10);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosPrecios(), 303);
    }

    @Test
    public void unEncargadoCreaOfertasPorCombinacionDe2Productos(){
        Producto fernet = ProductoBuilder.aProducto().withNombreProducto("fernet vittone")
                .withStock(10)
                .withImagen("iamgen.lagfhfdg")
                .withMarca("Vittone")
                .withCategoria("Bebida alcoholica")
                .withPrecio(250)
                .build();

        Producto coca = ProductoBuilder.aProducto().withNombreProducto("Coca cola")
                .withStock(10)
                .withImagen("iamgen.lgghfsfasfpsg")
                .withMarca("Coca cola")
                .withCategoria("Bebida sin alcohol")
                .withPrecio(120)
                .build();

        Producto detergente = ProductoBuilder.aProducto().withNombreProducto("Detergente magistral")
                .withStock(5)
                .withImagen("iamgen.fdsafsffg")
                .withMarca("Magistral")
                .withCategoria("Limpieza")
                .withPrecio(160)
                .build();

        Producto esponja = ProductoBuilder.aProducto().withNombreProducto("esponja amarilla")
                .withStock(30)
                .withImagen("iamgen.ffdgtyasg")
                .withMarca("Patitol")
                .withCategoria("Limpieza")
                .withPrecio(30)
                .build();

        encargado.darDeAltaDosProductosEnOferta(fernet, coca);
        encargado.darDeAltaDosProductosEnOferta(detergente, esponja);
        TestCase.assertEquals(encargado.getProductosEnOfertaPor2().size(), 2);

        encargado.crearOfertaPorCombinacionDe2Productos(10);
        TestCase.assertEquals(encargado.sumatoriaDeTodosLosProductosEnOfertaPor2(), 504);
    }

    @Test
    public void unEncargadoCreaOfertaPorProducto(){
        Producto aceitunas = ProductoBuilder.aProducto().withNombreProducto("aceitunas con carozo")
                .withStock(25)
                .withImagen("iamgen.jafdkjh")
                .withMarca("Carozo")
                .withCategoria("alimento")
                .withPrecio(60)
                .build();

        Producto prepizza = ProductoBuilder.aProducto().withNombreProducto("Prepizza")
                .withStock(30)
                .withImagen("iamgen.uidfdf")
                .withMarca("Pirulo")
                .withCategoria("Alimento")
                .withPrecio(120)
                .build();

        Producto salsaDeTomate = ProductoBuilder.aProducto().withNombreProducto("Salsa de tomate")
                .withStock(30)
                .withImagen("iamgen.askldjlsdf")
                .withMarca("Molto")
                .withCategoria("Alimento")
                .withPrecio(80)
                .build();


        Producto detergente = ProductoBuilder.aProducto().withNombreProducto("Detergente magistral")
                .withStock(5)
                .withImagen("iamgen.fdsafsffg")
                .withMarca("Magistral")
                .withCategoria("Limpieza")
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

}
