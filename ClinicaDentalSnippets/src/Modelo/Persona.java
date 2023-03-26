
package Modelo;


public abstract class Persona {
    private String Nombre;
    private int num_rut;
    private String Direccion;
    private int celular;

    public Persona() {
    }

    public Persona(String nombre, int num_rut, String Direccion, int celular) {
        this.Nombre = nombre;
        this.num_rut = num_rut;
        this.Direccion = Direccion;
        this.celular = celular;
    }

    public String getNombre() {
        return Nombre;
    }


    public int getNum_rut() {
        return num_rut;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public void setNum_rut(int num_rut) {
        this.num_rut = num_rut;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona{" + "PNombre=" + Nombre + ", num_rut=" + num_rut + ", Direccion=" + Direccion + ", celular=" + celular + '}';
    }
    
    public abstract String mensaje();
    
    
}
