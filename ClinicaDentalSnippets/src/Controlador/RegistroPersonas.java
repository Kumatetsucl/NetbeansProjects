package controlador;

import Modelo.Doctor;
import java.util.ArrayList;

public class RegistroPersonas {
    private ArrayList<Doctor> doctores;

    public RegistroPersonas() {
        doctores =new ArrayList<>();
    }
    
    ///////////////////////////
    public boolean Agregar(Doctor doc){
        if (existeDoctor(doc)==false) {
            doctores.add(doc);
            return true;
        }
        return false;
    }

    private boolean existeDoctor(Doctor doc) {
        for (Doctor item : doctores) {
            if (item.getId_doctor()==doc.getId_doctor()) {
                return true;
            }
        }
        return false;
    }
    public void listar(){
        for (Doctor item : doctores) {
            System.out.println(item.toString());
        }
    }
    public boolean Eliminar(int id_doctor){
        for (Doctor item : doctores) {
            if (item.getId_doctor()== id_doctor) {
                doctores.remove(item);
                return true;
            }
        }
        return false;
    }
 
}
