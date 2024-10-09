
package dao;
import InterCrud.medicinaDao;
import java.util.*;
import modelo.medicina;
import util.MySQLConexion;
import java.sql.*;

public class CrudMedi implements medicinaDao{

    @Override
    public void Adicion(medicina a) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call spadiMedi(?,?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1, a.getCodP()); 
            st.setString(2, a.getNomP());
            st.setString(3, a.getCant());
            st.setDouble(4, a.getPrecio());
            st.setInt(5, a.getStock());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void Modifica(medicina a) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update medicina set nomMedicina=?,cantidadMedi=?,precio=?,stock=? where idMedicina=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, a.getNomP()); 
            st.setString(2, a.getCant());
            st.setDouble(3, a.getPrecio());
            st.setInt(4, a.getStock());
            st.setInt(5, a.getCodP());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void Anula(String cod) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "delete from medicina where idMedicina=?";
            PreparedStatement st = cn.prepareStatement(sql);
         
            st.setString(1,cod);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public medicina Busca(String cod) {
        medicina p = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "Select idMedicina, nomMedicina,cantidadMedi,precio,stock from medicina where idMedicina=? ";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new medicina();
                p.setCodP(rs.getInt(1));
                p.setNomP(rs.getString(2));
                p.setCant(rs.getString(3));
                p.setPrecio((rs.getDouble(4)));
                p.setStock(rs.getInt(5));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;

    }

    @Override
    public List<medicina> lisMedi() {
    List<medicina> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select idMedicina, nomMedicina, cantidadMedi,precio,stock from medicina";
            //? =equivale a un parametro 
            PreparedStatement st = conn.prepareStatement(sql);
            //relacionar el ? con su variable 
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                medicina a = new medicina();
                a.setCodP(rs.getInt(1));
                a.setNomP(rs.getString(2));
                a.setCant(rs.getString(3));
                a.setPrecio((rs.getDouble(4)));
                a.setStock(rs.getInt(5));
                lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
    
}
