package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Comercio;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Cliente;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.App;

import java.util.ArrayList;
import java.util.List;

public class AppBuilder {

    private List<Comercio> comercios = new ArrayList<Comercio>();
    private List<Cliente> clientes = new ArrayList<Cliente>();


    public App build(){
        App app = new App(comercios, clientes);
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
}
