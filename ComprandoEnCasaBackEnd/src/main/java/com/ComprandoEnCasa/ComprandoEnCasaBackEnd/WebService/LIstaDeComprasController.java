package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ListaDeComprasService;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class LIstaDeComprasController {

    @Autowired
    private ListaDeComprasService listaDeComprasService;


    @CrossOrigin
    @GetMapping("/api/listadecompras")
    public List<ListaDeCompras> listarlistadecompras(){
        //Busqueda de  productos para comprar como cliente.
        return listaDeComprasService.findAll();
    }

}
