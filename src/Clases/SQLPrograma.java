package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLPrograma extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public void mostrar(JTable jTable1) {
        String sql = "SELECT * FROM `programa`";

        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Descripción");

        jTable1.setModel(model);
        String[] datos = new String[4];

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("codigo");
                datos[2] = rs.getString("nombre");
                datos[3] = rs.getString("descripcion");

                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
    }

    public void Registrar(JTextField txtcodigo, JTextField txtNombre, JTextArea jTextAreaDescripcion, CPrograma cp) {
        String codigo = txtcodigo.getText();
        String nombre = txtNombre.getText();
        String descripcion = jTextAreaDescripcion.getText();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty()) {
            String codTemp = "SELECT COUNT(*) FROM programa WHERE codigo = ?";
            try {
                PreparedStatement temp = con.prepareStatement(codTemp);
                temp.setString(1, codigo);
                ResultSet rs = temp.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El código ya está registrado, elija otro.");
                    return;
                }
                rs.close();
                temp.close();

                String sql = "INSERT INTO `programa`(`codigo`, `nombre`, `descripcion`) VALUES (?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, codigo);
                ps.setString(2, nombre);
                ps.setString(3, descripcion);
                ps.execute();

                cp.setCodigo(codigo);
                cp.setNombre(nombre);
                cp.setDescripcion(descripcion);

                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                txtcodigo.setText("");
                txtNombre.setText("");
                jTextAreaDescripcion.setText(" ");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar: " + ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos");
        }
        return;
    }

    public static boolean modificarPrograma(int idPrograma, JTextField txtcodigo, JTextField txtNombre, JTextArea jTextAreaDescripcion) throws SQLException {
    Connection conn = new Conexion().conectar();

    String sql = "UPDATE programa "
               + "SET "
               + "codigo = ?, "
               + "nombre = ?, "
               + "descripcion = ? "
               + "WHERE id = ?";

    boolean resultado = false;

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, txtcodigo.getText());
        pstmt.setString(2, txtNombre.getText());
        pstmt.setString(3, jTextAreaDescripcion.getText());
        pstmt.setInt(4, idPrograma);

        int filasActualizadas = pstmt.executeUpdate();
        resultado = (filasActualizadas > 0);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al modificar Programa: " + e.getMessage());
    }

    return resultado;
}


    public void eliminar(JTextField txtcodigo, JTextField txtNombre, JTextArea jTextAreaDescripcion) {

        String codigo = txtcodigo.getText();

        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete el espacio");
            return;
        }

        try {
            String sql = "DELETE FROM `programa` WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Programa eliminada");

                txtcodigo.setText("");
                txtNombre.setText("");
                jTextAreaDescripcion.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun Programa con el código proporcionado.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
        }
    }

    public void cargarDatos(JTable jTable1, JTextField txtcodigo, JTextField txtNombre, JTextArea jTextAreaDescripcion) {

        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtcodigo.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
            txtNombre.setText(jTable1.getValueAt(filaSeleccionada, 2).toString());
            jTextAreaDescripcion.setText(jTable1.getValueAt(filaSeleccionada, 3).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
    }
}
