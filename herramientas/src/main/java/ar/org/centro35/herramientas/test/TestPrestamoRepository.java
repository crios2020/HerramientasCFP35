package ar.org.centro35.herramientas.test;

import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;
import ar.org.centro35.herramientas.utils.properties.SystemProperties;

public class TestPrestamoRepository {
    public static void main(String[] args) {
        PrestamoRepository pr=new PrestamoRepository();

        Prestamo prestamo=new Prestamo(
                                            3, 
                                            2, 
                                            PrestamoTipo.h48, 
                                            "2023/07/07", 
                                            "2023/07/09", 
                                            PrestamoEstado.PENDIENTE, 
                                            ""
                                    );

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .save()");
        System.out.println("*******************************************************************");
        pr.save(prestamo);
        System.out.println(prestamo);

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .remove()");
        System.out.println("*******************************************************************");
        pr.remove(pr.getById(6));

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .getAll()");
        System.out.println("*******************************************************************");
        pr.getAll().forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .getByFechaPrestamo()");
        System.out.println("*******************************************************************");
        pr.getByFechaPrestamo("2023-06-05").forEach(System.out::println);

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .getById()");
        System.out.println("*******************************************************************");
        System.out.println(pr.getById(5));

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .update()");
        System.out.println("*******************************************************************");
        Prestamo prestamox=pr.getById(22);
        prestamox.setEstado_devolucion(PrestamoEstado.TERMINADO);
        prestamox.setFecha_devolucion(new SystemProperties().getFechaSQL());
        System.out.println(prestamox);
        pr.update(prestamox);
    }
}
