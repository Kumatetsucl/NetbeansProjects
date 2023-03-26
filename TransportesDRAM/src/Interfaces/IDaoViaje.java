
package Interfaces;

import Modelo.Viaje;
import java.util.ArrayList;


public interface IDaoViaje {
    ArrayList<Viaje> Listar();
    Viaje Buscar(String Chasis);
    boolean Grabar(Viaje vehiculo);
    boolean modificar(Viaje vehiculo);
    boolean Eliminar(String Chasis);
}
