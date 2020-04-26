package Tools;

import Modelo.Encargado;
import Modelo.MedioDePago;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EncargadoBuilder {
    private String nameCLiente = "no cliente";
    private String  email = "no email";
    private String pass = "no pass";
    private String rubro = "no name";
    private String logo = "no logo";
    private String domicilio = "no ubicacion";
    private Integer  telefono = 0;
    private   Map<Date,String> horariosYDias = new HashMap<Date, String>();
    private ArrayList<MedioDePago> mediosDePago = new ArrayList<MedioDePago>();


    public static EncargadoBuilder aEncargado() {

        return new EncargadoBuilder();

    }
    public Encargado build() {

        Encargado encargado = new Encargado(nameCLiente);
        encargado.setImagenPerfil(logo);
        encargado.setEmail(email);
        encargado.setHorariosYDias(horariosYDias);
        encargado.setTelefono(telefono);
        encargado.setDomicilio(domicilio);
        encargado.setMediosDePago(mediosDePago);
        return encargado;
    }


    public EncargadoBuilder withName(final String aValue) {

        this.nameCLiente = aValue;
        return this;
    }

    public EncargadoBuilder withEmail(final String aValue) {
        this.email = aValue;
        return this;
    }


    public EncargadoBuilder withTelefono(final Integer aValue) {
        this.telefono = aValue;
        return this;
    }

    public EncargadoBuilder withDomicilio(final String aValue) {
        this.domicilio = aValue;
        return this;
    }
    public EncargadoBuilder withMedioDePago(final ArrayList<MedioDePago> aValue) {
        this.mediosDePago = aValue;
        return this;
    }
}
