
package modelo;

public class Torneo {
    //atributos
    private String nombre;
    private Club[] nro_club=new Club[16];
    //contructores

    public Torneo() {
    }

    public Torneo(String nombre) {
        this.nombre = nombre;
    }
    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Club[] getNro_club() {
        return nro_club;
    }

    public void setNro_club(Club[] nro_club) {
        this.nro_club = nro_club;
    }
    //toString()

    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", nro_club=" + nro_club + '}';
    }
    
}
