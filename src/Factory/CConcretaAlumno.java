package Factory;

import java.util.Date;

public class CConcretaAlumno extends ClaseUsuario {

    protected String programa;
    protected String codigoInstitucional;
    protected String correoInstitucional;
    protected String contrasena;

    public CConcretaAlumno() {
    }

    public CConcretaAlumno(String programa, String codigoInstitucional, String correoInstitucional, String contrasena, String tipo, String rol, String nombre, String Tidentificacion, String identificacion, String correo, String telefono, Date nacimiento, String sexo, String eps) {
        super(tipo, rol, nombre, Tidentificacion, identificacion, correo, telefono, nacimiento, sexo, eps);
        this.programa = programa;
        this.codigoInstitucional = codigoInstitucional;
        this.correoInstitucional = correoInstitucional;
        this.contrasena = contrasena;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getCodigoInstitucional() {
        return codigoInstitucional;
    }

    public void setCodigoInstitucional(String codigoInstitucional) {
        this.codigoInstitucional = codigoInstitucional;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getRol() {
        return rol;
    }

    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getTidentificacion() {
        return Tidentificacion;
    }

    @Override
    public void setTidentificacion(String Tidentificacion) {
        this.Tidentificacion = Tidentificacion;
    }

    @Override
    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public Date getNacimiento() {
        return nacimiento;
    }

    @Override
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String getEps() {
        return eps;
    }

    @Override
    public void setEps(String eps) {
        this.eps = eps;
    }

}
