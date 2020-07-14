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
        ListaDeCompras listaCompras = new ListaDeCompras();
        //listaCompras.agregarProducto(producto);
        ListaDeComprasService.save(listaCompras);

        Usuario usuario1 = new UsuarioBuilder().withNombreUsuario("Comercio Raulito")
                .withEmail("UsuarioPrueba@gmail.com")
                .withPassword("1234")
                .withListaDeCompras(listaCompras)
                .withDireccionCalle("calle falsa 1234")
                .build();
        usuario1.setLocalidad("Florencio Varela");
        usuario1.convertirAComercio();
        usuario1.setDiasYHorariosDeAtencion(usuarioService.generarHorariosYDiasDefaults(usuario1));
        Producto producto = new Producto("Papas Light", "Pringles", 20, 140, "https://ugc.kn3.net/i/760x/http://ecx.images-amazon.com/images/I/417OGU3mpcL._SS500_.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);
        producto = new Producto("Chocolate Hershey", "Hershey", 51, 87, "https://images-na.ssl-images-amazon.com/images/I/61ZhqmPIdSL._SL1280_.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);
        producto = new Producto("Yogurt Serenisima", "La Serenisima", 42, 43, "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3261979_f.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);
        producto = new Producto("Fideos Mostacholes", "Matarazzo", 12, 50, "https://i3-unileverar.a8e.net.br/gg/fideos-mostachol-matarazzo-500g_172827245_7790070318596.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);
        producto = new Producto("Fernet Branca", "Branca", 20, 200, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQDqKz5TenqnxQU6HoIy3uYgifJeoqutH5Xfyy0WtBxwrnlm0Po&usqp=CAU", "Bebida alcoholica");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Alfajor Oreo", "Oreo Milk", 51, 87, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQdD8r5tbcIp-_03h4xCMzMV-G9CTcJALyN1cpCO-8Ruru400dR&usqp=CAU", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Harina 0000", "Pureza", 14, 52, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTvrqMNHeCSbHTrtHf5xkZEDLw3JXEZUUVRDpr2huqRSrdBtPhY&usqp=CAU", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Polenta Presto Pronta", "Presto Pronta", 20, 80, "https://images-na.ssl-images-amazon.com/images/I/31cbFb4iLSL.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Dulce de batata", "Arcor", 30, 100, "https://supermercado.carrefour.com.ar/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/7/7/7790580504410.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Bebida energetica", "Gatorade", 25, 83, "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/3050983_f.jpg", "Bebida sin alcohol");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Leche con almendras", "Silk", 17, 93, "https://d26lpennugtm8s.cloudfront.net/stores/209/218/products/whatsapp-image-2020-02-16-at-14-25-561-3e79fde0416fb9f67515818741544865-640-0.jpeg", "Bebida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Café", "Arlistan", 33, 135, "https://walmartar.vteximg.com.br/arquivos/ids/835830-1000-1000/Cafe-Instantaneo-Arlistan-50-Gr-1-22269.jpg?v=636687343739270000", "Bebida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Puré de tomate", "Molto", 26, 74, "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/2340038_f.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Galletitas", "Toddy", 20, 85, "https://images-ti-vm1.tiendainglesa.com.uy/medium/P310908-1.jpg?20170830115636,Galletas-Toddy-Chispas-de-Chocolate-75g-en-Tienda-Inglesa", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Cerveza", "Patagonia", 25, 117, "https://cdn.shopify.com/s/files/1/1103/5152/products/preview-full-Patagonia_Amber_Lager_1000_x_2048_efb25f80-f87e-49c5-b9d0-8fd0b647a30b_600x.jpg?v=1559755721", "Bebida alcoholica");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Arroz", "Molinos Ala", 40, 68, "https://walmartar.vteximg.com.br/arquivos/ids/835753-1000-1000/Arroz-Blanco-Largo-Fino-Ala-1-Kg-1-14506.jpg?v=636687341787730000", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Gaseosa", "Fanta", 28, 126, "https://i5-unileverar.a8e.net.br/gg/gaseosa-fanta-1-5l_172837874_7790895000454.jpg", "Bebida sin alcohol");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Manteca", "Ilolay", 33, 216, "https://d26lpennugtm8s.cloudfront.net/stores/798/865/products/38038584-d285d9fa9ff9b6687d15721105043983-640-0.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Hamburguesa", "Good Mark", 28, 164, "https://www.maxiconsumo.com/media/catalog/product/cache/29/image/300x/9df78eab33525d08d6e5fb8d27136e95/9/2/9288_9.jpg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Tapa de empanadas", "La Salteña", 35, 68, "https://www.stock.com.py/images/thumbs/0143588.jpeg", "Comida");
        productoService.save(producto);
        usuario1.agregarProductoForComercio(producto);

        producto = new Producto("Mayonesa", "Natura", 26, 116, "https://statics.dinoonline.com.ar/imagenes/full_600x600_ma/2440048_f.jpg", "Comida");
        productoService.save(producto);

        usuario1.agregarProductoForComercio(producto);

        usuarioService.save(usuario1);

    }
}
