package BD;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Test1 {

    @Test
    public void testConectar() {
        System.out.println("Prueba 1: Conectar a appsemestre");
        Conexion con = new Conexion();
        Connection conn = con.conectar();
        assertNotNull(conn);
        try {

            System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDesconectar() {
        System.out.println("Prueba 2: Desonectar de appsemestre");
        Conexion conexion = new Conexion();
        Connection conn = null;

        try {
            conn = conexion.conectar();
            assertNotNull(conn, "En este punto ya esta habilitada la conexion");
            conexion.deconectar();
            assertTrue(conn.isClosed(), "En este punto ya debe esta rdesabilitada l aconexion");
            System.out.println("En este punto la conexion ya es");
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

}
