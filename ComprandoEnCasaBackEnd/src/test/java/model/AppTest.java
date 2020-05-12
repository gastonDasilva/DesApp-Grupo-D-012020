package model;

import Tools.Builder.AppBuilder;
import Modelo.App;
import Tools.Builder.ComercioBuilder;
import Modelo.Cliente;
import Modelo.Comercio;
import Tools.Factory.ClienteFactory;
import Tools.Factory.ProductoFactory;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class AppTest extends TestCase {

    private AppBuilder appBuilder = new AppBuilder();

    @Test
    public void testAgregarCliente(){
        App app = appBuilder.build();
        Cliente gaston = ClienteFactory.createWithNombre("Gaston");
        assertEquals(app.cantidadDeClientes(), 0);
        app.agregarCliente(gaston);
        assertEquals(app.cantidadDeClientes(), 1);
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
    public void testAgregarComercio(){
        ComercioBuilder comercioBuilder1 = new ComercioBuilder();
        Comercio comercio1 = comercioBuilder1.build();
        App app = appBuilder.build();
        assertEquals(app.cantidadDeComercios(), 0);
        app.agregarComercio(comercio1);
        assertEquals(app.cantidadDeComercios(), 1);

    }


    @Test
    public void testBuscarProductosEnComercioPorTextoIngresado(){
        ComercioBuilder comercioBuilder = new ComercioBuilder();
        Comercio comercio1 = comercioBuilder.build();
        Comercio comercio2 = comercioBuilder.build();
        Producto birra = ProductoFactory.createWithNombre("cerveza");
        Producto fernet = ProductoFactory.createWithNombre("fernet");
        Producto arroz = ProductoFactory.createWithNombre("arroz");
        comercio1.agregarProducto(birra);
        comercio1.agregarProducto(fernet);
        comercio1.agregarProducto(arroz);
        comercio2.setNombreComercio("gulp");
        App app = appBuilder.build();
        app.agregarComercio(comercio1);
        app.agregarComercio(comercio2);
        List<Producto> result = app.buscarProductosEnComercioPorTextoIngresado("oktubre", "er");
        assertEquals(result.size(), 2);
    }
}