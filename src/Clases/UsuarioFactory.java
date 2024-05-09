package Clases;

import Factory.CConcretaAlumno;
import Factory.IUsuario;

public class UsuarioFactory {

    public IUsuario crearUsuario(String tipo) {
        if (tipo.equals("Alumno")) {
            System.out.println("Alumno creado");
            return new CConcretaAlumno();
            
        } else if (tipo.equals("Docente")) {
            System.out.println("Docente Creado");
        }
        return null;

    }
}
