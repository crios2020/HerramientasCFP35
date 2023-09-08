package ar.org.centro35.herramientas.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector {

    // Localhost   
    private static String url="jdbc:mariadb://localhost:3306/herramientasCFP35";
    private static String user="root";
    private static String pass="";

    // db4free
    // private static String url="jdbc:mariadb://db4free.net:3306/basegeneral";
    // private static String user="basegeneral";
    // private static String pass="basegeneral";

    private static Connection conn=null;

    public static String getUrl() {
        return url;
    }

    private Connector(){}

    public synchronized static Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                conn=DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

}