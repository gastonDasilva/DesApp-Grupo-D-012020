package model;

import Modelo.App;
import Modelo.Cliente;
import Modelo.Comercio;
import Modelo.Geo;
import Tools.Builder.AppBuilder;
import Tools.Builder.ComercioBuilder;
import Tools.Factory.ClienteFactory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GeoTest extends TestCase {

    private Geo unqui;

    @Before
    public void setUp(){
        Double lat = new Double(-34.7590687) ;
        Double lon = new Double(-58.2965889);
        unqui = new Geo(lat,lon,"UNQ");

    }


    @Test
    public void testObtenerLatitud(){
        assertEquals(unqui.getLatitude(), -34.7590687);
    }

    @Test
    public void testObtenerLongitud(){
        assertEquals(unqui.getLongitude(),-58.2965889);
    }

    @Test
    public void testObtenerNombre(){
        assertEquals(unqui.getName(),"UNQ");
    }


}