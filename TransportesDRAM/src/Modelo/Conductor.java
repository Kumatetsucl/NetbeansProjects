
package Modelo;


public class Conductor extends Persona{
    private int idConductor;
    
    public Conductor() {
    }

    public Conductor(int idConductor, String Rut, String Nombre, String Direccion, int Edad, String Genero) {
        super(Rut, Nombre, Direccion, Edad, Genero);
        this.idConductor = idConductor;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    @Override
    public String toString() {
        return super.toString()+"Conductor{" + "idConductor=" + idConductor + '}';
    }

    @Override
    public void setGenero(String Genero) {
        super.setGenero(Genero); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getGenero() {
        return super.getGenero(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setEdad(int Edad) {
        super.setEdad(Edad); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getEdad() {
        return super.getEdad(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setDireccion(String Direccion) {
        super.setDireccion(Direccion); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getDireccion() {
        return super.getDireccion(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setNombre(String Nombre) {
        super.setNombre(Nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getNombre() {
        return super.getNombre(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setRut(String Rut) {
        super.setRut(Rut); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getRut() {
        return super.getRut(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    

    
    
}
