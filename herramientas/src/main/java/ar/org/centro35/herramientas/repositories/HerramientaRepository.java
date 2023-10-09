package ar.org.centro35.herramientas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.entities.Herramienta;
import ar.org.centro35.herramientas.enums.HerramientaEstado;
import ar.org.centro35.herramientas.enums.HerramientaTipo;

public class HerramientaRepository {
    
    private Connection conn=Connector.getConnection();

    public void save(Herramienta herramienta){
        if(herramienta==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into herramientas (codigo_articulo,marca,tipo,descripcion,estado,observaciones) values (?,?,?,?,?,?)", 
                PreparedStatement.RETURN_GENERATED_KEYS
            )){
                ps.setString(1, herramienta.getCodigo_articulo());
                ps.setString(2, herramienta.getMarca());
                ps.setString(3, herramienta.getTipo().toString());
                ps.setString(4, herramienta.getDescripcion());
                ps.setString(5, herramienta.getEstado().toString());
                ps.setString(6, herramienta.getObservaciones());
                ps.execute();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()) herramienta.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }    
    }

    public void remove(Herramienta herramienta){
        if(herramienta==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update herramientas set estado='FUERA_DE_USO' where id=?")){
            ps.setInt(1, herramienta.getId());    
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Herramienta>getAll(){
        List<Herramienta>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from herramientas where estado != 'FUERA_DE_USO'")){
            while(rs.next()){
                list.add(new Herramienta(
                                            rs.getInt("id"), 
                                            rs.getString("codigo_articulo"), 
                                            rs.getString("marca"), 
                                            HerramientaTipo.valueOf(rs.getString("tipo")), 
                                            rs.getString("descripcion"), 
                                            HerramientaEstado.valueOf(rs.getString("estado")), 
                                            rs.getString("observaciones")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Herramienta>getAllXL(){
        List<Herramienta>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from herramientas")){
            while(rs.next()){
                list.add(new Herramienta(
                                            rs.getInt("id"), 
                                            rs.getString("codigo_articulo"), 
                                            rs.getString("marca"), 
                                            HerramientaTipo.valueOf(rs.getString("tipo")), 
                                            rs.getString("descripcion"), 
                                            HerramientaEstado.valueOf(rs.getString("estado")), 
                                            rs.getString("observaciones")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Herramienta>getLikeMarca(String marca){
        List<Herramienta>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from herramientas where marca like '%"+marca+"%' and estado != 'FUERA_DE_USO'")){
            while(rs.next()){
                list.add(new Herramienta(
                                            rs.getInt("id"), 
                                            rs.getString("codigo_articulo"), 
                                            rs.getString("marca"), 
                                            HerramientaTipo.valueOf(rs.getString("tipo")), 
                                            rs.getString("descripcion"), 
                                            HerramientaEstado.valueOf(rs.getString("estado")), 
                                            rs.getString("observaciones")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Herramienta>getLikeDescripcion(String descripcion){
        List<Herramienta>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from herramientas where descripcion like '%"+descripcion+"%' and estado != 'FUERA_DE_USO'")){
            while(rs.next()){
                list.add(new Herramienta(
                                            rs.getInt("id"), 
                                            rs.getString("codigo_articulo"), 
                                            rs.getString("marca"), 
                                            HerramientaTipo.valueOf(rs.getString("tipo")), 
                                            rs.getString("descripcion"), 
                                            HerramientaEstado.valueOf(rs.getString("estado")), 
                                            rs.getString("observaciones")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Herramienta getById(int id){
        Herramienta herramienta=new Herramienta();
        try(ResultSet rs=conn.createStatement().executeQuery("select * from herramientas where id="+id)) {
            if(rs.next()){
                herramienta=new Herramienta(
                                            rs.getInt("id"), 
                                            rs.getString("codigo_articulo"), 
                                            rs.getString("marca"), 
                                            HerramientaTipo.valueOf(rs.getString("tipo")), 
                                            rs.getString("descripcion"), 
                                            HerramientaEstado.valueOf(rs.getString("estado")), 
                                            rs.getString("observaciones")
                            );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return herramienta;
    }
}