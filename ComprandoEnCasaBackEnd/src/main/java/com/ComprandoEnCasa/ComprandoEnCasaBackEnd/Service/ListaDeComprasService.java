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

    @Autowired
    private ProductoService productoService;

    @Transactional
    public ListaDeCompras save(ListaDeCompras model) {

        return this.listaDeComprasRepository.save(model);
    }

    public ListaDeCompras findById(Long id) {
        return this.listaDeComprasRepository.findById(id).get();
    }

    public List<ListaDeCompras> findAll(){
        return listaDeComprasRepository.findAll();
    }

    public ListaDeCompras agregarProductoALCarrito(Long idListaCompras, Long productoID){
        /*a partir de los ids de la lista de compras y del productos, agrego el podructo a la lista de compras correspondiente.*/
        ListaDeCompras listaCompras = findById(idListaCompras);
        listaCompras.agregarProducto(productoService.findById(productoID));
        return save(listaCompras);
    }


    public ListaDeCompras sacarProductoDelCarrito(Long idListaCompras, Long productoID){
        /*a partir de los ids de la lista de compras y del productos, saco el producto  de la lista de compras correspondiente.*/
        ListaDeCompras listaCompras = findById(idListaCompras);
        listaCompras.sacarProducto(productoID);
        return save(listaCompras);
    }
}
