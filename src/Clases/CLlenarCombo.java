package Clases;

import BD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CLlenarCombo {

    public void LlenarCombo(String tabla, String valor, JComboBox combo) {
        String sql = "select * from " + tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.conectar();

        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());

        }
    }

}
