package Clases;

import PFactory.ClaseUsuario;
import java.util.Date;

public class CAdministrador extends ClaseUsuario {

    private String codigo_institucinal;
    private String correo_institucional;
    private String contraseña;

    public CAdministrador(String codigo_institucinal, String correo_institucional, String contraseña, String tipo, String rol, String nombre, String Tidentificacion, String identificacion, String correo, String telefono, Date nacimiento, String sexo, String eps) {
        super(tipo, rol, nombre, Tidentificacion, identificacion, correo, telefono, nacimiento, sexo, eps);
        this.codigo_institucinal = codigo_institucinal;
        this.correo_institucional = correo_institucional;
        this.contraseña = contraseña;
    }

    public CAdministrador() {
    }

    public String getCodigo_institucinal() {
        return codigo_institucinal;
    }

    public void setCodigo_institucinal(String codigo_institucinal) {
        this.codigo_institucinal = codigo_institucinal;
    }

    public String getCorreo_institucional() {
        return correo_institucional;
    }

    public void setCorreo_institucional(String correo_institucional) {
        this.correo_institucional = correo_institucional;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
