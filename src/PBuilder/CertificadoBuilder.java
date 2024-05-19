package PBuilder;

public class CertificadoBuilder implements InterfaceSolicitud {

    private SolicitudCertificado sCertificado;

    public CertificadoBuilder() {
        this.sCertificado = new SolicitudCertificado();
    }

    @Override
    public void setCodigoAlumno(String codigo) {
        sCertificado.setCodigo(codigo);
    }

    @Override
    public void setDetalle(String detalle) {
        sCertificado.setDetalle(detalle);
    }

    @Override
    public Solicitud build() {
        return sCertificado;
    }

   

}
