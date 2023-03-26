
package Controlador;

import Modelo.Asistente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaoAsistente {
    private Connection cone;

    public DaoAsistente() {
        cone = new Conexion().getCone();
    }

    public boolean Grabar(Asistente asistente) {
        try {
            String sql = "insert into asistente values(SEQ_ASISTENTE.NEXTVAL,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, asistente.getNombre());
            pstm.setInt(2, asistente.getNum_rut());
            pstm.setString(3, asistente.getDireccion());
            pstm.setInt(4, asistente.getCelular());
            pstm.setInt(5, asistente.getSueldo());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }
    
    public Asistente Buscar(int id_asistente) {
        try {
            String sql = "select * from asistente where ID_ASISTENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_asistente);
            ResultSet reg = pstm.executeQuery();
            Asistente asis = null;
            while (reg.next()) {
                asis = new Asistente();
                asis.setIdAsistente(reg.getInt("ID_ASISTENTE"));
                asis.setNombre(reg.getString("NOMBRE_ASISTENTE"));
                asis.setNum_rut(reg.getInt("NUM_RUT_ASISTENTE"));
                asis.setDireccion(reg.getString("DIRECCION_ASISTENTE"));
                asis.setCelular(reg.getInt("CELULAR_ASISTENTE"));
                asis.setSueldo(reg.getInt("SUELDO_ASISTENTE"));
            }
            return asis;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Asistente> Listar() {
        try {
            String sql = "select * from Asistente";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Asistente> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Asistente asis = new Asistente();
                asis.setIdAsistente(reg.getInt("ID_ASISTENTE"));
                asis.setNombre(reg.getString("NOMBRE_ASISTENTE"));
                asis.setNum_rut(reg.getInt("NUM_RUT_ASISTENTE"));
                asis.setDireccion(reg.getString("DIRECCION_ASISTENTE"));
                asis.setCelular(reg.getInt("CELULAR_ASISTENTE"));
                asis.setSueldo(reg.getInt("SUELDO_ASISTENTE"));
                listado.add(asis);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }

    public boolean Eliminar(int id_Asistente) {
        try {
            String sql = "delete from asistente where ID_ASISTENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_Asistente);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }

    public boolean Modificar(Asistente asistente){
        try {
            String sql="update asistente set NOMBRE_ASISTENTE=?,NUM_RUT_ASISTENTE=?"
                    + ",DIRECCION_ASISTENTE=?,CELULAR_ASISTENTE=?"
                    +",SUELDO_ASISTENTE=?"
                    +" where ID_ASISTENTE=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1,  asistente.getNombre());
            pstm.setInt(2, asistente.getNum_rut());
            pstm.setString(3, asistente.getDireccion());
            pstm.setInt(4, asistente.getCelular());
            pstm.setInt(5,asistente.getSueldo());
            pstm.setInt(6,asistente.getIdAsistente());
            int afectadas = pstm.executeUpdate();
            return afectadas>0;
        } catch (Exception e) {
            System.out.println("Error Modificar:"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Asistente> ListarNombreAsistente() {
        try {
            String sql = "select * from asistente";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Asistente> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Asistente asis = new Asistente();
                asis.setIdAsistente(reg.getInt("ID_ASISTENTE"));
                asis.setNombre(reg.getString("NOMBRE_ASISTENTE"));
                asis.setNum_rut(reg.getInt("NUM_RUT_ASISTENTE"));
                asis.setDireccion(reg.getString("DIRECCION_ASISTENTE"));
                asis.setCelular(reg.getInt("CELULAR_ASISTENTE"));
                asis.setSueldo(reg.getInt("SUELDO_ASISTENTE"));
                listado.add(asis);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }
    
}
