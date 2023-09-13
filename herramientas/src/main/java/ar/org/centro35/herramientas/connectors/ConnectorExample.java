package ar.org.centro35.herramientas.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector {

    // Localhost   
    private static String url="jdbc:mariadb://xxx:3306/xxx";
    private static String user="xxx";
    private static String pass="xxx";

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
