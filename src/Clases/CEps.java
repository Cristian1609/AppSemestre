
package Clases;


public class CEps {
    
    private int id;
    private String nombre;

    public CEps(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CEps() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
