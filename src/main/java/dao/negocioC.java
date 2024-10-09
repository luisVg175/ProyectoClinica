
package dao;
import java.sql.*;
import util.MySQLConexion;
import java.util.*;
import modelo.*;


public class negocioC {
     //Lista de pacientes
    
    public List<paciente> lisPac(){
        List<paciente> lista= new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
             String sql = "select idPaciente,Dni,nombre,apellidos,genero,telefono,fechaNaci,direccion,seguro"
                     +" from paciente";
             PreparedStatement st = cn.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                paciente p = new paciente();
                p.setCodP(rs.getInt(1));
                p.setDni(rs.getInt(2));
                p.setNomP(rs.getString(3));
                p.setApeP(rs.getString(4));
                p.setGenero(rs.getString(5));
                p.setTelefono(rs.getString(6));
                p.setFechaP(rs.getString(7));
                p.setDireccion(rs.getString(8));
                p.setSeguro(rs.getString(9));
                lista.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //lista de HistorialMedico
    public List<historialmedico> lisHistM(String id){
        List<historialmedico> lista= new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
             String sql = "select idHisto,fechaCreacion,peso,talla,tipoSangre,presionArterial,diagnostico from historialmedico"
                     +" where idPaciente=?";
             PreparedStatement st = cn.prepareStatement(sql);
             st.setString(1, id);
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                historialmedico p = new historialmedico();
                p.setCodH(rs.getInt(1));
                p.setFechaC(rs.getString(2));
                p.setPeso((rs.getDouble(3)));
                p.setTalla((rs.getDouble(4)));
                p.setTipoSangre(rs.getString(5));
                p.setPresionAlte((rs.getDouble(6)));
                p.setDiagnostico(rs.getString(7));
                lista.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //lista de RecetaCabecera
    public List<receta> lisReceta(String id){
        List<receta> lista= new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
             String sql = "select c.idRecetaCabe,fechaRec,cantidad\n"
                    + "from recetacabe c join recetadeta n on c.idRecetaCabe=n.idRecetaCabe\n"
                    + "where idRecetaDeta=? ";
             PreparedStatement st = cn.prepareStatement(sql);
             st.setString(1, id);
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                receta p = new receta();
                p.setCodR(rs.getInt(1));
                p.setFechaR(rs.getString(2));
                p.setCantidad(rs.getInt(3));
                lista.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    //lista de Medico
    public List<medico> lisMedi(String id){
        List<medico> lista= new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
             String sql = "select c.idMedi,Dni,nombre,apellidos,genero,telefono,fechaNaci,direccion\n"
                    + "from medico c join recetadeta n on c.idMedi=n.idMedi\n"
                    + "where idRecetaDeta=? ";
             PreparedStatement st = cn.prepareStatement(sql);
             st.setString(1, id);
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                medico p = new medico();
                p.setCodM(rs.getInt(1));
                p.setDni(rs.getInt(2));
                p.setNomM(rs.getString(3));
                p.setApeM(rs.getString(4));
                p.setGeneroM(rs.getString(5));
                p.setTelefonoM(rs.getString(6));
                p.setFechaPM(rs.getString(7));
                p.setDireccionM(rs.getString(8));
                lista.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
}
