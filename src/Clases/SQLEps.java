package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLEps extends BD.Conexion {

    public boolean RegistrarEps(EPS eps) {

        PreparedStatement ps = null;
        Connection con = conectar();

        String sql = "INSERT INTO Eps (nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, eps.getNombre());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
