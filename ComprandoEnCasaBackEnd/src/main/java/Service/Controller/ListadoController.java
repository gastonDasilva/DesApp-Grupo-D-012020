package Service.Controller;

import Modelo.Producto;
import Service.ServiceRest.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListadoController {

    private final ProductoService productoService;

    public ListadoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @CrossOrigin
    @GetMapping("/api/productos")
    public List<Producto> listarProductos(){
        //Busqueda de  productos para comprar como cliente.
        return productoService.buscarProductos();
    }

    @GetMapping("/api")
    public String ping(){
        return "PING";
    }
}
