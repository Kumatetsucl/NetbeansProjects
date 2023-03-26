
package Modelo;


public class Proveedor extends Persona{
    private int idProveedor;
    
    public Proveedor() {
    }

    public Proveedor(int idProveedor, String Rut, String Nombre, String Direccion, int Edad, String Nacionalidad) {
        super(Rut, Nombre, Direccion, Edad, Nacionalidad);
        this.idProveedor = idProveedor;
    }


    public int getIdConductor() {
        return idProveedor;
    }

    public void setIdConductor(int idConductor) {
        this.idProveedor = idConductor;
    }

    @Override
    public String toString() {
        return super.toString()+"Conductor{" + "idConductor=" + idProveedor + '}';
    }

    @Override
    public void setNacionalidad(String Genero) {
        super.setNacionalidad(Genero); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getNacionalidad() {
        return super.getNacionalidad(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
