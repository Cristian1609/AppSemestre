package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLAsignatura extends BD.Conexion {

    Connection con = conectar();
    PreparedStatement ps = null;

    public void mostrar(JTable tablaAsignaturas) {
        String sql = "SELECT "
           + "a.codigo, "
           + "a.nombre, "
           + "a.numero_creditos, "
           + "s.semestre AS nombre_semestre, "
           + "p.codigo AS nombre_pensum "
           + "FROM asignatura a "
           + "JOIN semestre s ON a.id_semestre = s.id "
           + "JOIN pensum p ON a.id_pensum = p.id";


        Conexion con = new Conexion();
        Connection cox = con.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("N° Créditos");
        model.addColumn("Semestre");
        model.addColumn("Pensum");

        tablaAsignaturas.setModel(model);
        String[] datos = new String[5];

        try {
            Statement st = cox.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("numero_creditos");
                datos[3] = rs.getString("nombre_semestre");
                datos[4] = rs.getString("nombre_pensum");
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
    }

   public void Registrar(CAsignatura cas, JTextField txtCodigo, JTextField txtNombre, JTextField txtNcreditos, 
                      JComboBox<String> semestre, JComboBox<String> pensum) {
    
    Connection con = new Conexion().conectar();
    
    String codigo = txtCodigo.getText();
    String nombre = txtNombre.getText();
    String numero_creditos = txtNcreditos.getText();
    String sem = (String) semestre.getSelectedItem();
    String pen = (String) pensum.getSelectedItem();
    
    if (!codigo.isEmpty() && !nombre.isEmpty() && !numero_creditos.isEmpty() && !sem.isEmpty() && !pen.isEmpty()) {
        
      
        String codTemp = "SELECT COUNT(*) FROM Asignatura WHERE codigo = ?";
        
        try (PreparedStatement temp = con.prepareStatement(codTemp)) {
            temp.setString(1, codigo);
            ResultSet rs = temp.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "El código ya está registrado. Elija otro.");
                return; 
            }
            
            rs.close();
            
           
            String sql = "INSERT INTO Asignatura (codigo, nombre, numero_creditos, id_semestre, id_pensum) "
                       + "VALUES (?, ?, ?, "
                       + "(SELECT id FROM Semestre WHERE semestre = ?), "
                       + "(SELECT id FROM Pensum WHERE codigo = ?))";
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, codigo);
                ps.setString(2, nombre);
                ps.setString(3, numero_creditos);
                ps.setString(4, sem);
                ps.setString(5, pen);
                ps.execute(); 
                
               
                cas.setCodigo(codigo);
                cas.setNombre(nombre);
                cas.setNumeroCreditos(numero_creditos);
                cas.setSemestre(sem);
                cas.setPensum(pen);
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso.");
                
                
                txtCodigo.setText("");
                txtNombre.setText("");
                txtNcreditos.setText("");
                semestre.setSelectedIndex(0);
                pensum.setSelectedIndex(0);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar: " + ex.getMessage());
        }
        
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
    }
}


    public void cargarDatosDesdeTabla(JTable tablaAsignaturas, JTextField txtCodigo, JTextField txtNombre, JTextField txtNcreditos, JComboBox<String> semestre, JComboBox<String> pensum) {

        int filaSeleccionada = tablaAsignaturas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtCodigo.setText(tablaAsignaturas.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tablaAsignaturas.getValueAt(filaSeleccionada, 1).toString());
            txtNcreditos.setText(tablaAsignaturas.getValueAt(filaSeleccionada, 2).toString());
            String semestreValor = tablaAsignaturas.getValueAt(filaSeleccionada, 3).toString();
            semestre.setSelectedItem(semestreValor);
            String pensumValor = tablaAsignaturas.getValueAt(filaSeleccionada, 4).toString();
            pensum.setSelectedItem(pensumValor);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para cargar datos");
        }
    }

    public void modificar(CAsignatura cas, JTextField txtCodigo, JTextField txtNombre, JTextField txtNcreditos, JComboBox<String> semestre, JComboBox<String> pensum) {
    String codigo = txtCodigo.getText();
    String nombre = txtNombre.getText();
    String numero_creditos = txtNcreditos.getText();
    String sem = (String) semestre.getSelectedItem();
    String pen = (String) pensum.getSelectedItem();

    if (!codigo.isEmpty() && !nombre.isEmpty() && !numero_creditos.isEmpty() && sem != null && pen != null) {
        String temp = "SELECT COUNT(*) FROM Asignatura WHERE codigo = ?";
        try (PreparedStatement psExists = con.prepareStatement(temp)) {
            psExists.setString(1, codigo);
            ResultSet rsExists = psExists.executeQuery();

            if (rsExists.next() && rsExists.getInt(1) == 0) {
                JOptionPane.showMessageDialog(null, "El código no está registrado.");
                return;
            }

            String sqlUpdate = "UPDATE Asignatura SET nombre = ?, numero_creditos = ?, id_semestre = (SELECT id FROM Semestre WHERE semestre = ?), id_pensum = (SELECT id FROM Pensum WHERE codigo = ?) WHERE codigo = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
                ps.setString(1, nombre);
                ps.setString(2, numero_creditos);
                ps.setString(3, sem);
                ps.setString(4, pen);
                ps.setString(5, codigo);
                ps.executeUpdate();

                cas.setCodigo(codigo);
                cas.setNombre(nombre);
                cas.setNumeroCreditos(numero_creditos);
                cas.setSemestre(sem);
                cas.setPensum(pen);

                JOptionPane.showMessageDialog(null, "Modificación exitosa");

                txtCodigo.setText("");
                txtNcreditos.setText("");
                txtNombre.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos");
    }
}


    public void eliminar(JTextField txtCodigo, JTextField txtNombre, JTextField txtNcreditos) {
        String codigo = txtCodigo.getText();

        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete el espacio");
            return;
        }

        try {
            String sql = "DELETE FROM Asignatura WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);

            int ejecutar = ps.executeUpdate();

            if (ejecutar > 0) {
                JOptionPane.showMessageDialog(null, "Asignatura eliminada");

                txtCodigo.setText("");
                txtNcreditos.setText("");
                txtNombre.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna asignatura con el código proporcionado.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
        }
    }
}
