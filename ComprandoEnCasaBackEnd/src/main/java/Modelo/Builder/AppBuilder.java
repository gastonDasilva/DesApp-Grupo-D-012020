package Modelo.Builder;

import Modelo.Comercio;
import Modelo.Cliente;
import Modelo.Encargado;
import Modelo.App;
import Modelo.Geo;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;

import java.util.ArrayList;
import java.util.List;

public class AppBuilder {

    private List<Comercio> comercios = new ArrayList<Comercio>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private Encargado oscar = new Encargado("oscar", "20-30656734-5", "oscar@gmail.com");


    public App build(){
        App app = new App(comercios, clientes, oscar);
        return app;
    }

    public AppBuilder withComercios(final List<Comercio> unaLista){
        comercios = unaLista;
        return this;
    }

    public AppBuilder withClientes(final List<Cliente> unaLista){
        clientes = unaLista;
        return this;
    }

    public AppBuilder withEncargado(final Encargado unEncargado){
        oscar = unEncargado;
        return this;
    }
}
