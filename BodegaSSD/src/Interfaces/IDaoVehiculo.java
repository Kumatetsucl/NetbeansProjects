
package Interfaces;

import Modelo.Productos;
import java.util.ArrayList;


public interface IDaoVehiculo {
    ArrayList<Productos> Listar();
    Productos Buscar(String Chasis);
    boolean Grabar(Productos vehiculo);
    boolean modificar(Productos vehiculo);
    boolean Eliminar(String Chasis);
}
