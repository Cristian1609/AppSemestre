package Clases;

import BD.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLRol extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public static boolean modificarRol(int idRol, JTextField txtTipoRol) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE Rol r "
                + "SET "
                + "  r.nombre = ? "
                + "WHERE r.id = ?";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtTipoRol.getText());
            pstmt.setInt(2, idRol);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar Rol: " + e.getMessage());

        }

        return resultado;
    }
    public boolean Registrar(JTextField txtTipoRol, CRol cr) {

        try {

            String temp = txtTipoRol.getText();

            if (!temp.isEmpty()) {

                String nomTemp = "SELECT COUNT(*) FROM rol  WHERE nombre = ?";

                PreparedStatement var = con.prepareStatement(nomTemp);

                var.setString(1, temp);
                ResultSet rs = var.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El tipo de rol ya existe");
                    return false;
                }
                rs.close();
                var.close();

                String sql = "INSERT INTO rol (nombre) VALUES (?)";

                if (!temp.isEmpty()) {
                    cr.setNombre(temp);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    txtTipoRol.setText(" ");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa el campo");
                }
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, cr.getNombre());
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

    public boolean Mostrar(JTable TablaRoles) {

        String sql = "SELECT * FROM `rol` ";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Tipo de Rol");
        TablaRoles.setModel(model);
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

    public boolean Eliminar(JTextField txtTipoRol) {
        String nombre = txtTipoRol.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM rol WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de Rol eliminado");
                txtTipoRol.setText("");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el tipo de rol con el nombre proporcionado.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    public boolean Cargar(JTable TablaRoles, JTextField txtTipoRol) {
        int filaSeleccionada = TablaRoles.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtTipoRol.setText(TablaRoles.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }
}
