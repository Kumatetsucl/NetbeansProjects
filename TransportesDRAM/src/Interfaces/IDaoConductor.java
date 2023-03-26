
package Interfaces;

import Modelo.Conductor;
import java.util.ArrayList;

public interface IDaoConductor {
    ArrayList<Conductor> Listar();
    Conductor Buscar(String rut);
    boolean Grabar(Conductor conductor);
    boolean modificar(Conductor conductor);
    boolean Eliminar(String rut);      
}
