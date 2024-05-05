package Clases;

import java.sql.*;


public class SQLUsuarios extends BD.Conexion {

    public boolean RegistrarUsuario(ClaseUsuario usuario) {
        PreparedStatement ps = null;
        Connection con = conectar();

        String sql = "INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sql);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

}
