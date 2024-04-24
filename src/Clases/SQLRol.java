
package Clases;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author usuario
 */
public class SQLRol extends BD.Conexion{
     public boolean RegistrarRol(Rol rol) {

        PreparedStatement ps = null;
        Connection con = conectar();
        String sql = "INSERT INTO Rol (nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

   
}
