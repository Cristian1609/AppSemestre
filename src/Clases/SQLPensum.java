package Clases;

import BD.Conexion;
import java.sql.Connection;
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

public class SQLPensum extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public static boolean modificarPensum(int idPensum, JTextField txtcodigo,JComboBox jComboBox1) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql
                = "UPDATE pensum "
                + "SET nombre = ? "
                + "WHERE id = ?; "
                + "SELECT p.codigo, prog.id AS programa_id "
                + "FROM pensum p "
                + "JOIN programa prog ON p.id_programa = prog.id "
                + "WHERE p.id = ?; ";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtcodigo.getText());
             pstmt.setString(2,jComboBox1.getSelectedItem().toString());
            pstmt.setInt(3, idPensum);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar Pensum: " + e.getMessage());

        }

        return resultado;
    }

    public boolean RegistrarPensum(CPensum cp) {

        String sql = "INSERT INTO pensum (codigo, id_programa)\n"
                + "VALUES (?, (SELECT id FROM Programa WHERE nombre = ?));";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cp.getCodigo());
            ps.setString(2, cp.getPrograma());

            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean Cargar(JTable jTable1, JTextField txtcodigo, JComboBox jComboBox1) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtcodigo.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
            jComboBox1.setSelectedItem(jTable1.getValueAt(filaSeleccionada, 2).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public boolean Eliminar(JTextField txtcodigo, JComboBox jComboBox1) {
        String nombre = txtcodigo.getText();
        String programa = (String) jComboBox1.getSelectedItem();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM pensum WHERE codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int ejecutar = ps.executeUpdate();

            if (ejecutar > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de identificación eliminada");
                txtcodigo.setText("");
                jComboBox1.setSelectedItem(0);
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

    public boolean Mostrar(JTable jTable1) {
        String sql = "SELECT p.id, p.codigo, pr.nombre as programa FROM pensum p "
                + "JOIN programa pr ON p.id_programa = pr.id";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id");
        model.addColumn("Codigo");
        model.addColumn("Programa");
        jTable1.setModel(model);

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("codigo");
                datos[2] = rs.getString("programa");

                model.addRow(datos);
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false; 
        }
    }
}
