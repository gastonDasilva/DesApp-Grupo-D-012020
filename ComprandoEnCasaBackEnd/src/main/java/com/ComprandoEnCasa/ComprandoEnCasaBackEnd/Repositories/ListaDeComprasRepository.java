package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ListaDeComprasRepository extends CrudRepository<ListaDeCompras, Integer> {

        Optional<ListaDeCompras> findById(Long id);

        List<ListaDeCompras> findAll();

}
