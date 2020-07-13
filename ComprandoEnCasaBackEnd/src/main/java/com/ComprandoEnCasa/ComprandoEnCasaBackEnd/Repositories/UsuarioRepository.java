package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findById(Long id);

    List<Usuario> findAll();

    @Query(value = "Select * from BSUsuario where email like %?1%", nativeQuery = true)
    Optional<Usuario> findByEmail(String  email);

    @Query(value = "SELECT DISTINCT BSUsuario.id FROM BSProducto INNER JOIN BSUsuario ON(BSProducto.pd_fk = BSUsuario.id ) WHERE BSProducto.id IN :productos ",nativeQuery = true)
    List<Long>findUserIDsFRomProductsIDs(@Param("productos") List<Long> productosID);

}
