
package Clases;

public class CPensum {
    
    private String codigo;
    private String programa;

    public CPensum() {
    }

    public CPensum(String codigo, String programa) {
        this.codigo = codigo;
        this.programa = programa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    
    
}
