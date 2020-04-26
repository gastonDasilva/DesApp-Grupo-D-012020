package Service.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListadoController {

    @RequestMapping("/")
    public String listarProductos(){
        //Busqueda de  productos para comprar como cliente.
        return "";
    }
}
