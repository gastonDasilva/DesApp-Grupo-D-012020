package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.ProductoRepository;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
