package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findById(Long id);

    List<Usuario> findAll();

    @Query(value = "Select * from BSUsuario where email like %?1%", nativeQuery = true)
    Optional<Usuario> findByEmail(String  email);

    @Query(value = "SELECT BSUsuario.id FROM BSProducto INNER JOIN BSUsuario ON(BSUsuario.pd_fk = BSProducto.id ) WHERE BSProducto.id IN (?1) ",nativeQuery = true)
    List<Long>findUserIDsFRomProductsIDs(String productosID);

}
