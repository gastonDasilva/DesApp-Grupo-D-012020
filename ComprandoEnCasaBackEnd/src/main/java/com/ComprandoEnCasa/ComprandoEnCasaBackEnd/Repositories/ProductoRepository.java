package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
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

}
