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

    //si usamos un builder, no es necesario setup del encargado; ya que creamos la instancia con las cosas que nos interesa

    @Before
    public void setUp()  {
        productoBuilder = new ProductoBuilder();
        aEncargadoBuilder = new EncargadoBuilder();
        /*
        aEncargadoBuilder =  EncargadoBuilder.aEncargado().withName("EncargadoComerceTest")
                .withEmail("ELEncargadoCOmecioTEST@gmail.com.ar")
                .withTelefono(43555676)
                .withDomicilio("Calchaqui 465");
        encargado = aEncargadoBuilder.build();
         */
    }


    //test independientes! un test para cada cosa
    /*@Test
    public void darDeAltaUnNUevoEncargadoTest(){
        TestCase.assertEquals(encargado.getDomicilio(), "Calchaqui 465");
        TestCase.assertEquals(encargado.getEmail(), "ELEncargadoCOmecioTEST@gmail.com.ar");
        TestCase.assertEquals(encargado.getTelefono(), 43555676);
        TestCase.assertEquals(encargado.getNombreUsuario(), "EncargadoComerceTest");
    }
     */
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
        // no es necesario tantas especificaciones del producto, solo testeamos que haya uno mas agregado
        /*
        Producto newProducto = productoBuilder.withNombreProducto("AXE Africa 2.0")
                                .withStock(2)
                                .withImagen("iamgen.laslgapsg")
                                .withMarca("AXE")
                                .withCategoria("Limpieza")
                                .withPrecio(200)
                                .build();

         */
        Producto newProducto = productoBuilder.build();
        TestCase.assertEquals(encargado.getProductosAVender().size(), 0);

        encargado.darDeAltaUnProducto(newProducto);
        TestCase.assertEquals(encargado.getProductosAVender().size(), 1);
    }


    @Test
    public void testUnEncargadoCreaOfertaParaCategoria(){
        encargado = aEncargadoBuilder.build();//un encargado con valores por defecto
        // el builder no necesita todos los with__ , se usan los que necesitamos.
        // en este caso no necesitamos la imagen ni el stock, no es indiferente para lo que queremos testear
        Producto arroz = productoBuilder.withNombreProducto("Arroz pal guiso")
                //.withStock(7)
                //.withImagen("iamgen.laslgapsgsasaf")
                .withMarca("ALA")
                .withCategoria("Alimento")
                .withPrecio(80)
                .build();

        Producto fideos = productoBuilder.withNombreProducto("Fideos Matarazzo")
                //.withStock(5)
                //.withImagen("iamgen.lasfasfpsg")
                .withMarca("Matarazzo")
                .withCategoria("Alimento")
                .withPrecio(90)
                .build();

        Producto chisitos = productoBuilder.withNombreProducto("Chisitos pehuamar")
                //.withStock(2)
                //.withImagen("iamgen.fdsfgapsg")
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
                //.withStock(10)
                //.withImagen("iamgen.lagfhfdg")
                .withMarca("Vittone")
                //.withCategoria("Bebida alcoholica")
                .withPrecio(250)
                .build();

        Producto coca = productoBuilder.withNombreProducto("Coca cola")
                //.withStock(10)
                //.withImagen("iamgen.lgghfsfasfpsg")
                .withMarca("Coca cola")
                //.withCategoria("Bebida sin alcohol")
                .withPrecio(120)
                .build();

        Producto detergente = productoBuilder.withNombreProducto("Detergente magistral")
                //.withStock(5)
                //.withImagen("iamgen.fdsafsffg")
                .withMarca("Magistral")
                //.withCategoria("Limpieza")
                .withPrecio(160)
                .build();

        Producto esponja = productoBuilder.withNombreProducto("esponja amarilla")
                //.withStock(30)
                //.withImagen("iamgen.ffdgtyasg")
                .withMarca("Patitol")
                //.withCategoria("Limpieza")
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
                //.withStock(25)
                //.withImagen("iamgen.jafdkjh")
                //.withMarca("Carozo")
                //.withCategoria("Alimento")
                .withPrecio(60)
                .build();

        Producto prepizza = productoBuilder.withNombreProducto("Prepizza")
                //.withStock(30)
                //.withImagen("iamgen.uidfdf")
                //.withMarca("Pirulo")
                //.withCategoria("Alimento")
                .withPrecio(120)
                .build();

        Producto salsaDeTomate = productoBuilder.withNombreProducto("Salsa de tomate")
                //.withStock(30)
                //.withImagen("iamgen.askldjlsdf")
                //.withMarca("Molto")
                //.withCategoria("Alimento")
                .withPrecio(80)
                .build();


        Producto detergente = productoBuilder.withNombreProducto("Detergente magistral")
                //.withStock(5)
                //.withImagen("iamgen.fdsafsffg")
                //.withMarca("Magistral")
                //.withCategoria("Limpieza")
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
