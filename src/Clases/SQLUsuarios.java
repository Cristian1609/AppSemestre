package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLUsuarios extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public boolean mostrarDatos(String codigoInstitucional, JLabel lblDato, JLabel lblNombre, JLabel lblTipoIdentificacion,
            JLabel lblNumeroIdentificacion, JLabel lblCorreo, JLabel lblTelefono, JLabel lblFechaNacimiento,
            JLabel lblSexo, JLabel lblEps, JLabel lblCodigoInstitucional, JLabel lblCorreoInstitucional,
            JLabel lblContraseña, JTextField txtNombre, JComboBox<String> comboTipoIdentificacion,
            JTextField txtNumeroIdentificacion, JTextField txtCorreoPersonal, JTextField txtTelefono,
            JComboBox<String> comboSexo, JComboBox<String> comboEps, String usuario) {

        if (codigoInstitucional.equals("")) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar tus datos.");
            return false;
        }

        String sql = "SELECT "
                + "u.nombre_completo, "
                + "ti.nombre AS tipo_identificacion, "
                + "u.numero_identificacion, "
                + "u.correo_personal, "
                + "u.telefono, "
                + "u.fecha_nacimiento, "
                + "s.nombre AS sexo, "
                + "e.nombre AS eps, "
                + "a.codigo_institucional, "
                + "a.correo_institucional, "
                + "a.contraseña "
                + "FROM " + usuario + " a "
                + "JOIN Usuario u ON a.id_usuario = u.id "
                + "JOIN Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "JOIN Sexo s ON u.id_sexo = s.id "
                + "JOIN Eps e ON u.id_eps = e.id "
                + "WHERE a.codigo_institucional = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, codigoInstitucional);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    lblNombre.setText(rs.getString("nombre_completo"));
                    lblTipoIdentificacion.setText(rs.getString("tipo_identificacion"));
                    lblNumeroIdentificacion.setText(rs.getString("numero_identificacion"));
                    lblCorreo.setText(rs.getString("correo_personal"));
                    lblTelefono.setText(rs.getString("telefono"));

                    Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                    if (fechaNacimiento != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        lblFechaNacimiento.setText(sdf.format(fechaNacimiento));
                    }

                    lblSexo.setText(rs.getString("sexo"));
                    lblEps.setText(rs.getString("eps"));
                    lblCodigoInstitucional.setText(rs.getString("codigo_institucional"));
                    lblCorreoInstitucional.setText(rs.getString("correo_institucional"));
                    lblContraseña.setText(rs.getString("contraseña"));

                    txtNombre.setText(rs.getString("nombre_completo"));
                    comboTipoIdentificacion.setSelectedItem(rs.getString("tipo_identificacion"));
                    txtNumeroIdentificacion.setText(rs.getString("numero_identificacion"));
                    txtCorreoPersonal.setText(rs.getString("correo_personal"));
                    txtTelefono.setText(rs.getString("telefono"));
                    comboSexo.setSelectedItem(rs.getString("sexo"));
                    comboEps.setSelectedItem(rs.getString("eps"));

                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el código institucional: " + codigoInstitucional);
                    return false;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + ex.toString());
            return false;
        }
    }

    public void ModificarDatos(JTextField txtNombre, JComboBox<String> comboTipoIdentificacion, JTextField txtNumeroIdentificacion,
            JTextField txtCorreoPersonal, JTextField txtTelefono, JComboBox<String> comboSexo, JComboBox<String> comboEPS, String codigoInstitucional, String usuario) throws SQLException {

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
                + "   id = (SELECT id_usuario FROM " + usuario + " WHERE codigo_institucional =? )";
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

    public boolean mostrarAlumnos(JTable jTable, String codigoCurso) {
        String sql = """
                     SELECT 
                         m.id AS matricula_id,
                         u.nombre_completo AS alumno_nombre,
                         u.correo_personal AS alumno_correo
                     FROM 
                         matricula_Alumno m
                         JOIN HorarioCurso hc ON m.id_horarioCurso = hc.id
                         JOIN Curso c ON hc.id_curso = c.id
                         JOIN Usuario u ON m.id_alumno = u.id
                     WHERE 
                         c.codigo = ?;
                     """;

        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID Matricula");
        model.addColumn("Nombre Alumno");
        model.addColumn("Correo Alumno");

        jTable.setModel(model);

        try (PreparedStatement pstmt = cox.prepareStatement(sql)) {
            pstmt.setString(1, codigoCurso);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String[] datos = new String[3];
                    datos[0] = rs.getString("matricula_id");
                    datos[1] = rs.getString("alumno_nombre");
                    datos[2] = rs.getString("alumno_correo");

                    model.addRow(datos);
                }

                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
