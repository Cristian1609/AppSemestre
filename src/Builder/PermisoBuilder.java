package Builder;

public class PermisoBuilder implements InterfaceSolicitud {

    private SolicitudPersmiso sPermiso;

    
    public PermisoBuilder() {
        this.sPermiso = new SolicitudPersmiso();
    }

    
    @Override
    public void setDetalle(String detalle) {

        sPermiso.setDetalle(detalle);
    }

    @Override
    public void setCodigoAlumno(String codigo) {
        sPermiso.setCodigo(codigo);
    }

    @Override
    public Solicitud build() {
        return sPermiso;
    }
    
    public void setDias(int dias){
        sPermiso.setDias(dias);
    }
}
