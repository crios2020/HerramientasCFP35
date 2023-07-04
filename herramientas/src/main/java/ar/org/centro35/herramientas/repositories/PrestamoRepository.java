package ar.org.centro35.herramientas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.enums.PrestamoTipo;
import ar.org.centro35.herramientas.enums.TipoDocumento;

public class PrestamoRepository {
    
    private Connection conn=Connector.getConnection();

    public void save(Prestamo prestamo){
        if(prestamo==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into prestamos "+
            "(id_herramienta, id_socio, tipo_prestamo_hs, fecha_prestamo, fecha_devolucion, estado_devolucion, observaciones)"+
            " values (?,?,?,?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setInt(1, prestamo.getId_herramienta());
            ps.setInt(2, prestamo.getId_socio());
            ps.setString(3, prestamo.getTipo_prestamo().toString());
            ps.setString(4, prestamo.getFecha_prestamo());
            ps.setString(5, prestamo.getFecha_devolucion());
            ps.setString(6, prestamo.getEstado_devolucion().toString());
            ps.setString(7, prestamo.getObservaciones());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) prestamo.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Prestamo prestamo){
      
    }
    
    public List<Prestamo>getAll(){           //select * from socios
        return null;
    }

    public List<Prestamo>getLikeApellido(String apellido){           //select * from socios where apellido like '%apellido%'
        return null;
    }

    public Prestamo getById(int id){     //select * from socios where id=?
        return null; 
    }
}
