package Factory;

import java.util.Date;

public abstract class ClaseUsuario implements IUsuario {

    protected String tipo;
    protected String rol;
    protected String nombre;
    protected String Tidentificacion;
    protected String identificacion;
    protected String correo;
    protected String telefono;
    protected Date nacimiento;
    protected String sexo;
    protected String eps;

    public ClaseUsuario() {
    }

    public ClaseUsuario(String tipo, String rol, String nombre, String Tidentificacion, String identificacion, String correo, String telefono, Date nacimiento, String sexo, String eps) {
        this.tipo = tipo;
        this.rol = rol;
        this.nombre = nombre;
        this.Tidentificacion = Tidentificacion;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.eps = eps;
    }

    @Override
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getTidentificacion() {
        return Tidentificacion;
    }

    public void setTidentificacion(String Tidentificacion) {
        this.Tidentificacion = Tidentificacion;
    }

    @Override
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

}
