package ar.org.centro35.herramientas.test;

import ar.org.centro35.herramientas.entities.Herramienta;
import ar.org.centro35.herramientas.enums.HerramientaEstado;
import ar.org.centro35.herramientas.enums.HerramientaTipo;
import ar.org.centro35.herramientas.repositories.HerramientaRepository;

public class TestHerramientaRepository {
    public static void main(String[] args) {

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramienta Repository");
        System.out.println("*******************************************************************");

        HerramientaRepository hr=new HerramientaRepository();      
        Herramienta herramienta=new Herramienta(
                                            "Bahco",
                                            HerramientaTipo.MANUAL, 
                                            "Llave Francesa 2''", 
                                            HerramientaEstado.BUENA, 
                                            ""
                                );
        
        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .getById()");
        System.out.println("*******************************************************************");
        System.out.println(hr.getById(12));

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .remove()");
        System.out.println("*******************************************************************");
        hr.remove(hr.getById(30));

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .save()");
        System.out.println("*******************************************************************");
        hr.save(herramienta);
        System.out.println(herramienta);

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .getAll()");
        System.out.println("*******************************************************************");
        hr.getAll().forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .getLikeMarca()");
        System.out.println("*******************************************************************");
        hr.getLikeMarca("bo").forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Herramientas Repository .getLikeDescripcion()");
        System.out.println("*******************************************************************");
        hr.getLikeDescripcion("si").forEach(System.out::println);

     
    }
}
