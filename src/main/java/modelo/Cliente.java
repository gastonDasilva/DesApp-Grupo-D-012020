package modelo;

public class Cliente extends Usuario {

    private String direccion;
    private ListaDeCompras listaDeCompras;
    public int montoGastado;
    private int montoDeCompra;

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

    public Cliente(){}

    public Cliente(String nombre, String email, String password, App app, String direccion){
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        this.setPassword(password);
        this.setApp(app);
        this.setDireccion(direccion);
        this.setListaDeCompras(null);
        this.setMontoGastado(0);
        this.setMontoDeCompra(0);
    }

    public void registrarme(App app){
        /*
         * PROP: se crea una lista de compras nuevo, se le asigna dicha lista al cliente
         *       una vez registrado, y por último se agrega al cliente a la lista de clientes
         *       registrados a la aplicación pasada como parámetro.
         */
        ListaDeCompras lista = new ListaDeCompras();
        this.setListaDeCompras(lista);
        app.agregarCliente(this);
    }

    public void agregarProducto(Producto producto){
    /* PROP: si el cliente no tiene asignado una lista de compras, es porque no está registrado y,
             por ende, no puede adquirir determinado producto. Si tiene asignado una lista de compras,
             entonces está registrado, y puede adquirir dicho producto.

    */
    if(this.getListaDeCompras() == null){
        System.out.println("tenes que registrarte!");
    }
    else{
        this.getListaDeCompras().agregarProducto(producto);
        this.montoGastado = this.getMontoGastado() + producto.getPrecio();
     }
    }

    public void realizarCompra(){
        this.montoDeCompra = this.getMontoGastado();
    }
}
