
package Modelo;

import Enumeradores.EnumPrevision;


public class Paciente extends Persona{
    
    private int id_paciente;
    private EnumPrevision prevision;
    
    public Paciente() {
    }

    public Paciente(int id_paciente, EnumPrevision prevision, String nombre, int num_rut, String Direccion, int celular) {
        super(nombre, num_rut, Direccion, celular);
        this.id_paciente = id_paciente;
        this.prevision = prevision;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public EnumPrevision getPrevision() {
        return prevision;
    }

    public void setPrevision(EnumPrevision prevision) {
        this.prevision = prevision;
    }

    @Override
    public String toString() {
        return super.toString()+"Paciente{" + "id_paciente=" + id_paciente + ", prevision=" + prevision + '}';
    }

     @Override
    public String mensaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
}