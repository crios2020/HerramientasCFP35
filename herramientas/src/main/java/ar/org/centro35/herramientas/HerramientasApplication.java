package ar.org.centro35.herramientas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.org.centro35.herramientas.utils.colors.Color;
import ar.org.centro35.herramientas.utils.properties.SystemProperties;

@SpringBootApplication
public class HerramientasApplication {

	public static void main(String[] args) {
		
		//Retardo de inicio para dar tiempo a que encienda el server de BD
		System.out.println("Iniciando Server ..........");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		SpringApplication.run(HerramientasApplication.class, args);

		System.out.println(Color.ANSI_GREEN);
		System.out.println("*************************************************************");
		System.out.println("*                                                           *");
		System.out.println("*        Sistema electrónico de pañol de herramientas       *");
		System.out.println("*                                                           *");
		System.out.println("*************************************************************");
		System.out.println("- Version 0.3 Prototipo");
		System.out.println("- "+new SystemProperties().getSystem());
		System.out.println("- "+new SystemProperties().getJava());
		System.out.println("- "+new SystemProperties().getFecha());
		System.out.println("- "+new SystemProperties().getUbicacion());
		System.out.println("- Servidor encendido url: http://localhost:8088/");
		System.out.println(Color.ANSI_RESET);
		
	}

}
