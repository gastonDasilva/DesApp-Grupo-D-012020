package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import javax.annotation.PostConstruct;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;
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
    }
}
