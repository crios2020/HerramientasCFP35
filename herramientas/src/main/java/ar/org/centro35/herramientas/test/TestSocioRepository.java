package ar.org.centro35.herramientas.test;

import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.enums.TipoDocumento;
import ar.org.centro35.herramientas.repositories.SocioRepository;

public class TestSocioRepository {
    public static void main(String[] args) {
        SocioRepository sr=new SocioRepository();      
        Socio socio=new Socio(
                            "Juana",
                            "Molina",
                            TipoDocumento.DNI,
                            "37373788",
                            "Viel 345",
                            "1698765432",
                            "5555",
                            "Juana@gmail.com",
                            "nada"
                        );

        System.out.println("*******************************************************************");
        System.out.println("* Test Socios Repository .save()");
        System.out.println("*******************************************************************");
        sr.save(socio);
        System.out.println(socio);

        System.out.println("*******************************************************************");
        System.out.println("* Test Socios Repository .remove()");
        System.out.println("*******************************************************************");
        sr.remove(sr.getById(20));


        System.out.println("*******************************************************************");
        System.out.println("* Test Socios Repository .getAll()");
        System.out.println("*******************************************************************");
        sr.getAll().forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Socios Repository .getLikeApellido()");
        System.out.println("*******************************************************************");
        sr.getLikeApellido("mo").forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Socios Repository .getById()");
        System.out.println("*******************************************************************");
        System.out.println(sr.getById(12));

    }
}
