package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLTipoIdentificacion extends BD.Conexion {

    public boolean RegistrarTIdentificacion(TipoIdentificacion Ti) {

        PreparedStatement ps = null;
        Connection con = conectar();

        String sql = "INSERT INTO Tipo_identificacion (nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Ti.getNombre());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
