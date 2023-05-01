
package modelo;


public class Jugador {
    // atributos
    private String nombre;
    private int edad;
    private String posicion;
    private int num_camiseta;
    private boolean es_chileno;
    private int valor_pase;
    //constructores

    public Jugador() {
    }

    public Jugador(String nombre, int edad, String posicion, int num_camiseta, boolean es_chileno, int valor_pase) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.num_camiseta = num_camiseta;
        this.es_chileno = es_chileno;
        this.valor_pase = valor_pase;
    }
    //getters and setters (Accesadores y Mutadores)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getNum_camiseta() {
        return num_camiseta;
    }

    public void setNum_camiseta(int num_camiseta) {
        this.num_camiseta = num_camiseta;
    }

    public boolean isEs_chileno() {
        return es_chileno;
    }

    public void setEs_chileno(boolean es_chileno) {
        this.es_chileno = es_chileno;
    }

    public int getValor_pase() {
        return valor_pase;
    }

    public void setValor_pase(int valor_pase) {
        this.valor_pase = valor_pase;
    }
    //toString()

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", edad=" + edad + ", posicion=" + posicion + ", num_camiseta=" + num_camiseta + ", es_chileno=" + es_chileno + ", valor_pase=" + valor_pase + '}';
    }
    
}
