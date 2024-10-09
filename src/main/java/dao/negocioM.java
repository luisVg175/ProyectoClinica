
package dao;
import java.sql.*;
import util.MySQLConexion;
import java.util.*;
import modelo.*;

public class negocioM {
    //Lista de especialidades
    
    public List<especialidad> lisEsp(){
        List<especialidad> lista= new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
             String sql = "select idEsp,nombreEsp from especialidad";
             PreparedStatement st = cn.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while (rs.next()) {
                especialidad p = new especialidad();
                p.setCodE(rs.getInt(1));
                p.setEspe(rs.getString(2));
                lista.add(p);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //Lista de Medicos
    
    public List<medico> lisMedico(String id) {
        List<medico> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select idMedi,Dni,nombre,apellidos,genero,telefono,fechaNaci,direccion from medico"
                    + " where idesp=?";
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
    
    //Lista de Horarios Medicos
    
    public List<horarioMedico> lisHoraiosMedi(String id) {
        List<horarioMedico> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select idHorario,dia,horaI,horaF from horariomedico"
                    + " where idMedi=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                horarioMedico p = new horarioMedico();
                p.setCodHoraM(rs.getInt(1));
                p.setDia(rs.getString(2));
                p.setHoraI(rs.getString(3));
                p.setHoraF(rs.getString(4));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
