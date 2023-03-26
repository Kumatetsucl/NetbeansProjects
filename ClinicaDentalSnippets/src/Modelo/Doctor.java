
package Modelo;


public class Doctor extends Persona{
    private int id_doctor;
    private String Especialidad;
    private int Sueldo;

    public Doctor() {
    }

    public Doctor(int id_doctor, String Especialidad, int Sueldo, String nombre, int num_rut, String Direccion, int celular) {
        super(nombre, num_rut, Direccion, celular);
        this.id_doctor = id_doctor;
        this.Especialidad = Especialidad;
        this.Sueldo = Sueldo;
    }

    


    public String getEspecialidad() {
        return Especialidad;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public int getId_doctor() {
        return id_doctor;
    }
    
    
    
    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public void setSueldo(int Sueldo) {
        this.Sueldo = Sueldo;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }  

    @Override
    public String mensaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return super.toString()+"Doctor{" + "id_doctor=" + id_doctor + ", Especialidad=" + Especialidad + ", Sueldo=" + Sueldo + '}';
    }

    
}
