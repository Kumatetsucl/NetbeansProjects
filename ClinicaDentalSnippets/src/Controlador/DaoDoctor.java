package controlador;

import Controlador.Conexion;
import Modelo.Doctor;
import Modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoDoctor {

    //crear un atributo de tipo conexion
    private Connection cone;

    //crear constructor sin parametros
    public DaoDoctor() {
        cone = new Conexion().getCone();
    }

    public boolean Grabar(Doctor doctor) {
        try {
            String sql = "insert into Doctor values(SEQ_DOCTOR.NEXTVAL,?,?,?,?,?,?)";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, doctor.getNombre());
            pstm.setInt(2, doctor.getNum_rut());
            pstm.setString(3, doctor.getDireccion());
            pstm.setInt(4, doctor.getCelular());
            pstm.setString(5, doctor.getEspecialidad());
            pstm.setInt(6, doctor.getSueldo());
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }

    public Doctor Buscar(int id_doctor) {
        try {
            String sql = "select * from Doctor where Id_doctor=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_doctor);
            ResultSet reg = pstm.executeQuery();
            Doctor doc = null;
            while (reg.next()) {
                doc = new Doctor();
                doc.setId_doctor(reg.getInt("ID_DOCTOR"));
                doc.setNum_rut(reg.getInt("NUM_RUT_DOCTOR"));
                doc.setNombre(reg.getString("NOMBRE_DOCTOR"));
                doc.setEspecialidad(reg.getString("ESPECIALIDAD_DOCTOR"));
                doc.setDireccion(reg.getString("DIRECCION_DOCTOR"));
                doc.setCelular(reg.getInt("CELULAR_DOCTOR"));
                doc.setSueldo(reg.getInt("SUELDO_DOCTOR"));
            }
            return doc;
        } catch (Exception e) {
            System.out.println("Error Buscar:" + e.getMessage());
            return null;
        }
    }

    public ArrayList<Doctor> Listar() {
        try {
            String sql = "select * from Doctor";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Doctor> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Doctor doc = new Doctor();
                doc.setId_doctor(reg.getInt("ID_DOCTOR"));
                doc.setNum_rut(reg.getInt("NUM_RUT_DOCTOR"));
                doc.setNombre(reg.getString("NOMBRE_DOCTOR"));
                doc.setEspecialidad(reg.getString("ESPECIALIDAD_DOCTOR"));
                doc.setDireccion(reg.getString("DIRECCION_DOCTOR"));
                doc.setCelular(reg.getInt("CELULAR_DOCTOR"));
                doc.setSueldo(reg.getInt("SUELDO_DOCTOR"));
                listado.add(doc);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }

    public boolean Eliminar(int id_doctor) {
        try {
            String sql = "delete from Doctor where id_doctor=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, id_doctor);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }
    
        public ArrayList<Especialidad> ListarEspecialidad() {
        try {
            String sql = "select * from Especialidad";
            PreparedStatement pstm = cone.prepareCall(sql);
            ArrayList<Especialidad> listado = new ArrayList<>();
            ResultSet reg = pstm.executeQuery();
            while (reg.next()) {
                Especialidad esp = new Especialidad();
                esp.setCodigo(reg.getInt("CODIGO_ESPECIALIDAD"));
                esp.setDescripcion(reg.getString("DESCRIPCION_ESPECIALIDAD"));
                listado.add(esp);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listar:" + e.getMessage());
            return null;
        }
    }

  
    public boolean Modificar(Doctor doctor){
        try {
            String sql="update doctor set "
                    + "NOMBRE_DOCTOR=?,"
                    + "NUM_RUT_DOCTOR=?"
                    + ",DIRECCION_DOCTOR=?,"
                    + "CELULAR_DOCTOR=?"
                    + ",ESPECIALIDAD_DOCTOR=?" 
                    +",SUELDO_DOCTOR=?"
                    +" where ID_DOCTOR=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1,  doctor.getNombre());
            pstm.setInt(2, doctor.getNum_rut());
            pstm.setString(3, doctor.getDireccion());
            pstm.setInt(4, doctor.getCelular());
            pstm.setString(5, doctor.getEspecialidad());
            pstm.setInt(6,doctor.getSueldo());
            pstm.setInt(7,doctor.getId_doctor());
            int afectadas = pstm.executeUpdate();
            return afectadas>0;
        } catch (Exception e) {
            System.out.println("Error Modificar:"+e.getMessage());
            return false;
        }
    }
}
