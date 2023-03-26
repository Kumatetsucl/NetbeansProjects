

package Controlador;
import java.sql.*;

public class Conexion {
    private Connection cone;


    public Conexion(){
        try { 
            Class.forName("oracle.jdbc.OracleDriver");
            cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","PRUEBA3","PRUEBA3");            
        } catch (Exception e) {
            System.out.println("error Conexion: "+e.getMessage());
        }
    }
    public Connection getcone(){
        return cone;
    }
    
    
}