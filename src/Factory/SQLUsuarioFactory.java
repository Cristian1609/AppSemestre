package Factory;

import BD.Conexion;
import Clases.CConcretaAlumno;
import Clases.CConcretaDocente;
import Clases.IUsuario;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SQLUsuarioFactory extends BD.Conexion {

    public static int RegistrarUsuario(JTextField txtNombre, JComboBox<String> comboTipoIdentificación, JTextField txtNúmeroIdentificación,
            JTextField txtCorreoPersonal, JTextField txtTeléfono, JDateChooser jcalendarNacimiento, JComboBox<String> comboSexo,
            JComboBox<String> comboEps, UsuarioFactory factory, JTextField txtRol, JComboBox<String> comboPrograma) throws SQLException {

        IUsuario usuario = factory.crearUsuario(txtRol.getText(), txtNombre.getText(), comboTipoIdentificación.getSelectedItem().toString(),
                txtNúmeroIdentificación.getText(), txtCorreoPersonal.getText(), txtTeléfono.getText(),
                new Date(jcalendarNacimiento.getDate().getTime()),
                comboSexo.getSelectedItem().toString(),
                comboEps.getSelectedItem().toString(),
                comboPrograma.getSelectedItem().toString(),
                "",
                "",
                "",
                "",
                txtRol.getText());
        Connection conn = new Conexion().conectar();
        String sql = "INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps) "
                + "VALUES ("
                + "(SELECT id FROM Rol WHERE nombre = ?), "
                + "?, "
                + "(SELECT id FROM tipo_identificacion WHERE nombre = ?), "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "(SELECT id FROM Sexo WHERE nombre = ?), "
                + "(SELECT id FROM Eps WHERE nombre = ?)"
                + ")";

        int nuevoIdUsuario = -1;

        try (PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, txtRol.getText());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getTidentificacion());
            pstmt.setString(4, usuario.getIdentificacion());
            pstmt.setString(5, usuario.getCorreo());
            pstmt.setString(6, usuario.getTelefono());
            pstmt.setDate(7, new Date(jcalendarNacimiento.getDate().getTime()));
            pstmt.setString(8, comboSexo.getSelectedItem().toString());
            pstmt.setString(9, comboEps.getSelectedItem().toString());

            pstmt.executeUpdate();

            ResultSet identificadorRegistroU = pstmt.getGeneratedKeys();
            if (identificadorRegistroU.next()) {
                nuevoIdUsuario = identificadorRegistroU.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID del usuario.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            throw e;
        }

        return nuevoIdUsuario;
    }

    public static void RegistrarDocente(Connection conn, int idUsuario, UsuarioFactory factory, JComboBox<String> comboEspecialidad,
            JComboBox comboPrograma, JTextField txtCodigoInstitucional, JTextField txtCorreoInstitucional,
            JTextField txtContraseña, IUsuario usuario) throws SQLException {
        if (usuario instanceof CConcretaDocente) {

            String especialidad = (String) comboEspecialidad.getSelectedItem();
            String programa = (String) comboPrograma.getSelectedItem();
            String codigoInstitucional = txtCodigoInstitucional.getText();
            String correoInstitucional = txtCorreoInstitucional.getText();
            String contrasena = txtContraseña.getText();
            System.out.println();
            System.out.println(usuario.getCorreo());

            String sql = "INSERT INTO Docente (id_usuario, id_especialidad, id_programa, codigo_institucional, correo_institucional, contraseña) "
                    + "VALUES ("
                    + "?, "
                    + "(SELECT id FROM especialidad WHERE nombre = ?), "
                    + "(SELECT id FROM programa WHERE nombre = ?), "
                    + "?, "
                    + "?, "
                    + "?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idUsuario);
                pstmt.setString(2, especialidad);
                pstmt.setString(3, programa);
                pstmt.setString(4, codigoInstitucional);
                pstmt.setString(5, correoInstitucional);
                pstmt.setString(6, contrasena);

                int temp = pstmt.executeUpdate();
                if (temp == 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear correctamente");
                }
                JOptionPane.showMessageDialog(null, "Creado correctamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }

        }
    }

    public static void RegistrarAlumno(Connection conn, int idUsuario, UsuarioFactory factory, JComboBox comboPrograma,
            JTextField txtCodigoInstitucional, JTextField txtCorreoInstitucional, JTextField txtContraseña, IUsuario usuario) throws SQLException {
        if (usuario instanceof CConcretaAlumno) {

            String programa = (String) comboPrograma.getSelectedItem();
            String codigoInstitucional = txtCodigoInstitucional.getText();
            String correoInstitucional = txtCorreoInstitucional.getText();
            String contrasena = txtContraseña.getText();

            String sql = "INSERT INTO Alumno (id_usuario, id_programa, codigo_institucional, correo_institucional, contraseña) "
                    + "VALUES ("
                    + "?, "
                    + "(SELECT id FROM programa WHERE nombre = ?), "
                    + "?, "
                    + "?, "
                    + "?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idUsuario);
                pstmt.setString(2, programa);
                pstmt.setString(3, codigoInstitucional);
                pstmt.setString(4, correoInstitucional);
                pstmt.setString(5, contrasena);

                int temporal = pstmt.executeUpdate();
                if (temporal == 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear correctamente");
                }

                JOptionPane.showMessageDialog(null, "Creado Correctamente");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public boolean MostrarAlumno(JTable jTable1) {
        String sql = "SELECT "
                + "  a.id,"
                + "  u.nombre_completo, "
                + "  ti.nombre AS tipo_identificacion, "
                + "  u.numero_identificacion,"
                + "  u.correo_personal, "
                + "  u.telefono, "
                + "  u.fecha_nacimiento, "
                + "  s.nombre AS sexo, "
                + "  e.nombre AS eps, "
                + "  prog.nombre AS programa, "
                + "  a.codigo_institucional, "
                + "  a.correo_institucional, "
                + "  a.contraseña "
                + "FROM "
                + "  Usuario u "
                + "  JOIN Alumno a ON u.id = a.id_usuario "
                + "  JOIN Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "  JOIN Sexo s ON u.id_sexo = s.id "
                + "  JOIN Eps e ON u.id_eps = e.id "
                + "  JOIN Programa prog ON a.id_programa = prog.id"
                + " WHERE estado = 'activo'; ";

        Conexion con = new Conexion();
        Connection cox = con.conectar();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nombre Completo");
        model.addColumn("Tipo de Identificación");
        model.addColumn("Numero de Identificación");
        model.addColumn("Correo Personal");
        model.addColumn("Teléfono");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Sexo");
        model.addColumn("EPS");
        model.addColumn("Programa");
        model.addColumn("Código Institucional");
        model.addColumn("Correo Institucional");
        model.addColumn("Contraseña");

        jTable1.setModel(model);

        try (Statement st = cox.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] datos = new String[13];
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombre_completo");
                datos[2] = rs.getString("tipo_identificacion");
                datos[3] = rs.getString("numero_identificacion");
                datos[4] = rs.getString("correo_personal");
                datos[5] = rs.getString("telefono");
                datos[6] = rs.getDate("fecha_nacimiento").toString();
                datos[7] = rs.getString("sexo");
                datos[8] = rs.getString("eps");
                datos[9] = rs.getString("programa");
                datos[10] = rs.getString("codigo_institucional");
                datos[11] = rs.getString("correo_institucional");
                datos[12] = rs.getString("contraseña");

                model.addRow(datos);
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos del alumno: " + e.getMessage());
            return false;
        }
    }

    public static void cargarDatosAlumno(int alumnoId, JTextField txtNombre, JComboBox<String> comboTipoIdentificacion, JTextField txtNumeroIdentificacion,
            JTextField txtCorreoPersonal, JTextField txtTelefono, JDateChooser jcalendarNacimiento,
            JComboBox<String> comboSexo, JComboBox<String> comboEps,
            JComboBox comboPrograma, JTextField txtCodigoInstitucional,
            JTextField txtCorreoInstitucional, JTextField txtContraseña) throws SQLException {

        Connection conn = new Conexion().conectar();

        String sql = "SELECT "
                + "u.id,"
                + "  u.nombre_completo, "
                + "  ti.nombre AS tipo_identificacion, "
                + "u.numero_identificacion,"
                + "  u.correo_personal, "
                + "  u.telefono, "
                + "  u.fecha_nacimiento, "
                + "  s.nombre AS sexo, "
                + "  e.nombre AS eps, "
                + "  prog.nombre AS programa, "
                + "  a.codigo_institucional, "
                + "  a.correo_institucional, "
                + "  a.contraseña "
                + "FROM "
                + "  Usuario u "
                + "  JOIN Alumno a ON u.id = a.id_usuario "
                + "  JOIN Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "  JOIN Sexo s ON u.id_sexo = s.id "
                + "  JOIN Eps e ON u.id_eps = e.id "
                + "  JOIN Programa prog ON a.id_programa = prog.id "
                + "WHERE a.id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, alumnoId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre_completo"));
                comboTipoIdentificacion.setSelectedItem(rs.getString("tipo_identificacion"));
                txtNumeroIdentificacion.setText(rs.getString("numero_identificacion"));
                txtCorreoPersonal.setText(rs.getString("correo_personal"));
                txtTelefono.setText(rs.getString("telefono"));
                jcalendarNacimiento.setDate(rs.getDate("fecha_nacimiento"));
                comboSexo.setSelectedItem(rs.getString("sexo"));
                comboEps.setSelectedItem(rs.getString("eps"));
                comboPrograma.setSelectedItem(rs.getString("programa"));
                txtCodigoInstitucional.setText(rs.getString("codigo_institucional"));
                txtCorreoInstitucional.setText(rs.getString("correo_institucional"));
                txtContraseña.setText(rs.getString("contraseña"));
            } else {
                throw new SQLException("No se encontró el alumno con el ID: " + alumnoId);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos del alumno: " + e.getMessage());

        }
    }

    public static void CargarDocente(int docenteId, JTextField txtNombre, JComboBox<String> comboTipoIdentificacion,
            JTextField txtNumeroIdentificacion, JTextField txtCorreoPersonal,
            JTextField txtTelefono, JDateChooser jcalendarNacimiento,
            JComboBox<String> comboSexo, JComboBox<String> comboEspecialidad,
            JComboBox<String> comboEps, JComboBox<String> comboPrograma,
            JTextField txtCodigoInstitucional, JTextField txtCorreoInstitucional,
            JTextField txtContraseña) throws SQLException {

        Connection conn = new Conexion().conectar();

        String sql = "SELECT "
                + "  u.nombre_completo, "
                + "  ti.nombre AS tipo_identificacion, "
                + "  u.numero_identificacion, "
                + "  u.correo_personal, "
                + "  u.telefono, "
                + "  u.fecha_nacimiento, "
                + "  s.nombre AS sexo, "
                + "  e.nombre AS eps, "
                + "  prog.nombre AS programa, "
                + "  es.nombre AS especialidad, "
                + "  a.codigo_institucional, "
                + "  a.correo_institucional, "
                + "  a.contraseña "
                + "FROM "
                + "  Usuario u "
                + "  JOIN Docente a ON u.id = a.id_usuario "
                + "  JOIN Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "  JOIN Sexo s ON u.id_sexo = s.id "
                + "  JOIN Eps e ON u.id_eps = e.id "
                + "  JOIN Programa prog ON a.id_programa = prog.id "
                + "  JOIN Especialidad es ON a.id_especialidad = es.id "
                + "WHERE a.id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, docenteId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                txtNombre.setText(rs.getString("nombre_completo"));
                comboTipoIdentificacion.setSelectedItem(rs.getString("tipo_identificacion"));
                txtNumeroIdentificacion.setText(rs.getString("numero_identificacion"));
                txtCorreoPersonal.setText(rs.getString("correo_personal"));
                txtTelefono.setText(rs.getString("telefono"));
                jcalendarNacimiento.setDate(rs.getDate("fecha_nacimiento"));
                comboSexo.setSelectedItem(rs.getString("sexo"));
                comboEps.setSelectedItem(rs.getString("eps"));
                comboPrograma.setSelectedItem(rs.getString("programa"));
                comboEspecialidad.setSelectedItem(rs.getString("especialidad"));
                txtCodigoInstitucional.setText(rs.getString("codigo_institucional"));
                txtCorreoInstitucional.setText(rs.getString("correo_institucional"));
                txtContraseña.setText(rs.getString("contraseña"));
            } else {
                throw new SQLException("No se encontró el docente con el ID: " + docenteId);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos del docente: " + e.getMessage());
            throw e;
        }
    }
    
     public static boolean Habilitar(int usuarioId) {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE `usuario` SET `estado`= 'activo' WHERE id = ?;";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            

            pstm.setInt(1, usuarioId);
            int filaActualizar = pstm.executeUpdate();
            return filaActualizar > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al habilitar: " + e.getMessage());
        }
        return false;

    }

    public static boolean desHabilitar(int usuarioId) {
        Connection conn = new Conexion().conectar();

        String sql = "UPDATE `usuario` SET `estado`= 'inactivo' WHERE id = ?;";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            

            pstm.setInt(1, usuarioId);
            int filaActualizar = pstm.executeUpdate();
            return filaActualizar > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al deshabilitar: " + e.getMessage());
        }
        return false;

    }

    public boolean CargarUsuario(JTable jTable1, JTextField txtId, JTextField txtRol) {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtId.setText(jTable1.getValueAt(filaSeleccionada, 0).toString());
            txtRol.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
        return false;

    }

    public static boolean modificarDocente(int docenteId, JTextField txtNombre, JComboBox<String> comboTipoIdentificacion,
            JTextField txtCorreoPersonal, JTextField txtNumeroIdentificacion, JTextField txtTelefono,
            JDateChooser jcalendarNacimiento, JComboBox<String> comboSexo,
            JComboBox<String> comboEps, JComboBox comboPrograma,
            JTextField txtCodigoInstitucional, JTextField txtCorreoInstitucional,
            JTextField txtContraseña) throws SQLException {

        Connection conn = new Conexion().conectar();

        String sql = "UPDATE Usuario u "
                + "JOIN Docente d ON u.id = d.id_usuario "
                + "SET "
                + "   u.nombre_completo = ?, "
                + "   u.id_tipo_identificacion = (SELECT id FROM Tipo_identificacion WHERE nombre = ?), "
                + "   u.numero_identificacion = ?, "
                + "   u.correo_personal = ?, "
                + "   u.telefono = ?, "
                + "   u.fecha_nacimiento = ?, "
                + "   u.id_sexo = (SELECT id FROM Sexo WHERE nombre = ?), "
                + "   u.id_eps = (SELECT id FROM Eps WHERE nombre = ?), "
                + "   d.id_programa = (SELECT id FROM Programa WHERE nombre = ?), "
                + "   d.codigo_institucional = ?, "
                + "   d.correo_institucional = ?, "
                + "   d.contraseña = ? "
                + "WHERE d.id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtNombre.getText());
            pstmt.setString(2, comboTipoIdentificacion.getSelectedItem().toString());
            pstmt.setString(3, txtNumeroIdentificacion.getText());
            pstmt.setString(4, txtCorreoPersonal.getText());
            pstmt.setString(5, txtTelefono.getText());
            pstmt.setDate(6, new Date(jcalendarNacimiento.getDate().getTime()));
            pstmt.setString(7, comboSexo.getSelectedItem().toString());
            pstmt.setString(8, comboEps.getSelectedItem().toString());
            pstmt.setString(9, (String) comboPrograma.getSelectedItem());
            pstmt.setString(10, txtCodigoInstitucional.getText());
            pstmt.setString(11, txtCorreoInstitucional.getText());
            pstmt.setString(12, txtContraseña.getText());
            pstmt.setInt(13, docenteId);

            int filaActualizar = pstmt.executeUpdate();
            return filaActualizar > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar docente: " + e.getMessage());
        }
        return false;
    }

    public static boolean modificarAlumno(int alumnoId, JTextField txtNombre, JComboBox<String> comboTipoIdentificación,
            JTextField txtCorreoPersonal, JTextField txtNumeroIdentificacion, JTextField txtTeléfono,
            JDateChooser jcalendarNacimiento, JComboBox<String> comboSexo,
            JComboBox<String> comboEps, JComboBox comboPrograma,
            JTextField txtCodigoInstitucional, JTextField txtCorreoInstitucional,
            JTextField txtContraseña) throws SQLException {

        Connection conn = new Conexion().conectar();

        String sql = "UPDATE Usuario u "
                + " JOIN Alumno a ON u.id = a.id_usuario "
                + " SET "
                + "   u.nombre_completo = ?, "
                + "   u.id_tipo_identificacion = (SELECT id FROM Tipo_identificacion WHERE nombre = ?), "
                + "   u.numero_identificacion = ?, "
                + "   u.correo_personal = ?, "
                + "   u.telefono = ?, "
                + "   u.fecha_nacimiento = ?, "
                + "   u.id_sexo = (SELECT id FROM Sexo WHERE nombre = ?), "
                + "   u.id_eps = (SELECT id FROM Eps WHERE nombre = ?), "
                + "   a.id_programa = (SELECT id FROM Programa WHERE nombre = ?), "
                + "   a.codigo_institucional = ?, "
                + "   a.correo_institucional = ?, "
                + "   a.contraseña = ? "
                + "WHERE a.id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtNombre.getText());
            pstmt.setString(2, comboTipoIdentificación.getSelectedItem().toString());
            pstmt.setString(3, txtNumeroIdentificacion.getText());
            pstmt.setString(4, txtCorreoPersonal.getText());
            pstmt.setString(5, txtTeléfono.getText());
            pstmt.setDate(6, new Date(jcalendarNacimiento.getDate().getTime()));
            pstmt.setString(7, comboSexo.getSelectedItem().toString());
            pstmt.setString(8, comboEps.getSelectedItem().toString());
            pstmt.setString(9, (String) comboPrograma.getSelectedItem());
            pstmt.setString(10, txtCodigoInstitucional.getText());
            pstmt.setString(11, txtCorreoInstitucional.getText());
            pstmt.setString(12, txtContraseña.getText());
            pstmt.setInt(13, alumnoId);

            int filaActualizar = pstmt.executeUpdate();
            return filaActualizar > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar alumno: " + e.getMessage());
            throw e;
        }
    }

    public boolean MostrarDocente(JTable jTable1) {
        String sql = "SELECT "
                + "d.id,"
                + "u.nombre_completo, "
                + "ti.nombre AS tipo_identificacion, "
                + "u.numero_identificacion, "
                + "u.correo_personal, "
                + "u.telefono, "
                + "u.fecha_nacimiento, "
                + "s.nombre AS sexo, "
                + "e.nombre AS eps, "
                + "esp.nombre AS especialidad, "
                + "prog.nombre AS programa, "
                + "d.codigo_institucional, "
                + "d.correo_institucional "
                + "FROM "
                + "usuario u "
                + "JOIN docente d ON u.id = d.id_usuario "
                + "JOIN tipo_identificacion ti ON u.id_tipo_identificacion = ti.id "
                + "JOIN sexo s ON u.id_sexo = s.id "
                + "JOIN eps e ON u.id_eps = e.id "
                + "JOIN especialidad esp ON d.id_especialidad = esp.id "
                + "JOIN programa prog ON d.id_programa = prog.id"
                + " WHERE estado = 'activo'; ";

        Conexion con = new Conexion();
        Connection cox = con.conectar();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nombre Completo");
        model.addColumn("Tipo de Identificación");
        model.addColumn("Número de Identificación");
        model.addColumn("Correo Personal");
        model.addColumn("Teléfono");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Sexo");
        model.addColumn("EPS");
        model.addColumn("Especialidad");
        model.addColumn("Programa");
        model.addColumn("Código Institucional");
        model.addColumn("Correo Institucional");

        jTable1.setModel(model);

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] datos = new String[13];
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombre_completo");
                datos[2] = rs.getString("tipo_identificacion");
                datos[3] = rs.getString("numero_identificacion");
                datos[4] = rs.getString("correo_personal");
                datos[5] = rs.getString("telefono");
                datos[6] = rs.getString("fecha_nacimiento");
                datos[7] = rs.getString("sexo");
                datos[8] = rs.getString("eps");
                datos[9] = rs.getString("especialidad");
                datos[10] = rs.getString("programa");
                datos[11] = rs.getString("codigo_institucional");
                datos[12] = rs.getString("correo_institucional");

                model.addRow(datos);
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            return false;
        }

    }

}
