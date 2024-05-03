package Clases;

import BD.Conexion;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLEps extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public boolean RegistrarEps(JTextField txtEPS, CEps eps) {

        try {

            String temp = txtEPS.getText();
            if (!temp.isEmpty()) {

                String nomTemp = "SELECT COUNT(*) FROM eps WHERE nombre = ?";

                PreparedStatement var = con.prepareStatement(nomTemp);

                var.setString(1, temp);
                ResultSet rs = var.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El tipo de eps ya existe");
                    return false;
                }

                String sql = "INSERT INTO eps (nombre) VALUES (?)";

                if (!temp.isEmpty()) {
                    eps.setNombre(temp);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    txtEPS.setText(" ");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa el campo");
                }
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, eps.getNombre());
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

    public boolean Eliminar(JTextField txtEPS) {
        String nombre = txtEPS.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM eps WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int ejecutar = ps.executeUpdate();

            if (ejecutar > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de identificación eliminada");
                txtEPS.setText("");
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

    public boolean Cargar(JTable jTable1, JTextField txtEPS) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtEPS.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public static boolean modificarEps(int idEps, JTextField txtEPS) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE eps e "
                + "SET "
                + "  e.nombre = ? "
                + "WHERE e.id = ?";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtEPS.getText());
            pstmt.setInt(2, idEps);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar EPS: " + e.getMessage());

        }

        return resultado;
    }

    public boolean Mostrar(JTable jTable1) {

        String sql = "SELECT * FROM `eps` ";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Tipo de EPS");
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
}
