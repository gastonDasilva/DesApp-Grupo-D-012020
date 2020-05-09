package model;

import Modelo.Builder.AppBuilder;
import Modelo.App;
import Modelo.Builder.ComercioBuilder;
import Modelo.Cliente;
import Modelo.Comercio;
import Modelo.Factory.ClienteFactory;
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


}