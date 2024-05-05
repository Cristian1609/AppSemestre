package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    String bd = "appsemestre";
    String url = "jdbc:mysql://localhost:3306/";
    String User = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Connection conectar() {
        try {
            cx = DriverManager.getConnection(url + bd, User, password);
            System.out.println("Si conecto a " + bd);
        } catch (SQLException ex) {
            System.out.println("No se conecto a " + bd);
            

        }
        return cx;
    }

    public void deconectar() {
        try {
            cx.close();
            System.out.println("Si desconecto a " + bd);

        } catch (SQLException ex) {
            System.out.println("Se desconecto de " + bd);
        }
    }
//    public static void main(String[] args) {
//        Conexion conexion = new Conexion("appsemestre");
//        conexion.conectar();
//    }
}
