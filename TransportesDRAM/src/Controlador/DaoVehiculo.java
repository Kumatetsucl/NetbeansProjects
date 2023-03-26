
package Controlador;

import Interfaces.IDaoVehiculo;
import Modelo.Persona;
import Modelo.Vehiculo;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaoVehiculo implements IDaoVehiculo{
    private Connection cone;

    public DaoVehiculo() {
        cone = new Conexion().getCone();
    }
    
    public ArrayList<Vehiculo> Listar(){
        try {
            String sql="select ID_VEHICULO,"
                    + "CHASIS_VEHICULO,"
                    + "PATENTE_VEHICULO,"
                    + "ANO_FABRICACION_VEHICULO,"
                    + "MARCA_VEHICULO,"
                    + "MODELO_VEHICULO "
                    + "from VEHICULO";
            PreparedStatement pstm=cone.prepareCall(sql);            
            ResultSet reg=pstm.executeQuery();
            ArrayList<Vehiculo> listado=new ArrayList<>();            
            while (reg.next()) {                
                Vehiculo vehi=new Vehiculo();
                vehi.setIdVehiculo(reg.getInt("ID_VEHICULO"));
                vehi.setChasisVehiculo(reg.getString("CHASIS_VEHICULO"));
                vehi.setPatenteVehiculo(reg.getString("PATENTE_VEHICULO"));
                vehi.setAnoFabricacion(reg.getInt("ANO_FABRICACION_VEHICULO"));
                vehi.setMarcaVehiculo(reg.getString("MARCA_VEHICULO"));
                vehi.setModeloVehiculo(reg.getString("MODELO_VEHICULO"));
                listado.add(vehi);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar cliente:"+e.getMessage());
            return null;
        }
    } 


    public Vehiculo Buscar(String Chasis) {
        try {
            String sql="select ID_VEHICULO,CHASIS_VEHICULO, PATENTE_VEHICULO, ANO_FABRICACION_VEHICULO, MARCA_VEHICULO, MODELO_VEHICULO FROM VEHICULO WHERE CHASIS_VEHICULO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, Chasis);
            ResultSet reg=pstm.executeQuery();
            Vehiculo vehi=null;
            while (reg.next()) {                
                vehi=new Vehiculo();
                vehi.setIdVehiculo(reg.getInt("ID_VEHICULO"));
                vehi.setChasisVehiculo(reg.getString("CHASIS_VEHICULO"));
                vehi.setPatenteVehiculo(reg.getString("PATENTE_VEHICULO"));
                vehi.setAnoFabricacion(reg.getInt("ANO_FABRICACION_VEHICULO"));
                vehi.setMarcaVehiculo(reg.getString("MARCA_VEHICULO"));
                vehi.setModeloVehiculo(reg.getString("MODELO_VEHICULO"));
            }
            return vehi;
        } catch (Exception e) {
            System.out.println("error buscar Vehiculo:"+e.getMessage());
            return null;
        }
    }

    public boolean Grabar(Vehiculo vehiculo) {
        try {
            String sql = "INSERT INTO VEHICULO VALUES(SEQ_VEHICULO.NEXTVAL,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, vehiculo.getChasisVehiculo());
            pstm.setString(2, vehiculo.getPatenteVehiculo());
            pstm.setInt(3, vehiculo.getAnoFabricacion());
            pstm.setString(4, vehiculo.getMarcaVehiculo());
            pstm.setString(5, vehiculo.getModeloVehiculo());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    } 

    public boolean modificar(Vehiculo vehiculo) {
        try {
            String sql="UPDATE VEHICULO SET CHASIS_VEHICULO=?,"
                    + "PATENTE_VEHICULO=?,"
                    + "ANO_FABRICACION_VEHICULO=?,"
                    + "MARCA_VEHICULO=?,"
                    + "MODELO_VEHICULO=?"
                    + "WHERE CHASIS_VEHICULO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, vehiculo.getChasisVehiculo());
            pstm.setString(2, vehiculo.getPatenteVehiculo());
            pstm.setInt(3, vehiculo.getAnoFabricacion());
            pstm.setString(4, vehiculo.getMarcaVehiculo());
            pstm.setString(5, vehiculo.getModeloVehiculo());
            pstm.setString(6, vehiculo.getChasisVehiculo());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar Vehiculo:" + e.getMessage());
            return false;
        }
    } 


    public boolean Eliminar(String chasis) {
        try {
            String sql = "DELETE FROM VEHICULO WHERE CHASIS_VEHICULO=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, chasis);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }

    public Vehiculo Buscar2(int IdVehiculo) {
        try {
            String sql="select ID_VEHICULO,CHASIS_VEHICULO, PATENTE_VEHICULO, ANO_FABRICACION_VEHICULO, MARCA_VEHICULO, MODELO_VEHICULO FROM VEHICULO WHERE ID_VEHICULO=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, IdVehiculo);
            ResultSet reg=pstm.executeQuery();
            Vehiculo vehi=null;
            while (reg.next()) {                
                vehi=new Vehiculo();
                vehi.setIdVehiculo(reg.getInt("ID_VEHICULO"));
                vehi.setChasisVehiculo(reg.getString("CHASIS_VEHICULO"));
                vehi.setPatenteVehiculo(reg.getString("PATENTE_VEHICULO"));
                vehi.setAnoFabricacion(reg.getInt("ANO_FABRICACION_VEHICULO"));
                vehi.setMarcaVehiculo(reg.getString("MARCA_VEHICULO"));
                vehi.setModeloVehiculo(reg.getString("MODELO_VEHICULO"));
            }
            return vehi;
        } catch (Exception e) {
            System.out.println("error buscar Vehiculo:"+e.getMessage());
            return null;
        }
    }

}
