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

public class SQLSexo extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

     public static boolean modificarSexo(int idSexo, JTextField txtSexo) throws SQLException {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE sexo s "
                + "SET "
                + "  s.nombre = ? "
                + "WHERE s.id = ?";

        boolean resultado = false;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtSexo.getText());
            pstmt.setInt(2, idSexo);

            int filasActualizadas = pstmt.executeUpdate();
            resultado = (filasActualizadas > 0);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al modificar Sexo: " + e.getMessage());

        }

        return resultado;
    }
    public boolean Registrar(JTextField txtSexo, CSexo cs) {

        try {

            String temp = txtSexo.getText();
            if (!temp.isEmpty()) {

                String nomTemp = "SELECT COUNT(*) FROM sexo WHERE nombre = ?";

                PreparedStatement var = con.prepareStatement(nomTemp);

                var.setString(1, temp);
                ResultSet rs = var.executeQuery();
                if (rs.next()&& rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El tipo de sexo ya existe");
                    return false;
                }
                rs.close();
                var.close();

                String sql = "INSERT INTO sexo (nombre) VALUES (?)";

                if (!temp.isEmpty()) {
                    cs.setNombre(temp);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    txtSexo.setText(" ");
                } else {
                    JOptionPane.showMessageDialog(null, "Completa el campo");
                }
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, cs.getNombre());
                    ps.execute();
                    return true;

                } catch (SQLException ex) {
                    Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            }else{
                 JOptionPane.showMessageDialog(null,"Completa los campos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLTipoIdentificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean Mostrar(JTable TablaSexo) {

        String sql = "SELECT * FROM `sexo` ";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Tipo de Sexo");
        TablaSexo.setModel(model);
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

    public boolean Eliminar(JTextField txtSexo) {
        String nombre = txtSexo.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el espacio");
            return false;
        }

        try {
            String sql = "DELETE FROM sexo WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de sexo eliminada");
                txtSexo.setText("");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el tipo de sexo con el nombre proporcionado.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    public boolean Cargar(JTable jTable1, JTextField txtSexo) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtSexo.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }
}
