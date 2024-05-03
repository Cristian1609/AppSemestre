package Clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;

public class SQLAdministrador extends BD.Conexion {

    public void ModificarDatos(JTextField txtNombre, JComboBox<String> comboTipoIdentificacion, JTextField txtNumeroIdentificacion,
            JTextField txtCorreoPersonal, JTextField txtTelefono, JComboBox<String> comboSexo, JComboBox<String> comboEPS, String codigoInstitucional) throws SQLException {

        Connection connection = conectar();

        String sql
                = "UPDATE Usuario "
                + "SET "
                + "   nombre_completo = ?, "
                + "   id_tipo_identificacion = (SELECT id FROM Tipo_identificacion WHERE nombre = ?), "
                + "   numero_identificacion = ?, "
                + "   correo_personal = ?, "
                + "   telefono = ?, "
                + "   id_sexo = (SELECT id FROM Sexo WHERE nombre = ?), "
                + "   id_eps = (SELECT id FROM Eps WHERE nombre = ?) "
                + "WHERE "
                + "   id = (SELECT id_usuario FROM Administrador WHERE codigo_institucional = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, txtNombre.getText());
            preparedStatement.setString(2, comboTipoIdentificacion.getSelectedItem().toString());
            preparedStatement.setString(3, txtNumeroIdentificacion.getText());
            preparedStatement.setString(4, txtCorreoPersonal.getText());
            preparedStatement.setString(5, txtTelefono.getText());
            preparedStatement.setString(6, comboSexo.getSelectedItem().toString());
            preparedStatement.setString(7, comboEPS.getSelectedItem().toString());
            preparedStatement.setString(8, codigoInstitucional);

            preparedStatement.executeUpdate();
        }
    }

    public boolean mostrarDatos(CAdministrador admin, String codigo, JLabel lblDato, JLabel lblNombre, JLabel lblTidentificacion,
            JLabel lblNidentificacion1, JLabel lblCorreo, JLabel lblTelefono, JLabel lblFnacimiento, JLabel lblSexo,
            JLabel lblEps, JLabel lblCodigoInstitucional, JLabel lblCorreoInstitucional, JLabel lblContraseña,
            JTextField txtNombre, JComboBox<String> comboIdentificacion, JTextField txtNumeroIdentificacion,
            JTextField txtCorreoPersonal, JTextField txtTelefono, JComboBox<String> comboSexo, JComboBox<String> ComboEps) {

        if (lblDato.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo");
            return false;
        }

        String sql = "SELECT "
                + "    u.nombre_completo, "
                + "    ti.nombre AS tipo_identificacion, "
                + "    u.numero_identificacion, "
                + "    u.correo_personal, "
                + "    u.telefono, "
                + "    DATE_FORMAT(u.fecha_nacimiento, '%Y-%m-%d') AS fecha_nacimiento, "
                + "    s.nombre AS sexo, "
                + "    e.nombre AS eps, "
                + "    a.codigo_institucional, "
                + "    a.correo_institucional, "
                + "    a.contraseña "
                + "FROM "
                + "    Administrador a "
                + "JOIN "
                + "    Usuario u ON a.id_usuario = u.id "
                + "JOIN "
                + "    Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "JOIN "
                + "    Sexo s ON u.id_sexo = s.id "
                + "JOIN "
                + "    Eps e ON u.id_eps = e.id "
                + "WHERE "
                + "    a.codigo_institucional = ?";

        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    admin.setNombre(rs.getString("nombre_completo"));
                    admin.setTidentificacion(rs.getString("tipo_identificacion"));
                    admin.setIdentificacion(rs.getString("numero_identificacion"));
                    admin.setCorreo(rs.getString("correo_personal"));
                    admin.setTelefono(rs.getString("telefono"));
                    admin.setNacimiento(rs.getDate("fecha_nacimiento"));
                    admin.setSexo(rs.getString("sexo"));
                    admin.setEps(rs.getString("eps"));
                    admin.setCodigo_institucinal(rs.getString("codigo_institucional"));
                    admin.setCorreo_institucional(rs.getString("correo_institucional"));
                    admin.setContraseña(rs.getString("contraseña"));

                    lblNombre.setText(admin.getNombre());
                    lblTidentificacion.setText(admin.getTidentificacion());
                    lblNidentificacion1.setText(admin.getIdentificacion());
                    lblCorreo.setText(admin.getCorreo());
                    lblTelefono.setText(admin.getTelefono());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    lblFnacimiento.setText(sdf.format(admin.getNacimiento()));

                    lblSexo.setText(admin.getSexo());
                    lblEps.setText(admin.getEps());
                    lblCodigoInstitucional.setText(admin.getCodigo_institucinal());
                    lblCorreoInstitucional.setText(admin.getCorreo_institucional());
                    lblContraseña.setText(admin.getContraseña());

                    txtNombre.setText(admin.getNombre());
                    comboIdentificacion.setSelectedItem(admin.getTidentificacion());
                    txtNumeroIdentificacion.setText(admin.getIdentificacion());
                    txtCorreoPersonal.setText(admin.getCorreo());
                    txtTelefono.setText(admin.getTelefono());
                    comboSexo.setSelectedItem(admin.getSexo());
                    ComboEps.setSelectedItem(admin.getEps());

                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + ex.getMessage());
        }

        return false;
    }

}
