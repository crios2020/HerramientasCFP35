package ar.org.centro35.herramientas.test;

import java.time.LocalDate;

public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate ld=LocalDate.now();
        System.out.println(ld.getDayOfWeek().getValue());
        System.out.println(ld.getMonthValue());
    }   
}
