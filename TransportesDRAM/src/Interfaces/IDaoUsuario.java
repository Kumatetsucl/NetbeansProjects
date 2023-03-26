package Interfaces;

import Modelo.Persona;
import java.util.ArrayList;

public interface IDaoUsuario {
    ArrayList<Persona> Listar();
    Persona Buscar(String rut);
    boolean Grabar(Persona persona);
    boolean modificar(Persona persona);
    boolean Eliminar(String rut);  

}