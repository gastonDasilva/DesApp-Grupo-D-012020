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

    @Transactional
    public Producto save(Producto model) {
        return this.productoRepository.save(model);
    }

    public Producto findById(Long id) {
        return this.productoRepository.findById(id).get();
    }

    public List<Producto> findAll(){
        return productoRepository.buscarTodos();//findAll();
    }

    public List<Producto> buscarProductoPorConsulta(String consulta){
       return productoRepository.findBynombreProductoContaining(consulta);
    }

    public List<Producto> buscarProductosPorCategoria(String categoria){
        return productoRepository.findByCategoriaProductoContaining(categoria);
    }

    @Transactional
    public void buscarProductosPorCategoriaYAplicarOferta(String categoria, int descuento){
        productoRepository.findByCategoriaProductoContainingWithOferta(descuento, categoria);
    }

    @Transactional
    public void buscarProductoYAplicarOferta(Producto producto, int descuento){
        productoRepository.findByProductoContainingWithOferta(descuento, producto.getId());
    }



}
