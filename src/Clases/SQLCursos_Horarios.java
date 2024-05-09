package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLCursos_Horarios extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public boolean Registrar(JComboBox comboDocente, JComboBox comboCurso, JFormattedTextField jFormattedInicio,
            JFormattedTextField jFormattedFin, JComboBox comboDia) {

        String sql = "INSERT INTO HorarioCurso (id_curso, id_docente, dia, Hora_Inicio, Hora_Fin) VALUES ("
                + "(SELECT id FROM Curso WHERE codigo = ?), "
                + "(SELECT id FROM Docente WHERE codigo_institucional = ?), "
                + "?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            String codigoCurso = comboCurso.getSelectedItem().toString();
            String codigoDocente = comboDocente.getSelectedItem().toString();

            String dia = comboDia.getSelectedItem().toString();
            String horaInicio = jFormattedInicio.getText();
            String horaFin = jFormattedFin.getText();

            LocalTime i = LocalTime.parse(horaInicio.trim());
            LocalTime f = LocalTime.parse(horaFin.trim());

            if (i.equals(f)) {
                JOptionPane.showMessageDialog(null, "Las horas de inicio y fin no pueden ser iguales");
                return false;
            } else if (i.isAfter(f)) {
                JOptionPane.showMessageDialog(null, "La hora de inicio no puede superar la de fin");
                return false;
            }
            pstmt.setString(1, codigoCurso);
            pstmt.setString(2, codigoDocente);
            pstmt.setString(3, dia);
            pstmt.setString(4, horaInicio);
            pstmt.setString(5, horaFin);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horario registrado");
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);

            return false;
        }
    }

    public boolean editarHorarioCurso(int id, JComboBox comboCurso, JComboBox comboDocente,
            JFormattedTextField jFormattedInicio, JFormattedTextField jFormattedFin,
            JComboBox comboDia) {

        String sql = "UPDATE HorarioCurso SET id_curso = (SELECT id FROM Curso WHERE codigo = ?), "
                + "id_docente = (SELECT id FROM Docente WHERE codigo_institucional = ?), "
                + "dia = ?, Hora_Inicio = ?, Hora_Fin = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            String codigoCurso = comboCurso.getSelectedItem().toString();
            String codigoDocente = comboDocente.getSelectedItem().toString();

            String dia = comboDia.getSelectedItem().toString();
            String horaInicio = jFormattedInicio.getText();
            String horaFin = jFormattedFin.getText();

            LocalTime i = LocalTime.parse(horaInicio.trim());
            LocalTime f = LocalTime.parse(horaFin.trim());

            if (i.equals(f)) {
                JOptionPane.showMessageDialog(null, "Las horas de inicio y fin no pueden ser iguales");
                return false;
            } else if (i.isAfter(f)) {
                JOptionPane.showMessageDialog(null, "La hora de inicio no puede superar la de fin");
                return false;
            }

            pstmt.setString(1, codigoCurso);
            pstmt.setString(2, codigoDocente);
            pstmt.setString(3, dia);
            pstmt.setString(4, horaInicio);
            pstmt.setString(5, horaFin);
            pstmt.setInt(6, id);

            pstmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el horario: " + e.toString());
            return false;
        }
    }

    public boolean Mostrar(JTable jTable1) {
        String sql = "SELECT hc.id, c.codigo AS codigo_curso, c.nombre AS nombre_curso, "
                + "u.nombre_completo AS nombre_docente, d.codigo_institucional, hc.dia, hc.Hora_Inicio, hc.Hora_Fin "
                + "FROM HorarioCurso hc "
                + "JOIN Curso c ON hc.id_curso = c.id "
                + "JOIN Docente d ON hc.id_docente = d.id "
                + "JOIN Usuario u ON d.id_usuario = u.id";

        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Nombre Docente");
        model.addColumn("Codigo Docente");
        model.addColumn("Dia");
        model.addColumn("Hora Inicio");
        model.addColumn("Hora Fin");

        jTable1.setModel(model);

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] datos = new String[8];
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("codigo_curso");
                datos[2] = rs.getString("nombre_curso");
                datos[3] = rs.getString("nombre_docente");
                datos[4] = rs.getString("codigo_institucional");
                datos[5] = rs.getString("dia");
                datos[6] = rs.getString("Hora_Inicio");
                datos[7] = rs.getString("Hora_Fin");

                model.addRow(datos);
            }

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + e.toString());
            return false;
        }
    }

    public boolean cargarDatos(JTable jTable, JComboBox comboCurso, JComboBox comboDocente,
            JComboBox<String> comboDia, JFormattedTextField jFormattedInicio, JFormattedTextField jFormattedFin) {
        int filaSeleccionada = jTable.getSelectedRow();

        if (filaSeleccionada >= 0) {
            comboCurso.setSelectedItem(jTable.getValueAt(filaSeleccionada, 1).toString());
            comboDocente.setSelectedItem(jTable.getValueAt(filaSeleccionada, 4).toString());
            comboDia.setSelectedItem(jTable.getValueAt(filaSeleccionada, 5).toString());

            String horaInicio = jTable.getValueAt(filaSeleccionada, 6).toString().trim();
            String horaFin = jTable.getValueAt(filaSeleccionada, 7).toString().trim();

            jFormattedInicio.setText(horaInicio);
            jFormattedFin.setText(horaFin);

            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos.");
            return false;
        }
    }
}
