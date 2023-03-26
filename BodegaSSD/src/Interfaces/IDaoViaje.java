
package Interfaces;

import Modelo.IngresoBodega;
import java.util.ArrayList;


public interface IDaoViaje {
    ArrayList<IngresoBodega> Listar();
    IngresoBodega Buscar(String Chasis);
    boolean Grabar(IngresoBodega vehiculo);
    boolean modificar(IngresoBodega vehiculo);
    boolean Eliminar(String Chasis);
}
