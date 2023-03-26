package Controlador;

import java.sql.*;


public class Conexion {

    private Connection cone;

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            cone = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                            "ClinicaSnippets", "ClinicaSnippets");

        } catch (Exception e) {
            System.out.println("Error Conexion:" + e.getMessage());
        }
    }

    //crear el getter al atributo
    public Connection getCone() {
        return cone;
    }
}
