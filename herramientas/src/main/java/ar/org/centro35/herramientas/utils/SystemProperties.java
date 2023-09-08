package ar.org.centro35.herramientas.utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.cglib.core.Local;

public class SystemProperties{
    
    public String getSystem(){
        return  System.getProperty("os.name")+", "+
                System.getProperty("os.version")+", "+
                System.getProperty("os.arch");
    }

    public String getJava(){
        return  System.getProperty("java.vm.name")+", "+
                System.getProperty("java.version");
    }

    public String getUser(){
        return System.getProperty("user.name");
    }

    public String getUbicacion(){
        return Calendar
                    .getInstance()
                    .getTimeZone()
                    .getID()
                    .replace("_", " ")
                    .replace("/", " ");
    }

    public String getFecha(){
        LocalDate ld=LocalDate.now();
        DecimalFormat df=new DecimalFormat("00");
        List<String>dias=List.of(
                                    "Lunes", 
                                    "Martes", 
                                    "Miércoles", 
                                    "Jueves", 
                                    "Viernes", 
                                    "Sábado", 
                                    "Domingo"
                                );
        List<String>meses=List.of(
                                    "Enero", 
                                    "Febrero", 
                                    "Abril", 
                                    "Mayo", 
                                    "Junio", 
                                    "Julio", 
                                    "Agosto", 
                                    "Septiembre", 
                                    "Octubre", 
                                    "Noviembre", 
                                    "Diciembre"
                                );
        return          dias.get(ld.getDayOfWeek().getValue()-1)+" "+
                        ld.getDayOfMonth()+" de "+
                        meses.get(ld.getMonthValue()-1)+" de "+
                        ld.getYear();
    }
}