package Builder;



public class Director {

    private InterfaceSolicitud builder;

    public Director() {
    }

    public void Director(InterfaceSolicitud builder) {
        this.builder = builder;
    }

    public Solicitud LLenarSolicitud() {

        return builder.build();
    }

}
