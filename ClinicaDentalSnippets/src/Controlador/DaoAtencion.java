package controlador;

import Controlador.Conexion;
import Modelo.Atencion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class DaoAtencion {

    //crear un atributo de tipo conexion
    private Connection cone;

    //crear constructor sin parametros
    public DaoAtencion() {
        cone = new Conexion().getCone();
    }

    public ArrayList<Atencion> Listar() {
        try {
            String sql = "SELECT  * FROM ATENCION ate JOIN doctor DOC ON(ate.ID_DOCTOR = doc.ID_DOCTOR) JOIN PACIENTE PAC ON(ATE.ID_PACIENTE=PAC.ID_PACIENTE) JOIN ASISTENTE ASIS ON(ATE.id_asistente=ASIS.ID_ASISTENTE) JOIN SERVICIO SERV ON(ATE.ID_SERVICIO=SERV.iD_SERVICIO)" ;
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Atencion> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Atencion ate = new Atencion();
                ate.setId_atencion(reg.getInt("ID_ATENCION"));
                ate.setNombrePaciente(reg.getString("NOMBRE_PACIENTE"));
                ate.setNumRutPaciente(reg.getInt("NUM_RUT_PACIENTE"));
                ate.setDireccionPaciente(reg.getString("DIRECCION_PACIENTE"));
                ate.setPrevisionPaciente(reg.getString("PREVISION_PACIENTE"));
                ate.setNombreDoctor(reg.getString("NOMBRE_DOCTOR"));
                ate.setNumRutDoctor(reg.getInt("NUM_RUT_DOCTOR"));
                ate.setDescripcionServicio(reg.getString("DESCRIPCION_SERVICIO"));
                ate.setValorServicio(reg.getInt("VALOR_ATENCION"));
                ate.setIdDoctor(reg.getInt("ID_DOCTOR"));
                ate.setIdPaciente(reg.getInt("ID_PACIENTE"));
                ate.setIdAsistente(reg.getInt("ID_ASISTENTE"));
                ate.setIdServicio(reg.getInt("ID_SERVICIO"));
                ate.setNombreAsistente(reg.getString("NOMBRE_ASISTENTE"));
                ate.setRutAsistente(reg.getInt("NUM_RUT_ASISTENTE"));
                ate.setFechaAtencion(new java.util.Date(reg.getDate("FECHA_ATENCION").getTime()));
                listado.add(ate);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar: " + e.getMessage());
            return null;
        }
    }
    
    public Atencion Buscar(int id_atencion){
        try {
            String sql = "SELECT  * "
                    + "FROM ATENCION ate "
                    + "JOIN doctor DOC "
                    + "     ON(ate.ID_DOCTOR = doc.ID_DOCTOR) "
                    + "JOIN PACIENTE PAC "
                    + "     ON(ATE.ID_PACIENTE=PAC.ID_PACIENTE) "
                    + "JOIN ASISTENTE ASIS "
                    + "     ON(ATE.id_asistente=ASIS.ID_ASISTENTE) "
                    + "JOIN SERVICIO SERV "
                    + "     ON(ATE.ID_SERVICIO=SERV.iD_SERVICIO) "
                    + "where ID_atencion=?" ;
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_atencion);
            ResultSet reg = pstm.executeQuery();
            Atencion ate = null;
            while(reg.next()){
                ate = new Atencion();
                ate.setId_atencion(reg.getInt("ID_ATENCION"));
                ate.setNombrePaciente(reg.getString("NOMBRE_PACIENTE"));
                ate.setDireccionPaciente(reg.getString("DIRECCION_PACIENTE"));
                ate.setPrevisionPaciente(reg.getString("PREVISION_PACIENTE"));
                ate.setNombreDoctor(reg.getString("NOMBRE_DOCTOR"));
                ate.setNumRutDoctor(reg.getInt("NUM_RUT_DOCTOR"));
                ate.setDescripcionServicio(reg.getString("DESCRIPCION_SERVICIO"));
                ate.setValorServicio(reg.getInt("VALOR_ATENCION"));
                ate.setNumRutPaciente(reg.getInt("NUM_RUT_PACIENTE"));
                ate.setIdAsistente(reg.getInt("ID_ASISTENTE"));
                ate.setIdDoctor(reg.getInt("ID_DOCTOR"));
                ate.setIdPaciente(reg.getInt("ID_PACIENTE"));
                ate.setIdServicio(reg.getInt("ID_SERVICIO"));
                ate.setNombreAsistente(reg.getString("NOMBRE_ASISTENTE"));
                ate.setRutAsistente(reg.getInt("NUM_RUT_ASISTENTE"));
                ate.setFechaAtencion(new java.util.Date(reg.getDate("FECHA_ATENCION").getTime()));
            }
            return ate;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
    }
 
    public boolean Grabar(Atencion atencion) {
        try {
            String sql = "insert into atencion values(SEQ_ATENCION.NEXTVAL,?,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, atencion.getIdDoctor());
            pstm.setInt(2, atencion.getIdPaciente());
            pstm.setInt(3, atencion.getIdAsistente());
            pstm.setInt(4, atencion.getIdServicio());
            pstm.setInt(5, atencion.getValorServicio());
            java.sql.Date fecha=new java.sql.Date(atencion.getFechaAtencion().getTime());
            pstm.setDate(6, fecha);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }    
    
    public boolean Eliminar(int id_atencion) {
        try {
            String sql = "delete from Atencion where ID_ATENCION=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_atencion);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }
    
    public boolean Modificar(Atencion atencion){
        try {
            String sql="update ATENCION set ID_DOCTOR=?,ID_PACIENTE=?"
                    + ",ID_ASISTENTE=?,ID_SERVICIO=?,VALOR_ATENCION=?"
                    +" ,FECHA_ATENCION=? where ID_ATENCION=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setInt(1,  atencion.getIdDoctor());
            pstm.setInt(2, atencion.getIdPaciente());
            pstm.setInt(3, atencion.getIdAsistente());
            pstm.setInt(4, atencion.getIdServicio());
            pstm.setInt(5,atencion.getValorServicio());
            java.sql.Date fecha=new java.sql.Date(atencion.getFechaAtencion().getTime());
            pstm.setDate(6, fecha);
            pstm.setInt(7,atencion.getId_atencion());
            int afectadas = pstm.executeUpdate();
            return afectadas>0;
        } catch (Exception e) {
            System.out.println("Error Modificar:"+e.getMessage());
            return false;
        }
    }

    public Atencion BuscarServicio(int id_servicio){
        try {
            String sql = "SELECT  * FROM SERVICIO where ID_SERVICIO=?" ;
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_servicio);
            ResultSet reg = pstm.executeQuery();
            Atencion ate = null;
            while(reg.next()){
                ate = new Atencion();
                ate.setIdServicio(reg.getInt("ID_SERVICIO"));
                ate.setDescripcionServicio(reg.getString("DESCRIPCION_SERVICIO"));
            }
            return ate;
        } catch (Exception e) {
            System.out.println("Error Buscar Servicio:" + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Atencion> ListarServicio() {
        try {
            String sql = "SELECT * FROM SERVICIO" ;
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Atencion> listado = new ArrayList<>();
            ResultSet regserv = pstm.executeQuery();
            while (regserv.next()) {
                Atencion serv = new Atencion();
                serv.setIdServicio(regserv.getInt("ID_SERVICIO"));
                serv.setDescripcionServicio(regserv.getString("DESCRIPCION_SERVICIO"));
                listado.add(serv);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar Servicio: " + e.getMessage());
            return null;
        }
    }

}


