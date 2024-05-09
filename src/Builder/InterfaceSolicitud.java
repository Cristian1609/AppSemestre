package Builder;

public interface InterfaceSolicitud {

    void setCodigoAlumno(String codigo);

    void setDetalle(String detalle);

    Solicitud build();
}
