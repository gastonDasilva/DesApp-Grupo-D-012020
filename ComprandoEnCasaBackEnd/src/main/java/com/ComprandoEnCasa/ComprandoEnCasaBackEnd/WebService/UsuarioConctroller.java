package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.ProductoService;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UsuarioConctroller {
    @Autowired
    private UsuarioService usuarioService;


    @CrossOrigin
    @GetMapping("/api/usuarios")
    public List<Usuario> listarProductos(){
        //Busqueda de  productos para comprar como cliente.
        return usuarioService.findAll();
    }


    @CrossOrigin
    @GetMapping("/api/usuario/{id}")
    public Usuario getUsuarioByID(@PathVariable Long id){
        //Busco y devuelvo el usuario con el id correspondiente traido por  parametro
        return usuarioService.findById(id);
    }


    @CrossOrigin
    @GetMapping("/api/usuario/listaDeCompras/{id}")
    public ListaDeCompras getListaDeComprasBYIDUser(@PathVariable Long id){
        //Busco la lista de compras(carrito) que tiene el usuario con el ID correspondiente.
        return usuarioService.findById(id).getListaDeCompras();
    }

}
