package appTest;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import modelo.*;

public class ListaDeComprasTest extends TestCase {

    private ListaDeCompras listaDeCompras;


    @Before
    public void setUp() throws Exception {

        listaDeCompras = new ListaDeCompras();
    }

    @Test
    public void testCantidadDeProductosEnLista() { assertTrue(listaDeCompras.cantidadDeProductosEnLista() == 0);}


    @Test
    public void testMontoAcumuladoEnLista() { assertTrue(listaDeCompras.getMontoAcumulado() == 0);}
}
