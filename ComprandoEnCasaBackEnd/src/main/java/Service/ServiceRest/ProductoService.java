package Service.ServiceRest;

import Modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    public List<Producto> buscarProductos(){
        List<Producto> productos = new ArrayList<Producto>();

        Producto pr1 = new Producto("Papas Light");
        pr1.setPrecio(10);
        pr1.setMarca("Pringles");
        pr1.setImagen("https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg");
        pr1.setCategoria("Comida");
        pr1.setStock(10);

        Producto pr2 = new Producto("Chocolate Harley");
        pr2.setPrecio(10);
        pr2.setMarca("Harley");
        pr2.setImagen("https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg");
        pr2.setCategoria("Comida");
        pr2.setStock(10);

        Producto pr3 = new Producto("Yogurt Serenisima");
        pr3.setPrecio(10);
        pr3.setMarca("La Serenisima");
        pr3.setImagen("https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg");
        pr3.setCategoria("Comida");
        pr3.setStock(10);

        Producto pr4 = new Producto("Fideos Mostacholes");
        pr4.setPrecio(10);
        pr4.setMarca("Mostacholes");
        pr4.setImagen("https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg");
        pr4.setCategoria("Comida");
        pr4.setStock(10);

        productos.add(pr1);
        productos.add(pr2);
        productos.add(pr3);
        productos.add(pr4);

        return productos;
    }
}
