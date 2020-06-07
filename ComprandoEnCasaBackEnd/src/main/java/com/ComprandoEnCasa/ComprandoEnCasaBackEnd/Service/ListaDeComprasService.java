package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;



import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.ListaDeComprasRepository;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListaDeComprasService {

    @Autowired
    private ListaDeComprasRepository listaDeComprasRepository;

    @Transactional
    public ListaDeCompras save(ListaDeCompras model) {

        return this.listaDeComprasRepository.save(model);
    }

    public ListaDeCompras findById(Integer id) {
        return this.listaDeComprasRepository.findById(id).get();
    }

    public List<ListaDeCompras> findAll(){
        return listaDeComprasRepository.findAll();
    }
}
