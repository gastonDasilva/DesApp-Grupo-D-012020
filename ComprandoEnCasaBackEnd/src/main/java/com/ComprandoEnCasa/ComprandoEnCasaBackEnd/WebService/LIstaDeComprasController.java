package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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


    @CrossOrigin
    @PutMapping("/api/listadecomprasAdd/{id}")
    public ListaDeCompras agregarProductoALCarrito(@RequestBody ListaDeCompras listaDeCompras,@PathVariable Long id, @RequestParam("idProducto") Long idProducto) {
        System.out.println(listaDeCompras);
        return listaDeComprasService.agregarProductoALCarrito(id,idProducto);
    }


    @CrossOrigin
    @PutMapping("/api/listadecomprasDeleteProduct/{id}")
    public ListaDeCompras listadecomprasDeleteProduct(@RequestBody ListaDeCompras listaDeCompras,@PathVariable Long id, @RequestParam("idProducto") Long idProducto) {
        System.out.println(listaDeCompras);
        return listaDeComprasService.sacarProductoDelCarrito(id,idProducto);
    }


}
