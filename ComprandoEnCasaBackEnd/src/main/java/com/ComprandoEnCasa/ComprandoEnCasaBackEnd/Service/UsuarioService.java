package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.*;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.UsuarioRepository;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.UsuarioBuilder;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.JSONParserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private  ListaDeComprasService ListaDeComprasService;
    @Autowired
    private SendMailService sendMailService;
    @Autowired
    private HorarioYDiaClassService horarioYDiaClassService;

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

    @Transactional
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
                    user.setEsComercio(newuser.getEsComercio());
                    user.setRubro(newuser.getRubro());
                    generarDiasYHorarios(user,newuser);
                    return usuarioRepository.save(user);
        }).get();
    }

    @Transactional
    private void generarDiasYHorarios(Usuario user, Usuario newUser){
        /*Genero los dias y horarios si el usuario es un comercio y el campo de dias y horarios es vacio*/
        if(user.getEsComercio()){
            List<HorarioYDiaClass> horarioYDiaClasses;
            if(user.getDiasYHorariosDeAtencion().isEmpty()){
                horarioYDiaClasses = new ArrayList<HorarioYDiaClass>();
                List<String> dias = HorarioYDiaClass.getDiasSemanales();
                for(String dia: dias){
                    /*generio los horarios y dias para los usuarios que son comercio.*/
                    HorarioYDiaClass hydia = new HorarioYDiaClass(dia,8,18);
                    hydia = horarioYDiaClassService.save(hydia);
                    horarioYDiaClasses.add(hydia);
                }
            }else{
                horarioYDiaClasses = newUser.getDiasYHorariosDeAtencion();
                /*actualizo los horarios y dias*/
                for(HorarioYDiaClass hyd: horarioYDiaClasses){
                    horarioYDiaClassService.save(hyd);
                }
            }

            user.setDiasYHorariosDeAtencion(horarioYDiaClasses);
        }
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


    public UsuarioSimpleRegister registrarUsuario(UsuarioRegister user){
        Usuario userNew = new Usuario(user.getUsername(), user.getEmail(), user.getPassword());
        UsuarioSimpleRegister userRet = new UsuarioSimpleRegister(user.getUsername(), user.getEmail(), user.getAddress());
        this.usuarioRepository.save(userNew);
        return userRet;
    }

    @Transactional
    public Usuario loguearWithGoogle(UsuarioLogin user){
        //Primero busco el usuario que coincida con el mail de google logueado, si no existe lo creo y lo devuelvo para que despues el frontend se encargue de gestionar los datos.
        Usuario userReturn = null;
        Optional<Usuario> userReturnOptioal  = this.usuarioRepository.findByEmail(user.getEmail());
        /*SI no existe un usuario con ese mail, entonces lo creo*/
        if( userReturnOptioal.isEmpty()){
            ListaDeCompras listaCompras = new ListaDeCompras();
            ListaDeComprasService.save(listaCompras);
            userReturn = new UsuarioBuilder().withNombreUsuario(user.getEmail())
                                .withEmail(user.getEmail())
                                .withPassword("")
                                .withImagenPerfil(user.getPhotoUrl())
                                .withListaDeCompras(listaCompras)
                                .build();
            /*Grabo el usuario en la BD*/
            this.save(userReturn);
        }else{
            userReturn = userReturnOptioal.get();
        }

        return userReturn;
    }

    public Usuario realizarCompra(Long idUser,Integer modo){
        return usuarioRepository.findById(idUser).map(
                user -> {
                    ListaDeCompras listaCompras = new ListaDeCompras();
                    ListaDeComprasService.save(listaCompras);
                    user.generarComprar();
                    /*Con lo de abajo se envia el mail.*/
                    enviarMailSegúnModoDeEnvio(user,modo);
                    user.setListaDeCompras(listaCompras);

                    return usuarioRepository.save(user);
                }).get();
    }

    private void enviarMailSegúnModoDeEnvio(Usuario user, Integer modo){
        /*Segun el modo de envio gestiono el mail de compra.*/
        switch (modo){
            case 0: break; /*falta implentar el mail. */
                //sendMailService.sendMail("gastonoscardasilva@gmail.com",user.getEmail(),"PRueba","Probando los mails ");
        }
    }

    private  List<Usuario> getUsuariosComercioFromCarrito(String productosID){
        List<Usuario> users = new ArrayList<Usuario>();
        List<Long> usuariosIDs =  usuarioRepository.findUserIDsFRomProductsIDs(productosID);
        for (Long userID :usuariosIDs){
            Usuario user = findById(userID);
            users.add(user);
        }
        return users;
    }

    private void gestionarMailModoRetiroEnLocal(ListaDeCompras listaDeCompras){
        String body = "";
        String productosID = listaDeCompras.getProductosIDFromCarrito();
        List<Usuario> users = getUsuariosComercioFromCarrito(productosID);
        for (Usuario user: users){
            Date turnoFecha = user.getTurnoFechaFromUserComprador();
        }
    }

}
