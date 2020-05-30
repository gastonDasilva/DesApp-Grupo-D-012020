package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ListadoController {

    @Autowired
    private  ProductoService productoService;


    @CrossOrigin
    @GetMapping("/api/productos")
    public List<Producto> listarProductos(){
        //Busqueda de  productos para comprar como cliente.
        return productoService.findAll();
    }

    @GetMapping("/api")
    public String ping(){
        return "PING";
    }
}
