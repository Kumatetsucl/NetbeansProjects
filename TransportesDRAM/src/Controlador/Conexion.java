package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    //atributo de conexion
    private Connection cone;
    //crear constructor sin parametros

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cone = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                            "TransportesDram", "TransportesDram");
        } catch (Exception e) {
            System.out.println("Error Conexion:" + e.getMessage());
        }
    }

    //crear el getter al atributo
    public Connection getCone() {
         return cone;
    }
}
