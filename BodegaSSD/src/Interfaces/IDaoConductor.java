
package Interfaces;

import Modelo.Proveedor;
import java.util.ArrayList;

public interface IDaoConductor {
    ArrayList<Proveedor> Listar();
    Proveedor Buscar(String rut);
    boolean Grabar(Proveedor conductor);
    boolean modificar(Proveedor conductor);
    boolean Eliminar(String rut);      
}
