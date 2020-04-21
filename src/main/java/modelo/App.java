package modelo;

import java.util.List;
import java.util.ArrayList;

public class App {

    private String rubro;
    private String domicilio;
    private String diasYHorariosDeAtencion;
    private String mediosDePago;
    private float distanciaMaximaEnvio;
    private List<Cliente> clientes;
    private Encargado encargado;
    private List<Producto> productos;

    public String getRubro() {
        return rubro;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getDiasYHorariosDeAtencion() {
        return diasYHorariosDeAtencion;
    }

    public String getMediosDePago() {
        return mediosDePago;
    }

    public float getDistanciaMaximaEnvio() {
        return distanciaMaximaEnvio;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setDiasYHorariosDeAtencion(String diasYHorariosDeAtencion) {
        this.diasYHorariosDeAtencion = diasYHorariosDeAtencion;
    }

    public void setMediosDePago(String mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    public void setDistanciaMaximaEnvio(float distanciaMaximaEnvio) {
        this.distanciaMaximaEnvio = distanciaMaximaEnvio;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public App(String rubro, String domicilio, String diasYHorariosDeAtencion, String mediosDePago, float distancia, Encargado encargado){

        this.setRubro(rubro);
        this.setDomicilio(domicilio);
        this.setDiasYHorariosDeAtencion(diasYHorariosDeAtencion);
        this.setMediosDePago(mediosDePago);
        this.setDistanciaMaximaEnvio(distancia);
        this.setClientes(new ArrayList<Cliente>());
        this.setEncargado(encargado);
        this.setProductos(new ArrayList<Producto>());
    }

    public void agregarCliente(Cliente cliente){
        this.getClientes().add(cliente);
    }

    public int cantidadDeClientes(){
        return this.getClientes().size();
    }

}
