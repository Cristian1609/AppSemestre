package Clases;

import BD.Conexion;
import Builder.Solicitud;
import Builder.SolicitudCertificado;
import Builder.SolicitudPersmiso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLSolicitudes extends BD.Conexion {

    public void RegistrarSolicitud(Solicitud solicitud) {

        PreparedStatement ps = null;
        Connection conn = new Conexion().conectar();

        String sql = "";

        if (solicitud instanceof SolicitudCertificado) {
            sql = "INSERT INTO `solicitud_certificado`(`codigo_Alumno`, `tipo`, `detalle`) VALUES (?,?,?)";
        } else if (solicitud instanceof SolicitudPersmiso) {
            sql = "INSERT INTO `solicitud_permiso`(`codigo_Alumno`, `dias`, `detalle`) VALUES (?,?,?)";
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, solicitud.getCodigo());

            if (solicitud instanceof SolicitudCertificado) {
                pstmt.setString(2, ((SolicitudCertificado) solicitud).getTipo());
            } else if (solicitud instanceof SolicitudPersmiso) {
                pstmt.setInt(2, ((SolicitudPersmiso) solicitud).getDias());
            }
            pstmt.setString(3, solicitud.getDetalle());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Solicitud creada");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
}
