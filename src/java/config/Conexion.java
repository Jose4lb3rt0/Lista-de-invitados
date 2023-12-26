package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conexion = null;

    String base = "lista_de_invitados"; //Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"; //Direccion, puerto y nombre de la Base de Datos
    //?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false
    String user = "root"; //Usuario de Acceso a MySQL
    String password = "admin"; //Password del usuario

    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión Exitosa");
            return conexion;
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
