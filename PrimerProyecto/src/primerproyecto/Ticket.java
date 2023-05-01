
package primerproyecto;

public class Ticket {
    //atributos
    private int rut;
    private int numeroAsiento;
    private int valor;
    private String nombre;
    // metodo constructor
    // constructor sin parametros
    public Ticket() {
    }
    // constructor con parametros
    public Ticket(int rut, int numeroAsiento, int valor, String nombre) {
        this.rut = rut;
        this.numeroAsiento = numeroAsiento;
        this.valor = valor;
        this.nombre = nombre;
    }
    // sobrecarga de metodos 
    // ( 2 o mas metodos con mismo nombre,
    //   PERO distinta estructura)
    
    // metodo accesador

    public int getRut() {
        return rut;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
    // mutador

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setValor(int valor) {
        if(valor>=5000){
           this.valor = valor;
        }else{
            throw new IllegalArgumentException("valor debe ser mayor a 5.000");
        }
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ticket{" + "rut=" + rut + ", numeroAsiento=" + numeroAsiento + ", valor=" + valor + ", nombre=" + nombre + '}';
    }
    
    
}
