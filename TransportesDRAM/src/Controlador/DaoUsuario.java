package Controlador;

import Modelo.Usuario;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoUsuario {

    private Connection cone;

    public DaoUsuario() {
        cone = new Conexion().getCone();
    }

    public ArrayList<Usuario> Listar() {
        try {
            String sql = "select ID_CLIENTE,"
                    + "RUT_CLIENTE,"
                    + "NOMBRE_CLIENTE,"
                    + "DIRECCION_CLIENTE,"
                    + "EDAD_CLIENTE,"
                    + "GENERO_CLIENTE "
                    + "from CLIENTE";
            PreparedStatement pstm = cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Usuario> listado = new ArrayList<>();
            while (reg.next()) {
                Usuario pers = new Usuario();
                pers.setIdCliente(reg.getInt("ID_CLIENTE"));
                pers.setRut(reg.getString("RUT_CLIENTE"));
                pers.setNombre(reg.getString("NOMBRE_CLIENTE"));
                pers.setDireccion(reg.getString("DIRECCION_CLIENTE"));
                pers.setEdad(reg.getInt("EDAD_CLIENTE"));
                pers.setGenero(reg.getString("GENERO_CLIENTE"));
                listado.add(pers);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error listar cliente:" + e.getMessage());
            return null;
        }
    }

    public Usuario Buscar(String rut) {
        try {
            String sql = "SELECT ID_CLIENTE,RUT_CLIENTE, NOMBRE_CLIENTE, DIRECCION_CLIENTE, EDAD_CLIENTE, GENERO_CLIENTE  FROM CLIENTE WHERE RUT_CLIENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet reg = pstm.executeQuery();
            Usuario pers = null;
            while (reg.next()) {
                pers = new Usuario();
                pers.setIdCliente(reg.getInt("ID_CLIENTE"));
                pers.setRut(reg.getString("RUT_CLIENTE"));
                pers.setNombre(reg.getString("NOMBRE_CLIENTE"));
                pers.setDireccion(reg.getString("DIRECCION_CLIENTE"));
                pers.setEdad(reg.getInt("EDAD_CLIENTE"));
                pers.setGenero(reg.getString("GENERO_CLIENTE"));
            }
            return pers;
        } catch (Exception e) {
            System.out.println("error buscar cliente:" + e.getMessage());
            return null;
        }
    }

    public boolean Grabar(Usuario usuario) {
        try {
            if (VerificaExistente(usuario.getRut(), usuario.getIdCliente())) {
                JOptionPane.showMessageDialog(null, "Existe Usuario :" + usuario.getRut());
                return false;
            } else {
                String sql = "INSERT INTO CLIENTE VALUES(SEQ_CLIENTE.NEXTVAL,?,?,?,?,?)";
                PreparedStatement pstm = cone.prepareCall(sql);
                pstm.setString(1, usuario.getRut());
                pstm.setString(2, usuario.getNombre());
                pstm.setString(3, usuario.getDireccion());
                pstm.setInt(4, usuario.getEdad());
                pstm.setString(5, usuario.getGenero());
                int afectadas = pstm.executeUpdate();
                return afectadas > 0;
            }

        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }

    public boolean modificar(Usuario usuario) {
        try {
            if (VerificaExistente(usuario.getRut(), usuario.getIdCliente())) {
                JOptionPane.showMessageDialog(null, "Existe Usuario :" + usuario.getRut());
                return false;
            } else {
                String sql = "update CLIENTE set "
                        + "RUT_CLIENTE=?,"
                        + "NOMBRE_CLIENTE=?, "
                        + "DIRECCION_CLIENTE=?, "
                        + "EDAD_CLIENTE=?, "
                        + "GENERO_CLIENTE=? "
                        + "where ID_CLIENTE=?";
                PreparedStatement pstm = cone.prepareCall(sql);
                pstm.setString(1, usuario.getRut());
                pstm.setString(2, usuario.getNombre());
                pstm.setString(3, usuario.getDireccion());
                pstm.setInt(4, usuario.getEdad());
                pstm.setString(5, usuario.getGenero());
                pstm.setInt(6, usuario.getIdCliente());
                int afectadas = pstm.executeUpdate();
                return afectadas > 0;
            }
        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            return false;
        }
    }

    public boolean Eliminar(String rut) {
        try {
            String sql = "DELETE FROM CLIENTE WHERE RUT_CLIENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setString(1, rut);
            int afectadas = pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("error eliminar:" + e.getMessage());
            return false;
        }
    }

    public Usuario Buscar2(int idcliente) {
        try {
            String sql = "SELECT ID_CLIENTE,RUT_CLIENTE, NOMBRE_CLIENTE, DIRECCION_CLIENTE, EDAD_CLIENTE, GENERO_CLIENTE  FROM CLIENTE WHERE ID_CLIENTE=?";
            PreparedStatement pstm = cone.prepareCall(sql);
            pstm.setInt(1, idcliente);
            ResultSet reg = pstm.executeQuery();
            Usuario pers = null;
            while (reg.next()) {
                pers = new Usuario();
                pers.setIdCliente(reg.getInt("ID_CLIENTE"));
                pers.setRut(reg.getString("RUT_CLIENTE"));
                pers.setNombre(reg.getString("NOMBRE_CLIENTE"));
                pers.setDireccion(reg.getString("DIRECCION_CLIENTE"));
                pers.setEdad(reg.getInt("EDAD_CLIENTE"));
                pers.setGenero(reg.getString("GENERO_CLIENTE"));
            }
            return pers;
        } catch (Exception e) {
            System.out.println("error buscar cliente:" + e.getMessage());
            return null;
        }
    }

    private boolean VerificaExistente(String rut, int idCliente) {
        try {
            PreparedStatement pstm;
            String sql = "";

            if (rut != null && !rut.isEmpty() && !rut.trim().isEmpty()) {
                sql = "SELECT count(*) as contador FROM CLIENTE WHERE RUT_CLIENTE=?";
                pstm = cone.prepareCall(sql);
                pstm.setString(1, rut);
            } else {
                sql = "SELECT count(*) as contador FROM CLIENTE WHERE ID_CLIENTE=?";
                pstm = cone.prepareCall(sql);
                pstm.setInt(1, idCliente);
            }
            ResultSet reg = pstm.executeQuery();
            int contador = 0;
            while (reg.next()) {
                contador = reg.getInt("contador");
            }
            if (contador == 0) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            System.out.println("error VerificaExistente (Dao):" + e.getMessage());
            return false;
        }

    }

}
