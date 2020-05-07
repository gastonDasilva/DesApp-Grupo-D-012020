package Modelo;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import org.uqbar.commons.model.UserException;

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
    private int montoMaximoCategoriaAlimentos;
    private int montoMaximoCategoriaBebidasAlcoholicas;


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

    public int getMontoMaximoCategoriaAlimentos() { return montoMaximoCategoriaAlimentos; }

    public void setMontoMaximoCategoriaAlimentos(int montoMaximoCategoriaAlimentos) { this.montoMaximoCategoriaAlimentos = montoMaximoCategoriaAlimentos; }

    public int getMontoMaximoCategoriaBebidasAlcoholicas() {
        return montoMaximoCategoriaBebidasAlcoholicas;
    }

    public void setMontoMaximoCategoriaBebidasAlcoholicas(int montoMaximoCategoriaBebidasAlcoholicas) {
        this.montoMaximoCategoriaBebidasAlcoholicas = montoMaximoCategoriaBebidasAlcoholicas;
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
        this.setMontoMaximoCategoriaAlimentos(0); // Este valor lo setea e cliente
        this.setMontoMaximoCategoriaBebidasAlcoholicas(0);
    }

    public void agregarCliente(Cliente cliente){
        this.getClientes().add(cliente);
    }

    public int cantidadDeClientes(){
        return this.getClientes().size();
    }

    public Cliente comprar(Cliente cliente){
        for (Producto p: cliente.getListaDeCompras().getProductosAcumulados()){
            if (p.getStock() == 0){
                throw new UserException("No hay Stock!");
            }else{
                p.setStock(p.getStock() - 1);
            }
        }
        ListaDeCompras listaNueva = new ListaDeCompras();
        cliente.setListaDeCompras(listaNueva);
        return cliente;
    }


    public boolean disponibilidadDeProducto(Producto producto){
        // Producto disponible o no en la lista de productos de la aplicación.
        return this.getProductos().contains(producto);
    }


    public void agregarProducto(Producto producto){
        this.getProductos().add(producto);
    }


    public Producto buscarProductoPorCodigo(Long cod){
        Producto prod = null;
        for(Producto p: this.productos){
            if(p.getId() == cod){
                prod = p;
            }
        }
        if(prod == null){
            System.out.println("No se encontro el producto con id: " + cod);
            return prod;
        }
        return prod;
    }

    public List<Producto> buscarProductosPorTextoIngresado(String txt){

        List<Producto> result = new ArrayList<Producto>();
        for(Producto p: this.productos){
            if(p.getNombreProducto().contains(txt)){
                result.add(p);
            }
        }
        if(txt.equals("")){
            result = this.productos;
        }
        return result;
    }

    public void imprimirProductos() {
        for(Producto p : productos) {
            System.out.print("[");
            System.out.print("Nombre del producto: "+ p.getNombreProducto());
            System.out.print(" ,Marca: "+ p.getMarca());
            System.out.print(" ,stock: "+p.getStock());
            System.out.println(" ,precio:"+ p.getPrecio());
            System.out.println("]");

        }

    }



}
