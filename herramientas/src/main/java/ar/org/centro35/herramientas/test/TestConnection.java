package ar.org.centro35.herramientas.test;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalTime;
import ar.org.centro35.herramientas.connectors.Connector;

public class TestConnection {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        LocalTime ltInicial=LocalTime.now();
        try (ResultSet rs = Connector.getConnection().createStatement().executeQuery("select version()")) {
            if(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(ANSI_GREEN+"OK\tSe pudo conectar a la base de datos!");
                LocalTime ltFinal=LocalTime.now();
                Duration duration=Duration.between(ltInicial, ltFinal);
                System.out.println(ANSI_RESET+"Tiempo en conectarse: "+duration.toMillis()+" ms.");
                if(duration.toMillis()<1000){
                    System.out.println(ANSI_GREEN+"OK\tVelocidad Aceptable");
                }else{
                    System.out.println(ANSI_RED+"ERROR\tVelocidad MUY LENTA");
                }
            }else{
                System.out.println(ANSI_RED+"ERROR\tNo se pudo conectar a la base de datos!");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(ANSI_RED+"ERROR\tNo se pudo conectar a la base de datos!");
        }
        System.out.println(ANSI_RESET);
    }
}