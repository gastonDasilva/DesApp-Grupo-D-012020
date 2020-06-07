package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Configuration;
import java.util.List;

import java.util.Optional;


@Configuration
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    Optional<Producto> findById(Integer id);

    List<Producto> findAll();

    /*Se puede usar JQPL "Select p from Producto p order by p.nombreProducto", donde no estamos consultando las tablas sino consultamos las instancias alamacenadas en la BD de una clase
    * En caso de usar SQL  hay que poner nativeQuery en true*/
    /**Realizo la busqueda de todos los productos que esten guardados en la base de datos**/
    @Query(value = "Select * from BSProducto  order by nombre", nativeQuery = true)
    List<Producto> buscarTodos();


    /**Realizo la busqueda de todos los productos cuyo Nombre o Marca tenga contenida el string "consulta" traido por parametro**/
    @Deprecated
    @Query(value = "Select * from BSProducto where nombre like %?1% or marca like %?1% ",nativeQuery = true)
    List<Producto> buscarProductosPorConsulta(String consulta);


    /**Realizo la busqueda de todos los productos cuyo Nombre o Marca tenga contenida el string "consulta" traido por parametro**/
    List<Producto> findBynombreProductoContaining(String consulta);

}