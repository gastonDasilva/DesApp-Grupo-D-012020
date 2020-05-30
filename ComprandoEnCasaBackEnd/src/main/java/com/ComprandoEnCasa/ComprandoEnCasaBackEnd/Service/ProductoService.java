package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //public ProductoService(ProductoRepository productoRepository) {
    //   this.productoRepository = productoRepository;
    //}

    @Transactional
    public Producto save(Producto model) {
        return this.productoRepository.save(model);
    }

    public Producto findById(Integer id) {
        return this.productoRepository.findById(id).get();
    }

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

}
