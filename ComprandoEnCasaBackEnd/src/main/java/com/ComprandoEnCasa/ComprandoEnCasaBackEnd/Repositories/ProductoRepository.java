package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Configuration;
import java.util.List;

import java.util.Optional;


@Configuration
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    Optional<Producto> findById(Long id);

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

    /** Realizo la búsqueda de todos los productos cuya categoria tenga contenido el string "categoria" traido por parámetro**/
    @Query(value = "Select * from BSProducto where categoria like %?1%", nativeQuery = true)
    List<Producto> findByCategoriaProductoContaining(String categoria);


    @Modifying
    @Query(value = "update BSProducto p set p.precio = (p.precio - ((p.precio * :descuento) / 100)) where p.categoria = :category", nativeQuery = true)
    void findByCategoriaProductoContainingWithOferta(@Param("descuento") int precio, @Param("category") String categoria);

    @Modifying
    @Query(value = "update BSProducto p set p.precio = (p.precio - ((p.precio * :descuento) / 100)) where p.id = :id", nativeQuery = true)
    void findByProductoContainingWithOferta(@Param("descuento") int precio, @Param("id") long id);
}
