
package PStrategy;

import javax.swing.JTable;


public class Contexto {
    private IStrategy estrategia;
    
      public void setEstrategia(IStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void mostrarHorario(int idUsuario, JTable tabla) {
        estrategia.mostrarHorarioClases(idUsuario, tabla);
    }
}
