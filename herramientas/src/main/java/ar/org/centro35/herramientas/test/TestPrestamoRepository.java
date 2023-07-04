package ar.org.centro35.herramientas.test;

import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;
import ar.org.centro35.herramientas.repositories.PrestamoRepository;

public class TestPrestamoRepository {
    public static void main(String[] args) {
        PrestamoRepository pr=new PrestamoRepository();

        Prestamo prestamo=new Prestamo(
                                            3, 
                                            1, 
                                            PrestamoTipo.h48, 
                                            "2023/07/04", 
                                            "2023/07/06", 
                                            PrestamoEstado.PENDIENTE, 
                                            ""
                                    );

        System.out.println("*******************************************************************");
        System.out.println("* Test Prestamo Repository .save()");
        System.out.println("*******************************************************************");
        pr.save(prestamo);
        System.out.println(prestamo);
    }
}
