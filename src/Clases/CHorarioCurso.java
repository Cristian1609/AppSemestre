package Clases;

import java.time.LocalTime;

public class CHorarioCurso {

    private String Curso;
    private String Docente;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public CHorarioCurso() {
    }

    public CHorarioCurso(String Curso, String Docente, String dia, LocalTime horaInicio, LocalTime horaFin) {
        this.Curso = Curso;
        this.Docente = Docente;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getDocente() {
        return Docente;
    }

    public void setDocente(String Docente) {
        this.Docente = Docente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

}
