package Clases;

import BD.Conexion;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLAlumnoMatricula extends BD.Conexion {

    Connection con = (Connection) conectar();
    PreparedStatement ps = null;

    public boolean Mostrar(JTable jTable) {
        String sql = """
                     SELECT 
                         hc.id AS horario_id,
                         c.codigo AS curso_codigo,
                         c.nombre AS curso_nombre,
                         a.numero_creditos AS asignatura_creditos,
                         hc.dia,
                         hc.Hora_Inicio,
                         hc.Hora_Fin,
                         u.nombre_completo AS docente_nombre
                     FROM 
                         HorarioCurso hc
                         JOIN Curso c ON hc.id_curso = c.id
                         JOIN Asignatura a ON c.id_asignatura = a.id
                         JOIN Docente d ON hc.id_docente = d.id
                         JOIN Usuario u ON d.id_usuario = u.id
                         WHERE a.nivel = 1;
                     """;

        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Codigo Curso");
        model.addColumn("Nombre Curso");
        model.addColumn("Creditos");
        model.addColumn("Dia");
        model.addColumn("Hora Inicio");
        model.addColumn("Hora Fin");
        model.addColumn("Docente");

        jTable.setModel(model);

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] datos = new String[8];
                datos[0] = rs.getString("horario_id");
                datos[1] = rs.getString("curso_codigo");
                datos[2] = rs.getString("curso_nombre");
                datos[3] = rs.getString("asignatura_creditos");
                datos[4] = rs.getString("dia");
                datos[5] = rs.getString("Hora_Inicio");
                datos[6] = rs.getString("Hora_Fin");
                datos[7] = rs.getString("docente_nombre");

                model.addRow(datos);
            }

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        }
    }

    public boolean cargarDatos(JTable jTable, JLabel lblCodigo, JLabel lblNombre,
            JLabel lblNcreditos, JLabel lblDia, JLabel lblInicioo,
            JLabel lblIfin, JLabel lblDocente) {
        int filaSeleccionada = jTable.getSelectedRow();

        if (filaSeleccionada >= 0) {
            lblCodigo.setText(jTable.getValueAt(filaSeleccionada, 1).toString());
            lblNombre.setText(jTable.getValueAt(filaSeleccionada, 2).toString());
            lblNcreditos.setText(jTable.getValueAt(filaSeleccionada, 3).toString());
            lblDia.setText(jTable.getValueAt(filaSeleccionada, 4).toString());
            lblInicioo.setText(jTable.getValueAt(filaSeleccionada, 5).toString());
            lblIfin.setText(jTable.getValueAt(filaSeleccionada, 6).toString());
            lblDocente.setText(jTable.getValueAt(filaSeleccionada, 7).toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos.");
            return false;
        }
    }

    public boolean cursoExiste(int idAlumno, int idHorarioCurso) {
        String sql = "SELECT * FROM matricula_Alumno WHERE id_alumno = ? AND id_horarioCurso = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idAlumno);
            pstmt.setInt(2, idHorarioCurso);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return true;
        }
    }

    public boolean registrar(String codigoInstitucional, int idHorarioCurso, int idCurso) {

        String id = "SELECT id FROM Alumno WHERE codigo_institucional = ?";
        int idAlumno = -1;

        try {
            PreparedStatement pstmt = con.prepareStatement(id);
            pstmt.setString(1, codigoInstitucional);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idAlumno = rs.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el alumno con código: " + codigoInstitucional);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del alumno: " + e.toString());
            return false;
        }

        if (cursoExiste(idAlumno, idCurso)) {
            JOptionPane.showMessageDialog(null, "Ya se encuentra registrado aqui.");
            return false;
        }

        if (idAlumno != -1) {
            String sqlInsertar = "INSERT INTO matricula_Alumno (id_alumno, id_horarioCurso) VALUES (?, ?)";

            try {
                PreparedStatement pstmt = con.prepareStatement(sqlInsertar);
                pstmt.setInt(1, idAlumno);
                pstmt.setInt(2, idHorarioCurso);

                pstmt.executeUpdate();
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar la matrícula: " + e.toString());
                return false;
            }
        } else {
            return false;
        }
    }

}
