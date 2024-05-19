package PBuilder;

public class SolicitudCertificado extends Solicitud {

    private Solicitud solicitud;
    private String tipo;

    public SolicitudCertificado() {
    }

    public SolicitudCertificado(Solicitud solicitud, String tipo, String codigo, String detalle) {
        super(codigo, detalle);
        this.solicitud = solicitud;
        this.tipo = tipo;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
