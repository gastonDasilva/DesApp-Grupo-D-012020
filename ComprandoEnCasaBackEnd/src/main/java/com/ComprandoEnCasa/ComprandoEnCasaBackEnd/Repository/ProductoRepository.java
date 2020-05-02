package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repository;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
