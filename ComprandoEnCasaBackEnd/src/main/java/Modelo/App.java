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
    private Geo coordenadas;


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

    public Geo getCoordenadas() { return coordenadas; }

    public void setCoordenadas(Geo coordenadas) { this.coordenadas = coordenadas; }

    public App(String rubro, String domicilio, String diasYHorariosDeAtencion, String mediosDePago, float distancia, Encargado encargado, Geo coordenadas){

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
        this.setCoordenadas(coordenadas);
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


    // este metodo es responsabilidad de la clase Producto, traslado alli la implementacion del metodo
    public void imprimirProductos() {
        int contador= 0;
        String palabraProducto = "Producto nro ";
        String palabraImpresa;
        for(Producto p : productos) {
            contador++;
            palabraImpresa = palabraProducto.concat(Integer.toString(contador));
            System.out.println(palabraImpresa);
            p.imprimirEnPantalla();
            /*
            System.out.print("[");
            System.out.print("Nombre del producto: "+ p.getNombreProducto());
            System.out.print(" ,Marca: "+ p.getMarca());
            System.out.print(" ,stock: "+p.getStock());
            System.out.println(" ,precio:"+ p.getPrecio());
            System.out.println("]");
             */
        }
        System.out.println("Cantidad de productos listados: "+ Integer.toString(contador));
    }

    public boolean aceptaMedioDePago(String esteMedioDePago){
        return this.mediosDePago.contains(esteMedioDePago);
    }

    public boolean dentroDelAreaDeEnvio (float distanciaEntreElDomicilioYElLocal){
        return distanciaEntreElDomicilioYElLocal<= distanciaMaximaEnvio;
    }

    /*
    public boolean debeHaberAlgunEncargado(){
        return !this.encargado.nombreUsuario.isBlank();
    }
     */


    public boolean vendeProductoConNombre (String nombre){
        boolean encontro = false;
        for (Producto p: productos){
            if (p.getNombreProducto().contains(nombre)){
                encontro = true;
            }
        }
        return encontro;
    }

    public List<Producto> filtrarProductosConNombre(String nombre){
        List<Producto> filtro = new ArrayList<Producto>();
        for (Producto p: productos){
            if (p.getNombreProducto().contains(nombre)){
                filtro.add(p);
            }
        }
        return filtro;
    }

    public boolean vendeProductoConMarca (String marca){
        boolean encontro = false;
        for (Producto p: productos){
            if (p.getMarca().contains(marca)){
                encontro = true;
            }
        }
        return encontro;
    }

    public List<Producto> filtrarProductosConMarca(String marca) {
        List<Producto> filtro = new ArrayList<Producto>();
        for (Producto p : productos) {
            if (p.getMarca().contains(marca)) {
                filtro.add(p);
            }
        }
        return filtro;
    }


}
