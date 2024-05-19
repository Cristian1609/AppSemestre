package PStrategy;

import javax.swing.JTable;
import java.sql.*;
import BD.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class concreteStrategyDocente implements IStrategy {

    @Override
    public void mostrarHorarioClases(int idDocente, JTable tablaHorario) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dia");
        modelo.addColumn("Hora Inicio");
        modelo.addColumn("Hora Fin");

        String sql = "SELECT hc.id, c.codigo, c.nombre, hc.dia, hc.Hora_Inicio, hc.Hora_Fin "
                + "FROM HorarioCurso hc "
                + "JOIN Curso c ON hc.id_curso = c.id "
                + "JOIN Docente d ON hc.id_docente = d.id "
                + "WHERE d.codigo_institucional = ?";

        Conexion conexionBD = new Conexion();
        try (Connection conexion = conexionBD.conectar(); PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idDocente);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("hc.id");
                String codigo = rs.getString("c.codigo");
                String nombre = rs.getString("c.nombre");
                String dia = rs.getString("hc.dia");
                Time horaInicio = rs.getTime("hc.Hora_Inicio");
                Time horaFin = rs.getTime("hc.Hora_Fin");
                modelo.addRow(new Object[]{id, codigo, nombre, dia, horaInicio, horaFin});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        tablaHorario.setModel(modelo);
    }
}
