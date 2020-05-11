package model;

import Modelo.Geo;
import Modelo.MedioDePago;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MedioDePagoTest extends TestCase {

    private MedioDePago paganini;



    @Test
    public void testObtenerNombre(){
        paganini = new MedioDePago("Efectivo","$");
        assertEquals(paganini.getNombre(),"Efectivo");
    }

    @Test
    public void testCompararMediosDePagos(){
        paganini = new MedioDePago("Efectivo","$");
        MedioDePago cash = new MedioDePago("Efectivo","alcancia");
        MedioDePago tarjetear = new MedioDePago("Credito","tarjeta sube");
        assertTrue(paganini.esElMismoMedioDePago(cash));
        assertFalse(paganini.esElMismoMedioDePago(tarjetear));
    }


}