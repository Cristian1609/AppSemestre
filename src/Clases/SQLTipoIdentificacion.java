package Clases;

import BD.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLTipoIdentificacion extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public boolean Registrar(JTextField txtTipoIdentificacion, CTipoIdentificacion identificacion) {

        try {

            String temp = txtTipoIdentificacion.getText();
            if (!temp.isEmpty()) {

                String nomTemp = "SELECT COUNT(*) FROM tipo_identificacion WHERE nombre = ?";

                PreparedStatement var = con.prepareStatement(nomTemp);

                var.setString(1, temp);
                ResultSet rs = var.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El tipo de identificación ya existe");
                    return false;
                }
                rs.close();
                var.close();

                String sql = "INSERT INTO Tipo_identificacion (nombre) VALUES (?)";

                if (!temp.isEmpty()) {
                    identificacion.setNombre(temp);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    txtTipoIdentificacion.setText(" ");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa el campo");
                }
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, identificacion.getNombre());
                    ps.execute();
                    return true;

                } catch (SQLException ex) {
                    Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Completa los campos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean modificarTipoIentificacion(int idTipoeps, JTextField txtTipoIdentificacion) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE Tipo_identificacion ti "
                + "SET "
                + "  ti.nombre = ? "
                + "WHERE ti.id = ?";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtTipoIdentificacion.getText());
            pstmt.setInt(2, idTipoeps);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar Tipo de identificación: " + e.getMessage());

        }

        return resultado;
    }

    public boolean Mostrar(JTable jTable1) {

        String sql = "SELECT * FROM `tipo_identificacion` ";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Tipo de Itentificación");
        jTable1.setModel(model);
        String[] datos = new String[2];

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombre");

                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return false;

    }

    public boolean Cargar(JTable tablaAsignaturas, JTextField txtTipoIdentificacion) {
        int filaSeleccionada = tablaAsignaturas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtTipoIdentificacion.setText(tablaAsignaturas.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public boolean Eliminar(JTextField txtTipoIdentificacion) {
        String nombre = txtTipoIdentificacion.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM tipo_identificacion WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de identificación eliminada");
                txtTipoIdentificacion.setText("");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el tipo de identificación con el nombre proporcionado.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            return false;
        }
    }
}
