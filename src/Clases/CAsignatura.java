package Clases;

public class CAsignatura {

    private String codigo;
    private String nombre;
    private String numeroCreditos;
    private String semestre;
    private String pensum;
    private String programa;

    public CAsignatura() {
    }

    public CAsignatura(String codigo, String nombre, String numeroCreditos, String semestre, String pensum, String programa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroCreditos = numeroCreditos;
        this.semestre = semestre;
        this.pensum = pensum;
        this.programa = programa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(String numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPensum() {
        return pensum;
    }

    public void setPensum(String pensum) {
        this.pensum = pensum;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

   
    
}
