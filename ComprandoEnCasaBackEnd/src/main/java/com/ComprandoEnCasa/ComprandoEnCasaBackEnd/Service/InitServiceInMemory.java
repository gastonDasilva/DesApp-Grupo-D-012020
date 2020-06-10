package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import javax.annotation.PostConstruct;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.ListaDeCompras;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder.UsuarioBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InitServiceInMemory {



    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private  ListaDeComprasService ListaDeComprasService;

    @PostConstruct
    public void initialize() {
        if (className.equals("org.h2.Driver")) {
            logger.warn("Init Data Using H2 DB");
            fireInitialData();
        }
    }

    private void fireInitialData(){
        Producto producto = new Producto("Papas Light", "Pringles", 20, 140, "https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg", "Comida");
        productoService.save(producto);
        producto = new Producto("Chocolate Hershey", "Hershey", 51, 87, "https://images-na.ssl-images-amazon.com/images/I/61ZhqmPIdSL._SL1280_.jpg", "Comida");
        productoService.save(producto);
        producto = new Producto("Yogurt Serenisima", "La Serenisima", 42, 43, "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3261979_f.jpg", "Comida");
        productoService.save(producto);
        producto = new Producto("Fideos Mostacholes", "Matarazzo", 12, 50, "https://i3-unileverar.a8e.net.br/gg/fideos-mostachol-matarazzo-500g_172827245_7790070318596.jpg", "Comida");
        productoService.save(producto);

        producto = new Producto("Fernet Branca", "Branca", 20, 200, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQDqKz5TenqnxQU6HoIy3uYgifJeoqutH5Xfyy0WtBxwrnlm0Po&usqp=CAU", "Comida");
        productoService.save(producto);
        producto = new Producto("Alfajor Oreo", "Oreo Milk", 51, 87, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQdD8r5tbcIp-_03h4xCMzMV-G9CTcJALyN1cpCO-8Ruru400dR&usqp=CAU", "Comida");
        productoService.save(producto);
        producto = new Producto("Harina 0000", "Pureza", 14, 52, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTvrqMNHeCSbHTrtHf5xkZEDLw3JXEZUUVRDpr2huqRSrdBtPhY&usqp=CAU", "Comida");
        productoService.save(producto);
        producto = new Producto("Coca Cola en Lata", "Colca cola", 12, 65, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ9JZuIjzpIEe0LOajQmW5vQ5Nosn23CurhJQzYGhESF3GJMFUM&usqp=CAU", "Bebida");
        productoService.save(producto);

        /*Initialize Users*/

        ListaDeCompras listaCompras = new ListaDeCompras();
        listaCompras.agregarProducto(producto);
        ListaDeComprasService.save(listaCompras);

        Usuario usuario1 = new UsuarioBuilder().withNombreUsuario("UsuarioPrueba")
                                                .withEmail("UsuarioPrueba@gmail.com")
                                                .withPassword("1234")
                                                .withListaDeCompras(listaCompras)
                                                .withDireccionCalle("calle falsa 1234")
                                                .build();
        usuarioService.save(usuario1);

    }
}
