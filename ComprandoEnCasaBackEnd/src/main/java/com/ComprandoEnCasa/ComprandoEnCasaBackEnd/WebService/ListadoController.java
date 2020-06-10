package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping("/api/productos/{id}")
    public Producto getProductoConId(@PathVariable long id){
        // Busca y devuelve el producto con el id correspondiente traido por parámetro
        return productoService.findById(id);
    }

    @CrossOrigin
    @GetMapping("/api/buscarProductos")
    public  List<Producto> buscarProductos(@RequestParam("q") String consulta){
        return productoService.buscarProductoPorConsulta(consulta);
    }


    @CrossOrigin
    @GetMapping("/api/buscarPorCategoria")
    public List<Producto> buscarPorCategoria(@RequestParam("q") String categoria){
        return productoService.buscarProductosPorCategoria(categoria);
    }

    @CrossOrigin
    @PutMapping("/api/buscarPorCategoriaYAplicarOferta")
    public void buscarPorCategoriaYAplicarOferta(@RequestParam("q") String categoria, @RequestParam("d") int descuento){
        productoService.buscarProductosPorCategoriaYAplicarOferta(categoria, descuento);
    }

    @CrossOrigin
    @PutMapping("/api/buscarProductoPorIdYAplicarOferta/{id}")
    public void buscarProductoPorIdYAplicarOferta(@PathVariable long id, @RequestParam("d") int descuento){
        Producto prodRes = productoService.findById(id);
        productoService.buscarProductoYAplicarOferta(prodRes, descuento);
    }

}
