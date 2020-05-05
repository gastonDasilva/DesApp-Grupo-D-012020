package Service.ServiceRest;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> buscarProductos(){
        return productoRepository.findAll();
    }
}
