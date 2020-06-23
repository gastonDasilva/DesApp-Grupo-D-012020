package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.UsuarioLogin;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.UsuarioSimpleLogin;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.UsuarioRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.JSONParserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario model) {
        return this.usuarioRepository.save(model);
    }


    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).get();
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Usuario newuser, Long idUser){
        /*Actualizo los datos del usuario   */
        return usuarioRepository.findById(idUser).map(
                user -> {
                    /*por ahora hago que se actualizen estos datos. A futuro se van a actualizar mas cosas*/
                    user.setNombreUsuario(newuser.getNombreUsuario());
                    user.setCalle(newuser.getCalle());
                    user.setProvincia(newuser.getProvincia());
                    user.setCodigoPostal(newuser.getCodigoPostal());
                    user.setImagenPerfil(newuser.getImagenPerfil());
                    user.setLocalidad(newuser.getLocalidad());
                    return usuarioRepository.save(user);
        }).get();
    }


    public Usuario agregarProductoAComercio(Producto newProducto, Long idUser){
       return usuarioRepository.findById(idUser).map(
                user -> {
                    user.agregarProductoForComercio(newProducto);
                    return usuarioRepository.save(user);
                }).get();
    }


    public UsuarioSimpleLogin loginUsuario(UsuarioLogin usuario){
        List<Usuario> users = this.findAll();
        UsuarioSimpleLogin user = null;
        for(Usuario u: users){
            if(Objects.equals(usuario.getUsername(), u.getNombreUsuario()) &&
               Objects.equals(usuario.getPassword(), u.getPassword())){
               user = new UsuarioSimpleLogin(u.getId(), u.getNombreUsuario(), u.getEmail(), u.getEsComercio());
            }
        }
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "login fallido!");
        }
        return user;
    }

}
