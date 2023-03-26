
package Controlador;


import Modelo.IngresoBodega;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class DaoIngresoBodega{
    private Connection cone;

    public DaoIngresoBodega() {
        cone = new Conexion().getCone();
    }
    public ArrayList<IngresoBodega> Listar(){
        try {
            String sql="SELECT * FROM VIAJE";
            PreparedStatement pstm=cone.prepareCall(sql);            
            ResultSet reg=pstm.executeQuery();
            ArrayList<IngresoBodega> listado=new ArrayList<>();            
            while (reg.next()) {                
                IngresoBodega viaj=new IngresoBodega();
                viaj.setId_viaje(reg.getInt("ID_VIAJE"));
                viaj.setProveedor(new DaoProveedor().Buscar2(reg.getInt("ID_CONDUCTOR")));
                viaj.setEmpleado(new DaoEmpleado().Buscar2(reg.getInt("ID_CLIENTE")));
                viaj.setProducto(new DaoProductos().Buscar2(reg.getInt("ID_VEHICULO")));
                viaj.setDireccionInicio(reg.getString("DIRECCION_INICIO"));
                viaj.setDireccionDestino(reg.getString("DIRECCION_DESTINO"));
                viaj.setIdaYVuelta(reg.getString("IDA_Y_VUELTA").equals("S"));
                viaj.setFechaDeIngreso(reg.getDate("FECHA_VIAJE"));
                listado.add(viaj);
            }
            return listado;
            
        } catch (Exception e) {
            System.out.println("Error Listar Viaje:"+e.getMessage());
            return null;
        }
    } 
    public IngresoBodega Buscar(String viaje) {
        try {
            String sql="SELECT * FROM VIAJE WHERE ID_VIAJE=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, viaje);
            ResultSet reg=pstm.executeQuery();
            IngresoBodega viaj=null;
            while (reg.next()) {                
                viaj=new IngresoBodega();
                viaj.setId_viaje(reg.getInt("ID_VIAJE"));
                viaj.setProveedor(new DaoProveedor().Buscar2(reg.getInt("ID_CONDUCTOR")));
                viaj.setEmpleado(new DaoEmpleado().Buscar2(reg.getInt("ID_CLIENTE")));
                viaj.setProducto(new DaoProductos().Buscar2(reg.getInt("ID_VEHICULO")));
                viaj.setDireccionInicio(reg.getString("DIRECCION_INICIO"));
                viaj.setDireccionDestino(reg.getString("DIRECCION_DESTINO"));
                viaj.setIdaYVuelta(reg.getString("IDA_Y_VUELTA").equals("S")?true:false);
                viaj.setFechaDeIngreso(reg.getDate("FECHA_VIAJE"));
            }
            return viaj;
        } catch (Exception e) {
            System.out.println("error buscar Viaje:"+e.getMessage());
            return null;
        }
    }
    public boolean Grabar(IngresoBodega viaje) {
        try {
            String sql = "insert into Viaje values(SEQ_VIAJE.NEXTVAL,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, viaje.getProveedor().getIdConductor());
            pstm.setInt(2, viaje.getEmpleado().getIdCliente());
            pstm.setInt(3, viaje.getProducto().getIdVehiculo());
            pstm.setString(4, viaje.getDireccionInicio());
            pstm.setString(5, viaje.getDireccionDestino());
            pstm.setString(6, viaje.isIdaYVuelta()? "S" : "N");
            java.sql.Date fecha = new java.sql.Date(viaje.getFechaDeIngreso().getTime());
            pstm.setDate(7, fecha);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar (Dao): " + e.getMessage());
            return false;
        }
    }
    public boolean Eliminar(int viaje) {
        try {
            String sql = "DELETE FROM VIAJE WHERE ID_VIAJE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, viaje);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }
    public IngresoBodega Buscar2(int idViaje) {
        try {
            String sql="SELECT * FROM VIAJE WHERE ID_VIAJE=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1, idViaje);
            ResultSet reg=pstm.executeQuery();
            IngresoBodega viaj=null;
            while (reg.next()) {                
                viaj=new IngresoBodega();
                viaj.setId_viaje(reg.getInt("ID_VIAJE"));
                viaj.setProveedor(new DaoProveedor().Buscar2(reg.getInt("ID_CONDUCTOR")));
                viaj.setEmpleado(new DaoEmpleado().Buscar2(reg.getInt("ID_CLIENTE")));
                viaj.setProducto(new DaoProductos().Buscar2(reg.getInt("ID_VEHICULO")));
                viaj.setDireccionInicio(reg.getString("DIRECCION_INICIO"));
                viaj.setDireccionDestino(reg.getString("DIRECCION_DESTINO"));
                viaj.setIdaYVuelta(reg.getString("IDA_Y_VUELTA").equals("S")?true:false);
                viaj.setFechaDeIngreso(reg.getDate("FECHA_VIAJE"));
            }
            return viaj;
        } catch (Exception e) {
            System.out.println("error buscar Viaje:"+e.getMessage());
            return null;
        }
    }
    public boolean modificar(IngresoBodega viaje){
        try {
            String sql="UPDATE VIAJE SET "
                    + "ID_CONDUCTOR=?,"
                    + "ID_CLIENTE=?,"
                    + "ID_VEHICULO=?,"
                    + "DIRECCION_INICIO=?,"
                    + "DIRECCION_DESTINO=?,"
                    + "IDA_Y_VUELTA=?,"
                    + "FECHA_VIAJE=?"
                    + "WHERE ID_VIAJE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, viaje.getProveedor().getIdConductor());
            pstm.setInt(2, viaje.getEmpleado().getIdCliente());
            pstm.setInt(3, viaje.getProducto().getIdVehiculo());
            pstm.setString(4, viaje.getDireccionInicio());
            pstm.setString(5, viaje.getDireccionDestino());
            pstm.setString(6, viaje.isIdaYVuelta()?"S":"N");
            java.sql.Date fecha = new java.sql.Date(viaje.getFechaDeIngreso().getTime());
            pstm.setDate(7, fecha);
            pstm.setInt(8, viaje.getId_viaje());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar Vehiculo:" + e.getMessage());
            return false;
        }
    
    }
    
}
