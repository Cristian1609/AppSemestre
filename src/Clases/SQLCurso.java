package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLCurso extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public boolean registrarCurso(CCurso curso, JTextField txtCodigo, JTextField txtNombre, JComboBox<String> comboAsignatura) {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String asignatura = (String) comboAsignatura.getSelectedItem();

        if (codigo.isEmpty() || nombre.isEmpty() || asignatura == null || asignatura.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }

        try {
            String numRegistros = "SELECT COUNT(*) FROM Curso WHERE codigo = ?";
            try (PreparedStatement temp = con.prepareStatement(numRegistros)) {
                temp.setString(1, codigo);
                ResultSet rs = temp.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "El código del curso ya está registrado.");
                    return false;
                }
            }

            String sql = "SELECT id FROM Asignatura WHERE nombre = ?";
            int idAsignatura;

            try (PreparedStatement checkAsignaturaStmt = con.prepareStatement(sql)) {
                checkAsignaturaStmt.setString(1, asignatura);
                ResultSet rs = checkAsignaturaStmt.executeQuery();
                if (rs.next()) {
                    idAsignatura = rs.getInt(1);
                } else {
                    JOptionPane.showMessageDialog(null, "La asignatura no existe. Elija una asignatura válida.");
                    return false;
                }
            }

            String sql2 = "INSERT INTO Curso (codigo, nombre, id_asignatura) "
                    + "VALUES (?, ?, ?)";

            try (PreparedStatement insertStmt = con.prepareStatement(sql2)) {
                insertStmt.setString(1, codigo);
                insertStmt.setString(2, nombre);
                insertStmt.setInt(3, idAsignatura);
                insertStmt.execute();

                curso.setCodigo(codigo);
                curso.setNombre(nombre);
                curso.setAsignatura(asignatura);

                JOptionPane.showMessageDialog(null, "Curso registrado con éxito.");
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el curso: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminarCurso(String codigoCurso) {
        String consultaVerificar = "SELECT COUNT(*) FROM Curso WHERE codigo = ?";
        String consultaEliminar = "DELETE FROM Curso WHERE codigo = ?";

        try {
            try (PreparedStatement psVerificar = con.prepareStatement(consultaVerificar)) {
                psVerificar.setString(1, codigoCurso);
                ResultSet rs = psVerificar.executeQuery();

                if (rs.next() && rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(null, "Curso no encontrado.");
                    return false;
                }
            }

            try (PreparedStatement psEliminar = con.prepareStatement(consultaEliminar)) {
                psEliminar.setString(1, codigoCurso);
                int filasEliminadas = psEliminar.executeUpdate();
                JOptionPane.showMessageDialog(null,"curso eliminado");
                return filasEliminadas > 0;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el curso: " + ex.getMessage());
            return false;
        }
    }

    public boolean Cargar(JTable jTable1, JTextField txtcodigo, JComboBox jComboBox1,JTextField txtnombre) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtcodigo.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
            txtnombre.setText(jTable1.getValueAt(filaSeleccionada, 2).toString());
            jComboBox1.setSelectedItem(jTable1.getValueAt(filaSeleccionada, 3).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public boolean Mostrar(JTable jTable1) {

        String sql = "SELECT c.id, c.codigo, c.nombre, a.nombre AS asignatura "
                + "FROM curso c "
                + "JOIN asignatura a ON c.id_asignatura = a.id";
        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("codigo");
        model.addColumn("nombre");
        model.addColumn("asignatura");
        jTable1.setModel(model);
        String[] datos = new String[4];

        try {
            java.sql.Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("codigo");
                datos[2] = rs.getString("nombre");
                datos[3] = rs.getString("asignatura");

                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
        return false;

    }
}
