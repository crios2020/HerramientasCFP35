package ar.org.centro35.herramientas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.org.centro35.herramientas.utils.colors.Color;
import ar.org.centro35.herramientas.utils.properties.SystemProperties;

@SpringBootApplication
public class HerramientasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerramientasApplication.class, args);

		System.out.println(Color.ANSI_GREEN);
		System.out.println("*************************************************************");
		System.out.println("*                                                           *");
		System.out.println("*        Centro de formación profesional Nro 35             *");
		System.out.println("*                                                           *");
		System.out.println("*************************************************************");
		System.out.println("- Sistema de prestamo de herramientas - Version 0.2 Prototipo");
		System.out.println("- "+new SystemProperties().getSystem());
		System.out.println("- "+new SystemProperties().getJava());
		System.out.println("- "+new SystemProperties().getFecha());
		System.out.println("- "+new SystemProperties().getUbicacion());
		System.out.println("- Servidor encendido url: http://localhost:8088/");
		System.out.println(Color.ANSI_RESET);

		//para arrancar el server desde una consola bash
		//sh mvnw spring-boot:run
		
	}

}
