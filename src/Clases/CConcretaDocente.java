package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CConcretaDocente extends ClaseUsuario {

    protected String especialidad;
    protected String programa;
    protected String codigI;
    protected String correoI;
    protected String contra;

    public CConcretaDocente() {
    }

    public CConcretaDocente(String especialidad, String programa, String codigI, String correoI, String contra, String tipo, String rol, String nombre, String Tidentificacion, String identificacion, String correo, String telefono, Date nacimiento, String sexo, String eps) {
        super(tipo, rol, nombre, Tidentificacion, identificacion, correo, telefono, nacimiento, sexo, eps);
        this.especialidad = especialidad;
        this.programa = programa;
        this.codigI = codigI;
        this.correoI = correoI;
        this.contra = contra;
    }

    public void mostrarInformacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Rol: " + this.rol);
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Programa: " + this.programa);
        System.out.println("Código Institucional: " + this.codigI);
        System.out.println("Correo Institucional: " + this.correoI);
        System.out.println("Contraseña: " + this.contra);
        System.out.println("Fecha de Nacimiento: " + sdf.format(this.nacimiento));
        System.out.println("Teléfono: " + this.telefono);
        System.out.println("EPS: " + this.eps);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getCodigI() {
        return codigI;
    }

    public void setCodigI(String codigI) {
        this.codigI = codigI;
    }

    public String getCorreoI() {
        return correoI;
    }

    public void setCorreoI(String correoI) {
        this.correoI = correoI;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
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
