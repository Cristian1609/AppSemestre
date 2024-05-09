package Factory;

import java.sql.Date;

public class UsuarioFactory  {

    public IUsuario crearUsuario(String tipo, String nombre, String tipoIdentificacion, String identificacion,
            String correo, String telefono, Date nacimiento, String sexo, String eps,
            String programa, String codigoInstitucional, String correoInstitucional,
            String contrasena, String especialidad,String rol) {
        if ("Docente".equalsIgnoreCase(tipo)) {

            return new CConcretaDocente(especialidad, programa, codigoInstitucional, correoInstitucional, contrasena,
                    "Docente", "Docente", nombre, tipoIdentificacion, identificacion, correo, telefono, nacimiento, sexo,
                    eps);

        } else if ("Alumno".equalsIgnoreCase(tipo)) {
            return new CConcretaAlumno(programa, codigoInstitucional, correoInstitucional, contrasena, "Alumno",
                    "Alumno", nombre, tipoIdentificacion, identificacion, correo, telefono, nacimiento, sexo, eps);
        }
        return null;
    }
}
