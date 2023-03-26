
package Interfaces;

import Modelo.Vehiculo;
import java.util.ArrayList;


public interface IDaoVehiculo {
    ArrayList<Vehiculo> Listar();
    Vehiculo Buscar(String Chasis);
    boolean Grabar(Vehiculo vehiculo);
    boolean modificar(Vehiculo vehiculo);
    boolean Eliminar(String Chasis);
}
