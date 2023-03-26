
package Controlador;

import Modelo.Proveedor;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaoProveedor{
    private Connection cone;

    public DaoProveedor() {
        cone = new Conexion().getCone();
    }
    
    public ArrayList<Proveedor> ListarConductor(){
        try {
            String sql="select ID_CONDUCTOR,"
                    + "RUT_CONDUCTOR,"
                    + "NOMBRE_CONDUCTOR,"
                    + "DIRECCION_CONDUCTOR,"
                    + "EDAD_CONDUCTOR,"
                    + "GENERO_CONDUCTOR "
                    + "from CONDUCTOR";
            PreparedStatement pstm=cone.prepareCall(sql);            
            ResultSet reg=pstm.executeQuery();
            ArrayList<Proveedor> listado=new ArrayList<>();            
            while (reg.next()) {                
                Proveedor cond=new Proveedor();
                cond.setIdConductor(reg.getInt("ID_CONDUCTOR"));
                cond.setRut(reg.getString("RUT_CONDUCTOR"));
                cond.setNombre(reg.getString("NOMBRE_CONDUCTOR"));
                cond.setDireccion(reg.getString("DIRECCION_CONDUCTOR"));
                cond.setEdad(reg.getInt("EDAD_CONDUCTOR"));
                cond.setNacionalidad(reg.getString("GENERO_CONDUCTOR"));
                listado.add(cond);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar CONDUCTOR:"+e.getMessage());
            return null;
        }
    } 
    public Proveedor Buscar(String rut) {
        try {
            String sql="SELECT ID_CONDUCTOR,RUT_CONDUCTOR, NOMBRE_CONDUCTOR, DIRECCION_CONDUCTOR, EDAD_CONDUCTOR, GENERO_CONDUCTOR  FROM CONDUCTOR WHERE RUT_CONDUCTOR=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet reg=pstm.executeQuery();
            Proveedor cond=null;
            while (reg.next()) {                
                cond=new Proveedor();
                cond.setIdConductor(reg.getInt("ID_CONDUCTOR"));
                cond.setRut(reg.getString("RUT_CONDUCTOR"));
                cond.setNombre(reg.getString("NOMBRE_CONDUCTOR"));
                cond.setDireccion(reg.getString("DIRECCION_CONDUCTOR"));
                cond.setEdad(reg.getInt("EDAD_CONDUCTOR"));
                cond.setNacionalidad(reg.getString("GENERO_CONDUCTOR"));
            }
            return cond;
        } catch (Exception e) {
            System.out.println("error buscar CONDUCTOR:"+e.getMessage());
            return null;
        }
    }
    public boolean GrabarConductor(Proveedor conductor) {
        try {
            String sql = "INSERT INTO CONDUCTOR VALUES(SEQ_CONDUCTOR.NEXTVAL,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, conductor.getRut());
            pstm.setString(2, conductor.getNombre());
            pstm.setString(3, conductor.getDireccion());
            pstm.setInt(4, conductor.getEdad());
            pstm.setString(5, conductor.getNacionalidad());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    } 
    public boolean modificar(Proveedor conductor) {
        try {
            String sql = "update CONDUCTOR set "
                    +"RUT_CONDUCTOR=?,"
                    + "NOMBRE_CONDUCTOR=?, "
                    + "DIRECCION_CONDUCTOR=?, "
                    + "EDAD_CONDUCTOR=?, "
                    + "GENERO_CONDUCTOR=? "
                    + "where RUT_CONDUCTOR=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, conductor.getRut());
            pstm.setString(2, conductor.getNombre());
            pstm.setString(3, conductor.getDireccion());
            pstm.setInt(4, conductor.getEdad());
            pstm.setString(5, conductor.getNacionalidad());
            pstm.setString(6, conductor.getRut());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    } 
    public boolean Eliminar(String rut) {
        try {
            String sql = "DELETE FROM CONDUCTOR WHERE RUT_CONDUCTOR=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, rut);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }
    public Proveedor Buscar2(int IdConductor) {
        try {
            String sql="SELECT ID_CONDUCTOR,RUT_CONDUCTOR, NOMBRE_CONDUCTOR, DIRECCION_CONDUCTOR, EDAD_CONDUCTOR, GENERO_CONDUCTOR  FROM CONDUCTOR WHERE ID_CONDUCTOR=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, IdConductor);
            ResultSet reg=pstm.executeQuery();
            Proveedor cond=null;
            while (reg.next()) {                
                cond=new Proveedor();
                cond.setIdConductor(reg.getInt("ID_CONDUCTOR"));
                cond.setRut(reg.getString("RUT_CONDUCTOR"));
                cond.setNombre(reg.getString("NOMBRE_CONDUCTOR"));
                cond.setDireccion(reg.getString("DIRECCION_CONDUCTOR"));
                cond.setEdad(reg.getInt("EDAD_CONDUCTOR"));
                cond.setNacionalidad(reg.getString("GENERO_CONDUCTOR"));
            }
            return cond;
        } catch (Exception e) {
            System.out.println("error buscar CONDUCTOR:"+e.getMessage());
            return null;
        }
    }

}
