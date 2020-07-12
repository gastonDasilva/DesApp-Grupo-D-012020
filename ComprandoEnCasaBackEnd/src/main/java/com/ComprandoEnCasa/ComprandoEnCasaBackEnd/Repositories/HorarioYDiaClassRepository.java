package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.HorarioYDiaClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HorarioYDiaClassRepository extends CrudRepository<HorarioYDiaClass, Integer> {

    Optional<HorarioYDiaClass> findById(Long id);

    List<HorarioYDiaClass> findAll();
}
