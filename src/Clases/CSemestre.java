
package Clases;


public class CSemestre {
    
    private String anio;
    private String semestre;

    public CSemestre(String anio, String semestre) {
        this.anio = anio;
        this.semestre = semestre;
    }

    public CSemestre() {
    }
    

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    
}
