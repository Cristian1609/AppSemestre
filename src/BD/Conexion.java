package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String bd = "appsemestre";
    String url = "jdbc:mysql://localhost:3306/";
    String User = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, User, password);
            System.out.println("Si conecto a " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return cx;
    }

    public void deconectar() {
        try {
            cx.close();
            System.out.println("Si desconecto a " + bd);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        Conexion conexion = new Conexion("appsemestre");
//        conexion.conectar();
//    }
}
