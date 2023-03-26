
package Modelo;


public class Jugador {
    private String rut;
    private String nombre;
    private int numeroCamiseta;
    private int edad;
    private String posicion;
    private String categoria;
    private boolean sexo;

    public Jugador() {
    }

    public Jugador(String rut, String nombre, int numeroCamiseta, int edad, String posicion, String categoria, boolean sexo) {
        this.rut = rut;
        this.nombre = nombre;
        this.numeroCamiseta = numeroCamiseta;
        this.edad = edad;
        this.posicion = posicion;
        this.categoria = categoria;
        this.sexo = sexo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "rut=" + rut + ", nombre=" + nombre + ", numeroCamiseta=" + numeroCamiseta + ", edad=" + edad + ", posicion=" + posicion + ", categoria=" + categoria + ", sexo=" + sexo + '}';
    }

    
    
    
}
