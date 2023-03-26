package Controlador;

import Modelo.Jugador;
import java.sql.*;
import java.util.ArrayList;

public class DaoJugador {
    private Connection cone;

    public DaoJugador(){
        cone =new Conexion().getcone();
    
    }
    
    public boolean grabar(Jugador jugador){
        try {
            String sql = "INSERT INTO JUGADOR VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstm =cone.prepareCall(sql);
            pstm.setString(1, jugador.getRut());
            pstm.setString(2, jugador.getNombre());
            pstm.setInt(3, jugador.getNumeroCamiseta());
            pstm.setInt(4, jugador.getEdad());
            pstm.setString(5, jugador.getPosicion());
            pstm.setString(6,jugador.getCategoria());
            pstm.setString(7, jugador.isSexo()?"M":"F");
            int Afectadas =pstm.executeUpdate();
            return Afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Grabar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean Eliminar(String Rut){
        try {
            String sql = "delete from Jugador where RUT=?";
            PreparedStatement pstm =cone.prepareCall(sql);
            pstm.setString(1, Rut);
            int afectadas =pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error eliminar Jugador: "+e.getMessage());
            return false;
        }
    }
    
    public Jugador buscar(String Rut){
        try {
            String sql = "SELECT * FROM JUGADOR WHERE RUT=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, Rut);
            ResultSet reg = pstm.executeQuery();
            Jugador jugador =null;
            while(reg.next()){
                jugador = new Jugador();
                jugador.setRut(reg.getString("RUT"));
                jugador.setNombre(reg.getString("NOMBRE"));
                jugador.setNumeroCamiseta(reg.getInt("NUMERO_CAMISETA"));
                jugador.setEdad(reg.getInt("EDAD"));
                jugador.setPosicion(reg.getString("POSICION"));
                jugador.setCategoria(reg.getString("CATEGORIA"));
                jugador.setSexo(reg.getString("SEXO").equals("F")?true:false);
            }
            return jugador;    
        }catch (Exception e) {
                System.out.println("Error buscar: "+e.getMessage());
                return null;
        }
    }
    
    public ArrayList<Jugador> Listar(){
        try {
            String sql = "SELECT * FROM JUGADOR";
            PreparedStatement pstm=cone.prepareCall(sql);
            ResultSet reg = pstm.executeQuery();
            ArrayList<Jugador>lista= new ArrayList<>();
            while(reg.next()){
                Jugador jugador= new Jugador();
                jugador.setRut(reg.getString("RUT"));
                jugador.setNombre(reg.getString("NOMBRE"));
                jugador.setNumeroCamiseta(reg.getInt("NUMERO_CAMISETA"));
                jugador.setEdad(reg.getInt("EDAD"));
                jugador.setPosicion(reg.getString("POSICION"));
                jugador.setCategoria(reg.getString("CATEGORIA"));
                jugador.setSexo(reg.getString("SEXO").equals("M")?true:false);                
                lista.add(jugador);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("error listar: "+e.getMessage());
            return null;
        }
    }
    
    public boolean Modificar(Jugador jugador){
        try {
            String sql = "UPDATE JUGADOR SET NOMBRE=?,EDAD=?,POSICION=?,CATEGORIA=?,SEXO=? WHERE RUT=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, jugador.getNombre());
            pstm.setInt(2, jugador.getEdad());
            pstm.setString(3, jugador.getPosicion());
            pstm.setString(4, jugador.getCategoria());
            pstm.setString(5, jugador.isSexo()?"M":"F");
            pstm.setString(6,jugador.getRut());
            int afectadas =pstm.executeUpdate();
            return afectadas > 0;
        } catch (Exception e) {
            System.out.println("Error Modificar: "+e.getMessage());
            return false;
        }
        
    }
    
    public ArrayList<Jugador> Filtrar(String Posicion){
        try{
            String sql = "SELECT * FROM JUGADOR WHERE POSICION=?";
            PreparedStatement pstm=cone.prepareCall(sql);
            pstm.setString(1, Posicion);
            ResultSet reg = pstm.executeQuery();
            Jugador jugador =null;
            ArrayList<Jugador>lista= new ArrayList<>();
            while(reg.next()){
                jugador = new Jugador();
                jugador.setRut(reg.getString("RUT"));
                jugador.setNombre(reg.getString("NOMBRE"));
                jugador.setNumeroCamiseta(reg.getInt("NUMERO_CAMISETA"));
                jugador.setEdad(reg.getInt("EDAD"));
                jugador.setPosicion(reg.getString("POSICION"));
                jugador.setCategoria(reg.getString("CATEGORIA"));
                jugador.setSexo(reg.getString("SEXO").equals("F")?true:false);
                lista.add(jugador);
            }
            return lista;    
        }catch (Exception e) {
                System.out.println("Error buscar: "+e.getMessage());
                return null;
        
        
        
        }
    
    
    }
    
}
