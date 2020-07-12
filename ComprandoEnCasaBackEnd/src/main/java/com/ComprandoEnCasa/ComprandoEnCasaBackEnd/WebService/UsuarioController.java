package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Dao.CompraDAO;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.*;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.UsuarioService;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.uqbar.xtrest.api.annotation.Body;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UsuarioController {
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


    @CrossOrigin
    @GetMapping("/api/usuario/historialDeCompras/{id}")
    public List<ListaDeCompras> getHistorialDeComprasByIdUser(@PathVariable Long id){
        // Busco el historial de compras que tiene el usuario con el ID corespondiente.
        return usuarioService.findById(id).getHistorialDeCompras();
    }


    @CrossOrigin
    @PutMapping("api/usuario/actualizarUsuario/{id}")
    public Usuario updateUsuarioData(@RequestBody Usuario usuario, @PathVariable Long id) {
        /*Actualizo los datos del usuario.*/
        return usuarioService.updateUsuario(usuario,id);
    }

    @CrossOrigin
    @PostMapping("api/login")
    UsuarioSimpleLogin loginUser(@RequestBody UsuarioLogin user){
        //usuarioService.save(user);
        return usuarioService.loginUsuario(user);
    }

    @CrossOrigin
    @PostMapping("api/register")
    UsuarioSimpleRegister registerUser(@RequestBody UsuarioRegister user){
        return usuarioService.registrarUsuario(user);
    }


    @CrossOrigin
    @PostMapping("api/usuario/loginWithGoogle")
    public Usuario loginUserWithGoogle(@RequestBody UsuarioLogin user){
        //Primero busco el usuario que coincida con el mail de google logueado, si no existe lo creo y lo devuelvo para que despues el frontend se encargue de gestionar los datos.
        return usuarioService.loguearWithGoogle(user);
    }


    @CrossOrigin
    @PutMapping("api/usuario/realizarCompra/{id}")
    public Usuario realizarCompraEnChanguito(@RequestBody CompraDAO compraDAO, @PathVariable Long id){
        // agrego al historial de compras los productos agregados en el carrito del usuario
        return usuarioService.realizarCompra(id,compraDAO.getModoEnvio());
    }


}