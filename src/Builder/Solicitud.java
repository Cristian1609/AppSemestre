package Builder;

public class Solicitud {

    private String codigo;
    private String detalle;

    public Solicitud() {
    }

    public Solicitud(String codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
