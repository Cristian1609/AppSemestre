package Clases;

import BD.Conexion;
import vistasAdministrador.AdminGeneral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vistasAlumno.AlumnoGeneral;

public class SQLIniciarSesion extends BD.Conexion {

    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    private JFrame VistaIniciarSesion;

    public SQLIniciarSesion(JFrame VistaIniciarSesion) {
        this.VistaIniciarSesion = VistaIniciarSesion;
    }

    public void Ingresar(JTextField txtUsuario, JPasswordField txtContraseña, JComboBox jComboBox1) throws SQLException {
//
//        txtUsuario.setText("02210132001");
//        txtContraseña.setText("02210132001@123");
////        txtUsuario.setText("02210132011");
////        txtContraseña.setText("02210132011@123");
        String usuario = txtUsuario.getText();
        String contra = txtContraseña.getText();
        String rolSeleccionado = jComboBox1.getSelectedItem().toString();
        String sql = "";

        if (!usuario.isEmpty() || !contra.isEmpty()) {
            if ("Administrador".equals(rolSeleccionado)) {
                sql = "SELECT a.codigo_institucional, a.contraseña,a.correo_institucional FROM Administrador a WHERE a.codigo_institucional = ? ";
            } else if ("Docente".equals(rolSeleccionado)) {
                sql = "SELECT d.codigo_institucional, d.contraseña FROM Docente d WHERE d.codigo_institucional = ?";
            } else if ("Alumno".equals(rolSeleccionado)) {
                sql = "SELECT al.codigo_institucional, al.contraseña FROM Alumno al WHERE al.codigo_institucional = ?";
            }
            try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String codigoInstitucional = rs.getString("codigo_institucional");
                    String password = rs.getString("contraseña");

                    if (contra.equals(password)) {

                        switch (rolSeleccionado) {
                            case "Administrador":
                                vistasAdministrador.AdminGeneral admin = new AdminGeneral();
                                admin.setVisible(true);
                                admin.setDato(codigoInstitucional);

                                break;
                            case "Docente":

                                break;
                            case "Alumno":
                                vistasAlumno.AlumnoGeneral alumno = new AlumnoGeneral();
                                alumno.setVisible(true);
                                alumno.setDato(codigoInstitucional);
                                break;
                        }
                        VistaIniciarSesion.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Completa todos los campos.");
        }
    }
}
