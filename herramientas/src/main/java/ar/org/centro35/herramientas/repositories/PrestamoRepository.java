package ar.org.centro35.herramientas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.entities.Prestamo;
import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;

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
            ps.setString(3, prestamo.getTipo_prestamo_hs().toString());
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
        if(prestamo==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from prestamos where id=?")){
            ps.setInt(1, prestamo.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Prestamo>getAll(){           //select * from prestamos
        List<Prestamo>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from prestamos")){
            while(rs.next()){
                list.add(new Prestamo(
                                        rs.getInt("id"), 
                                        rs.getInt("id_herramienta"), 
                                        rs.getInt("id_socio"), 
                                        PrestamoTipo.valueOf(rs.getString("tipo_prestamo_hs")), 
                                        rs.getString("fecha_prestamo"), 
                                        rs.getString("fecha_devolucion"), 
                                        PrestamoEstado.valueOf(rs.getString("estado_devolucion")), 
                                        rs.getString("observaciones")
                                    ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Prestamo>getByFechaPrestamo(String fecha_prestamo){           //select * from prestamos where fecha_prestamo=fecha_prestamo
        List<Prestamo>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from prestamos where fecha_prestamo='"+fecha_prestamo+"'")){
            while(rs.next()){
                list.add(new Prestamo(
                                        rs.getInt("id"), 
                                        rs.getInt("id_herramienta"), 
                                        rs.getInt("id_socio"), 
                                        PrestamoTipo.valueOf(rs.getString("tipo_prestamo_hs")), 
                                        rs.getString("fecha_prestamo"), 
                                        rs.getString("fecha_devolucion"), 
                                        PrestamoEstado.valueOf(rs.getString("estado_devolucion")), 
                                        rs.getString("observaciones")
                                    ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Prestamo getById(int id){     //select * from prestamos where id=?
        Prestamo prestamo=new Prestamo();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from prestamos where id="+id)) {
            if(rs.next()){
                prestamo=new Prestamo(
                                        rs.getInt("id"), 
                                        rs.getInt("id_herramienta"), 
                                        rs.getInt("id_socio"), 
                                        PrestamoTipo.valueOf(rs.getString("tipo_prestamo_hs")), 
                                        rs.getString("fecha_prestamo"), 
                                        rs.getString("fecha_devolucion"), 
                                        PrestamoEstado.valueOf(rs.getString("estado_devolucion")), 
                                        rs.getString("observaciones")
                                    );    
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return prestamo; 
    }
}
