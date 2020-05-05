package com.ComprandoEnCasa.ComprandoEnCasaBackEnd;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;
import Service.Controller.ListadoController;
import Service.ServiceRest.ProductoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ProductoService.class,ListadoController.class})
public class ComprandoEnCasaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComprandoEnCasaBackEndApplication.class, args);
	}

}
