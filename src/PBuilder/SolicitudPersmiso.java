package PBuilder;



public class SolicitudPersmiso extends Solicitud {

    private int dias;

    public SolicitudPersmiso() {
    }

    public SolicitudPersmiso(int dias, String codigo, String detalle) {
        super(codigo, detalle);
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
