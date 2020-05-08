package Modelo;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String direccion;
    private ListaDeCompras listaDeCompras;
    public int montoGastado;
    private int montoDeCompra;
    private int montoAcumuladoEnAlimentos;
    private int montoAcumuladoEnBebidasAlcoholicas;
    private List<ListaDeCompras> historialDeCompras;
    private Geo coordenadas;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaDeCompras getListaDeCompras() { return listaDeCompras; }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) { this.listaDeCompras = listaDeCompras; }

    public int getMontoGastado() { return montoGastado; }

    public void setMontoGastado(int montoGastado) { this.montoGastado = montoGastado; }

    public int getMontoDeCompra() { return montoDeCompra; }

    public void setMontoDeCompra(int montoDeCompra) { this.montoDeCompra = montoDeCompra; }

    public int getMontoAcumuladoEnAlimentos() { return montoAcumuladoEnAlimentos; }

    public void setMontoAcumuladoEnAlimentos(int montoAcumuladoEnAlimentos) { this.montoAcumuladoEnAlimentos = montoAcumuladoEnAlimentos; }

    public int getMontoAcumuladoEnBebidasAlcoholicas() { return montoAcumuladoEnBebidasAlcoholicas; }

    public void setMontoAcumuladoEnBebidasAlcoholicas(int montoAcumuladoEnBebidasAlcoholicas) { this.montoAcumuladoEnBebidasAlcoholicas = montoAcumuladoEnBebidasAlcoholicas; }

    public List<ListaDeCompras> getHistorialDeCompras() { return historialDeCompras; }

    public void setHistorialDeCompras(List<ListaDeCompras> historialDeCompras) { this.historialDeCompras = historialDeCompras; }

    public Geo getCoordenadas() { return coordenadas; }

    public void setCoordenadas(Geo coordenadas) { this.coordenadas = coordenadas; }

    public Cliente(){}

    public Cliente(String nombre, String email, App app, String direccion, Geo coordenadas){
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        this.setApp(app);
        this.setDireccion(direccion);
        this.setListaDeCompras(null);
        this.setMontoGastado(0);
        this.setMontoDeCompra(0);
        this.setHistorialDeCompras(new ArrayList<ListaDeCompras>());
        this.setCoordenadas(coordenadas);
    }
    //duplico para no romper ningun test anterior
    public Cliente(String nombre, String email, String direccion, Geo coordenadas){
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        this.setApp(app);
        this.setDireccion(direccion);
        this.setListaDeCompras(null);
        this.setMontoGastado(0);
        this.setMontoDeCompra(0);
        this.setHistorialDeCompras(new ArrayList<ListaDeCompras>());
        this.setCoordenadas(coordenadas);
    }

    public void registrarme(App app){
        /*
         * PROP: se crea una lista de compras nuevo, se le asigna dicha lista al cliente
         *       una vez registrado, y por último se agrega al cliente a la lista de clientes
         *       registrados a la aplicación pasada como parámetro.
         */
        this.setApp(app);
        ListaDeCompras lista = new ListaDeCompras();
        this.setListaDeCompras(lista);
        app.agregarCliente(this);
    }




    public void asignarMontoMaximoEnCategoriaAlimentos(App app, int monto){
        // El cliente notifica al sistema el monto máximo a gastar en la categoria alimentos.
        app.setMontoMaximoCategoriaAlimentos(monto);
    }



    public void agregarProducto(Producto producto, App app){
    /* PROP: si el cliente no tiene asignado una lista de compras, es porque no está registrado y,
             por ende, no puede adquirir determinado producto. Si tiene asignado una lista de compras,
             entonces está registrado, y puede adquirir dicho producto.

    */
    if(this.getListaDeCompras() == null){
        System.out.println("tenes que registrarte!");
    }
    else{
        this.verificarUmbralDeProducto(producto, app);
     }
    }

    public void verificarUmbralDeProducto(Producto producto, App app) {

        switch (producto.getCategoria()) {
            case "Alimento":
                if (this.getMontoAcumuladoEnAlimentos() + producto.getPrecio() > app.getMontoMaximoCategoriaAlimentos()) {
                    System.out.println("AVISO: superaste el monto maximo de compra en categorias de alimento");
                } else {
                    this.getListaDeCompras().agregarProducto(producto);
                    this.montoGastado = this.getMontoGastado() + producto.getPrecio();
                    this.montoAcumuladoEnAlimentos = this.getMontoAcumuladoEnAlimentos() + producto.getPrecio();

                }
                break;
            case "Bebida alcoholica":
                if (this.getMontoAcumuladoEnBebidasAlcoholicas() + producto.getPrecio() > app.getMontoMaximoCategoriaBebidasAlcoholicas()) {
                    System.out.println("AVISO: superaste el monto maximo de compra en categorias de bebidas alcoholicas");
                } else {
                    this.getListaDeCompras().agregarProducto(producto);
                    this.montoGastado = this.getMontoGastado() + producto.getPrecio();
                    this.montoAcumuladoEnBebidasAlcoholicas = this.getMontoAcumuladoEnBebidasAlcoholicas() + producto.getPrecio();

                }
                break;
            default:
                this.getListaDeCompras().agregarProducto(producto);
                this.montoGastado = this.getMontoGastado() + producto.getPrecio();
        }
    }

    public void realizarCompra() {
        if (this.getListaDeCompras().cantidadDeProductosEnLista() == 0) {
            this.montoDeCompra = this.getMontoGastado();
        } else {
            this.getHistorialDeCompras().add(this.getListaDeCompras());
            this.montoDeCompra = this.getMontoGastado();
            this.setListaDeCompras(new ListaDeCompras());
        }
    }
}
