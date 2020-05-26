package Service.ServiceRest;

import javax.annotation.PostConstruct;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InitServiceInMemory {

    /*

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${pring.datasource.driverClassName:NONE}")
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
        long lon = 1;
        Producto producto = new Producto("fernet", "branca", 20, 290, "img_0001", "Bebida con alcohol", lon);
        productoService.save(producto);
    }
*/
}
