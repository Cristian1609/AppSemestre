package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import Vistas.VistaSexo;
import javax.swing.table.DefaultTableModel;

public class SQLSexo extends BD.Conexion {

    Connection con = conectar();

    public boolean RegistrarSexo(Sexo sexo) {

        PreparedStatement ps = null;

        String sql = "INSERT INTO Sexo (nombre) VALUES (?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sexo.getNombre());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
