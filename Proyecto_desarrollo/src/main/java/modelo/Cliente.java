package modelo;

public class Cliente extends Usuario {

    private String direccion;
    private ListaDeCompras listaDeCompras;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaDeCompras getListaDeCompras() { return listaDeCompras; }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) { this.listaDeCompras = listaDeCompras; }

    public Cliente(){}

    public Cliente(String direccion){
        this.setDireccion(direccion);
        this.setListaDeCompras(null);
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
}
