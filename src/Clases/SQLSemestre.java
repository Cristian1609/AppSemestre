package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLSemestre extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

     public static boolean modificarEps(int idSemestre, JTextField txtAño) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE semestre e "
                + "SET "
                + "  e.semestre = ? "
                + "WHERE e.id = ?";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtAño.getText());
            pstmt.setInt(2, idSemestre);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar EPS: " + e.getMessage());

        }

        return resultado;
    }
    public boolean Registrar(JTextField txtAño, CSemestre cs) {

        try {

            String temp = txtAño.getText();
            if (!temp.isEmpty()) {

                String nomTemp = "SELECT COUNT(*) FROM semestre  WHERE semestre = ?";

                PreparedStatement var = con.prepareStatement(nomTemp);

                var.setString(1, temp);
                ResultSet rs = var.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El Semestre ya existe");
                    return false;
                }
                rs.close();
                var.close();

                String sql = "INSERT INTO semestre (semestre) VALUES (?)";

                if (!temp.isEmpty()) {
                    cs.setAnio(temp);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    txtAño.setText(" ");
                }

                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, cs.getAnio());
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

    public boolean Cargar(JTable jTable1, JTextField txtAño) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtAño.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public boolean Eliminar(JTextField txtAño) {
        String nombre = txtAño.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM semestre WHERE semestre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int ejecutar = ps.executeUpdate();

            if (ejecutar > 0) {
                JOptionPane.showMessageDialog(null, "Semestre  eliminado");
                txtAño.setText("");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el semestre academico");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    public boolean Mostrar(JTable jTable1) {

        String sql = "SELECT * FROM `semestre`  ";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
         model.addColumn("id");
        model.addColumn("Semestre");
        jTable1.setModel(model);
        String[] datos = new String[2];

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("semestre");

                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return false;

    }
}
