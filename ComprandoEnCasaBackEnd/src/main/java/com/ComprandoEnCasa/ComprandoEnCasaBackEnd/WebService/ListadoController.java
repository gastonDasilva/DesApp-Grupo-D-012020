package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ProductoService;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ListadoController {

    @Autowired
    private  ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

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
    @PostMapping("/api/crearProductosForComercio/{idUSer}")
    Usuario newProducto(@RequestBody Producto newProducto, @PathVariable Long idUSer ) {
        productoService.save(newProducto);
        return usuarioService.agregarProductoAComercio(newProducto,idUSer);
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
    public List<Producto> buscarPorCategoriaYAplicarOferta(@RequestParam(required=false,name = "q") String categoria, @RequestParam(required=false,name ="d") String  descuento){
        productoService.buscarProductosPorCategoriaYAplicarOferta(categoria, Integer.valueOf(descuento));
        return productoService.findAll();
    }

    @CrossOrigin
    @PutMapping("/api/buscarProductoPorIdYAplicarOferta/{id}")
    public void buscarProductoPorIdYAplicarOferta(@PathVariable long id, @RequestParam("d") int descuento){
        Producto prodRes = productoService.findById(id);
        productoService.buscarProductoYAplicarOferta(prodRes, descuento);
    }

}