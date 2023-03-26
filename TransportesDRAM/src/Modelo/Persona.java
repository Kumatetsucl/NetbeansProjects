
package Modelo;


public abstract class Persona {
    private String Rut;
    private String Nombre;
    private String Direccion;
    private int Edad;
    private String Genero;

    public Persona() {
    }

    public Persona(String Rut, String Nombre, String Direccion, int Edad, String Genero) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Edad = Edad;
        this.Genero = Genero;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    @Override
    public String toString() {
        return "Persona{" + "Rut=" + Rut + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", Edad=" + Edad + ", Genero=" + Genero + '}';
    }
    
}
