package ar.org.centro35.herramientas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ar.org.centro35.herramientas.connectors.Connector;
import ar.org.centro35.herramientas.entities.Socio;
import ar.org.centro35.herramientas.enums.SocioEstado;
import ar.org.centro35.herramientas.enums.TipoDocumento;

public class SocioRepository {
    
    private Connection conn=Connector.getConnection();

    public void save(Socio socio){
        if(socio==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into socios "+
            "(nombre, apellido, tipo_documento, numero_documento, direccion, celular, telefono_linea, email, comentarios)"+
            " values (?,?,?,?,?,?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
                ps.setString(1, socio.getNombre());
                ps.setString(2, socio.getApellido());
                ps.setString(3, socio.getTipo_documento().toString());
                ps.setString(4, socio.getNumero_documento());
                ps.setString(5, socio.getDireccion());
                ps.setString(6, socio.getCelular());
                ps.setString(7, socio.getTelefono_linea());
                ps.setString(8, socio.getEmail());
                ps.setString(9, socio.getComentarios());
                ps.execute();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()) socio.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Socio socio){
       if(socio==null) return;
       try (PreparedStatement ps=conn.prepareStatement("update socios set estado='NO_ACTIVO' where id=?")){
            ps.setInt(1,socio.getId());
            ps.execute();
       } catch (Exception e) {
            System.out.println(e);
       }
    }
    
    public List<Socio>getAll(){
        List<Socio>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from socios where estado!='NO_ACTIVO'")){
            while(rs.next()){
                list.add(new Socio(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("apellido"), 
                    TipoDocumento.valueOf(rs.getString("tipo_documento")), 
                    rs.getString("numero_documento"),
                    rs.getString("direccion"), 
                    rs.getString("celular"), 
                    rs.getString("telefono_linea"), 
                    rs.getString("email"), 
                    rs.getString("comentarios"),
                    SocioEstado.valueOf(rs.getString("estado"))
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Socio>getAllXL(){
        List<Socio>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from socios")){
            while(rs.next()){
                list.add(new Socio(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("apellido"), 
                    TipoDocumento.valueOf(rs.getString("tipo_documento")), 
                    rs.getString("numero_documento"),
                    rs.getString("direccion"), 
                    rs.getString("celular"), 
                    rs.getString("telefono_linea"), 
                    rs.getString("email"), 
                    rs.getString("comentarios"),
                    SocioEstado.valueOf(rs.getString("estado"))
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Socio>getLikeApellido(String apellido){       
          List<Socio>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery(
                "select * from socios where apellido like '%"+apellido+"%' and estado!='NO_ACTIVO'")){
            while(rs.next()){
                list.add(new Socio(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("apellido"), 
                    TipoDocumento.valueOf(rs.getString("tipo_documento")), 
                    rs.getString("numero_documento"),
                    rs.getString("direccion"), 
                    rs.getString("celular"), 
                    rs.getString("telefono_linea"), 
                    rs.getString("email"), 
                    rs.getString("comentarios"),
                    SocioEstado.valueOf(rs.getString("estado"))
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Socio getById(int id){     //select * from socios where id=?
        Socio socio=new Socio();
        try  (ResultSet rs=conn.createStatement().executeQuery("select * from socios where id="+id)) {
            if(rs.next()){
                socio=new Socio(
                        rs.getInt("id"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        TipoDocumento.valueOf(rs.getString("tipo_documento")), 
                        rs.getString("numero_documento"),
                        rs.getString("direccion"), 
                        rs.getString("celular"), 
                        rs.getString("telefono_linea"), 
                        rs.getString("email"), 
                        rs.getString("comentarios"),
                        SocioEstado.valueOf(rs.getString("estado"))
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return socio; 
    }
}
