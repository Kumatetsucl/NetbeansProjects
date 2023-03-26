
package Controlador;

import Enumeradores.EnumPrevision;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaoPaciente {
   
    private Connection cone;

    public DaoPaciente() {
        cone = new Conexion().getCone();
    }

    public boolean Grabar(Paciente paciente) {
        try {
            String sql = "insert into paciente values(SEQ_PACIENTE.NEXTVAL,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, paciente.getNombre());
            pstm.setInt(2, paciente.getNum_rut());
            pstm.setString(3, paciente.getDireccion());
            pstm.setInt(4, paciente.getCelular());
            pstm.setString(5, paciente.getPrevision().toString());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }
    
    public Paciente Buscar(int id_paciente) {
        try {
            String sql = "select * from Paciente where ID_Paciente=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_paciente);
            ResultSet reg = pstm.executeQuery();
            Paciente pac = null;
            while (reg.next()) {
                pac = new Paciente();
                pac.setId_paciente(reg.getInt("ID_PACIENTE"));
                pac.setNombre(reg.getString("NOMBRE_PACIENTE"));
                pac.setNum_rut(reg.getInt("NUM_RUT_PACIENTE"));
                pac.setDireccion(reg.getString("DIRECCION_PACIENTE"));
                pac.setCelular(reg.getInt("CELULAR_PACIENTE"));
                String prevision= reg.getString("PREVISION_PACIENTE");
                switch (prevision) {
                    case "ISAPRE":
                        pac.setPrevision(EnumPrevision.ISAPRE);
                        break;
                    case "FONASA":
                        pac.setPrevision(EnumPrevision.FONASA);
                        break;
                    default:
                        pac.setPrevision(EnumPrevision.PARTICULAR);
                }
            }
            return pac;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
        
        
    }
    
    public Paciente BuscarRut(int num_rut) {
        try {
            String sql = "select * from Paciente where NUM_RUT_PACIENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, num_rut);
            ResultSet reg = pstm.executeQuery();
            Paciente pac = null;
            while (reg.next()) {
                pac = new Paciente();
                pac.setId_paciente(reg.getInt("ID_PACIENTE"));
                pac.setNombre(reg.getString("NOMBRE_PACIENTE"));
                pac.setNum_rut(reg.getInt("NUM_RUT_PACIENTE"));
                pac.setDireccion(reg.getString("DIRECCION_PACIENTE"));
                pac.setCelular(reg.getInt("CELULAR_PACIENTE"));
                String prevision= reg.getString("PREVISION_PACIENTE");
                switch (prevision) {
                    case "ISAPRE":
                        pac.setPrevision(EnumPrevision.ISAPRE);
                        break;
                    case "FONASA":
                        pac.setPrevision(EnumPrevision.FONASA);
                        break;
                    default:
                        pac.setPrevision(EnumPrevision.PARTICULAR);
                }
            }
            return pac;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
    }
  
    public ArrayList<Paciente> Listar() {
        try {
            String sql = "select * from Paciente";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Paciente> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Paciente pac = new Paciente();
                pac.setId_paciente(reg.getInt("ID_PACIENTE"));
                pac.setNombre(reg.getString("NOMBRE_PACIENTE"));
                pac.setNum_rut(reg.getInt("NUM_RUT_PACIENTE"));
                pac.setDireccion(reg.getString("DIRECCION_PACIENTE"));
                pac.setCelular(reg.getInt("CELULAR_PACIENTE"));
                String prevision= reg.getString("PREVISION_PACIENTE");
                switch (prevision) {
                    case "ISAPRE":
                        pac.setPrevision(EnumPrevision.ISAPRE);
                        break;
                    case "FONASA":
                        pac.setPrevision(EnumPrevision.FONASA);
                        break;
                    default:
                        pac.setPrevision(EnumPrevision.PARTICULAR);
                }
                listado.add(pac);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }

    public boolean Eliminar(int id_Paciente) {
        try {
            String sql = "delete from Paciente where ID_Paciente=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_Paciente);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }

    public boolean Modificar(Paciente paciente){
        try {
            String sql="update Paciente set NOMBRE_PACIENTE=?,NUM_RUT_PACIENTE=?"
                    + ",DIRECCION_PACIENTE=?,CELULAR_PACIENTE=?"
                    +",PREVISION_PACIENTE=?"
                    +" where ID_PACIENTE=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1,  paciente.getNombre());
            pstm.setInt(2, paciente.getNum_rut());
            pstm.setString(3, paciente.getDireccion());
            pstm.setInt(4, paciente.getCelular());
            pstm.setString(5,paciente.getPrevision().toString());
            pstm.setInt(6,paciente.getId_paciente());
            int afectadas = pstm.executeUpdate();
            return afectadas>0;
        } catch (Exception e) {
            System.out.println("Error Modificar:"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Paciente> ListarPrevisionPaciente() {
        try {
            String sql = "select * from pacioente";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Paciente> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Paciente pac = new Paciente();
                pac.setId_paciente(reg.getInt("ID_PACIENTE"));
                pac.setNombre(reg.getString("NOMBRE_PACIENTE"));
                pac.setNum_rut(reg.getInt("NUM_RUT_PACIENTE"));
                pac.setDireccion(reg.getString("DIRECCION_PACIENTE"));
                pac.setCelular(reg.getInt("CELULAR_PACIENTE"));
                String prevision= reg.getString("PREVISION_PACIENTE");
                switch (prevision) {
                    case "ISAPRE":
                        pac.setPrevision(EnumPrevision.ISAPRE);
                        break;
                    case "FONASA":
                        pac.setPrevision(EnumPrevision.FONASA);
                        break;
                    default:
                        pac.setPrevision(EnumPrevision.PARTICULAR);
                }
                listado.add(pac);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }
    
    public Paciente BuscarIdPaciente(int IdPaciente) {
        try {
            String sql = "select * from Paciente where ID_PACIENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, IdPaciente);
            ResultSet reg = pstm.executeQuery();
            Paciente pac = null;
            while (reg.next()) {
                pac = new Paciente();
                pac.setId_paciente(reg.getInt("ID_PACIENTE"));
                pac.setNombre(reg.getString("NOMBRE_PACIENTE"));
                pac.setNum_rut(reg.getInt("NUM_RUT_PACIENTE"));
                pac.setDireccion(reg.getString("DIRECCION_PACIENTE"));
                pac.setCelular(reg.getInt("CELULAR_PACIENTE"));
                String prevision= reg.getString("PREVISION_PACIENTE");
                switch (prevision) {
                    case "ISAPRE":
                        pac.setPrevision(EnumPrevision.ISAPRE);
                        break;
                    case "FONASA":
                        pac.setPrevision(EnumPrevision.FONASA);
                        break;
                    default:
                        pac.setPrevision(EnumPrevision.PARTICULAR);
                }
            }
            return pac;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
    }
    
}
